package com.sullivan.agency.sullivan_api_service.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.logging.log4j.util.Lazy;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_users"
)
public class UserEntity extends PersonEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(
            name = "user_first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "user_last_name",
            nullable = false
    )
    private String lastName;

    @Column(
            name = "user_email",
            nullable = false,
            unique = true
    )
    private String email;

    @Column(
            name = "user_phone",
            nullable = false,
            unique = true
    )
    private String number_phone;

        // Explicitly set fetch strategy; @OneToOne defaults to EAGER but lo marcamos para mayor claridad.
        @OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
        // Defines the foreign key column in this table that points to CredentialEntity (credential_id)
        @JoinColumn(name = "credential_id",nullable = false)
        private CredentialEntity credential;

    @OneToMany(
            mappedBy = "user"
            ,fetch = FetchType.LAZY,
            cascade = {
    CascadeType.REMOVE,CascadeType.MERGE}
    )
    private List<InquiryEntity> inquiries;

    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.REMOVE,CascadeType.MERGE}
    )
    private List<GeneralInquiryEntity> general_inquiries;
}
