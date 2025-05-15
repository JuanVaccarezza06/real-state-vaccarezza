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
        name = "tbl_property_adress"
)
public class PropertyAdressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="property_province",nullable = false)
    private String province;

    @Column(name = "property_city",nullable = false)
    private String city;

    @Column(name = "property_main_street",nullable = false)
    private String main_street;

    @Column(name = "property_secondary_street",nullable = false)
    private String secondary_street;

    @Column(name = "property_numering",nullable = false)
    private long numering;

    @Column(name = "property_zone",nullable = false)
    private String zone;

    @OneToOne
    @JoinColumn(name = "property_id",nullable = false)
    private PropertyEntity property;





}
