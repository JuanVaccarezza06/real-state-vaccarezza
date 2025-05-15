package com.sullivan.agency.sullivan_api_service.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_owner"
)
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Long id;

    @Column(
            name = "owner_first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "owner_last_name",
            nullable = false
    )
    private String lastName;

    @Column(
            name = "owner_email",
            nullable = false,
            unique = true
    )
    private String email;

    @Column(
            name = "owner_phone",
            nullable = false,
            unique = true
    )
    private String number_phone;

    @OneToMany(
    mappedBy = "owner",
    fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST,CascadeType.MERGE}
    )
    private List<PropertyEntity> propertyOwnerList;
}
