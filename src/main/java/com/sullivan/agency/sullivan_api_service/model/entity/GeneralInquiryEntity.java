package com.sullivan.agency.sullivan_api_service.model.entity;

import com.sullivan.agency.sullivan_api_service.model.enums.MOTIVE_INQUIRY;
import com.sullivan.agency.sullivan_api_service.model.enums.STATE;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tbl_general_inquiries")
public class GeneralInquiryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "inquiry_motive")
    private MOTIVE_INQUIRY motive;

    @Column(name ="general_inquiry_description",nullable = false)
    private String description;

    @Column(name="general_inquiry_date",nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "state_general_inquiry",nullable = false)
    private STATE state;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

}
