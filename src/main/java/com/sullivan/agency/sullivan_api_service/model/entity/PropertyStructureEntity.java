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
        name = "tbl_property_structure"
)
public class PropertyStructureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="property_area",nullable = false)
    private double areaStructure;

    @Column(name = "property_total_area",nullable = false)
    private double totalArea;

    @Column(name = "property_rooms",nullable = false)
    private int rooms;

    @Column(name = "property_bathrooms",nullable = false)
    private int bathrooms;

    @Column(name = "property_bedrooms",nullable = false)
    private int bedrooms;

    @Column(name = "property_year_construction",nullable = false)
    private String yearConstruction;

    @OneToOne
    @JoinColumn(name = "property_id",nullable = false)
    private PropertyEntity property;

}
