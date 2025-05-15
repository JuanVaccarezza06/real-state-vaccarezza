package com.sullivan.agency.sullivan_api_service.model.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_credential"
)
public class CredentialEntity {

    @Id
    private Long id;

    @Column(name = "credential_username",nullable = false,unique = true)
    private String username;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false,unique = true)
    private UserEntity user;
}
