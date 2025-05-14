package com.sullivan.agency.sullivan_api_service.model.entity;

import com.sullivan.agency.sullivan_api_service.model.enums.AMENITIES;
import com.sullivan.agency.sullivan_api_service.model.enums.OPERATION_TYPE;
import com.sullivan.agency.sullivan_api_service.model.enums.PROPERTY_TYPE;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_property"
)
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "property_name", nullable = false)
    private String title;

    @Column(name = "property_description",nullable = false)
    private String description;

    @Column(name = "property_price",nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "property_type",nullable = false)
    private PROPERTY_TYPE propertyType;

    @Enumerated(EnumType.STRING)
    @Column(name = "property_operation_type",nullable = false)
    private OPERATION_TYPE operationType;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<AMENITIES> amenitiesList;

    @Column(name = "property_publication_date",nullable = false)
    private LocalDate publicationDate;

    @Column(name = "property_activity",nullable = false)
    private boolean active;

    @OneToMany(
            mappedBy = "property",
            fetch = FetchType.LAZY,
            cascade = {
            CascadeType.MERGE, CascadeType.PERSIST}
    )
    List<InquiryEntity> inquiryEntities;

    @ManyToOne
    @JoinColumn(name = "owner_id",nullable = false)
    private OwnerEntity owner;

    // List<Image?> imagesProperty;

    @OneToOne
    @JoinColumn(name ="property_structure",nullable = false)
    private PropertyStructureEntity propertyStructureEntity;

    @OneToOne
    @JoinColumn(name ="property_adress",nullable = false)
    private PropertyAdressEntity propertyAdressEntity;

}
