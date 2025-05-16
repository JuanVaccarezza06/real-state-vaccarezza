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
    private Long id;

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

    @OneToOne()
    @JoinColumn(name = "credential_id",unique = true,nullable = true)
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
