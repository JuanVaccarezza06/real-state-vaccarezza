package com.sullivan.agency.sullivan_api_service.model.entity;

import com.sullivan.agency.sullivan_api_service.model.enums.STATE;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_inquiries"
)
public class InquiryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "inquiry_date")
    private LocalDate InquiryDate;

    @Column(nullable = false, length = 2000, name = "inquiry_message")
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "inquiry_state")
    private STATE state;

    // desde la entidad Inquiry
    @ManyToOne
    @JoinColumn(name="user_id") // preguntar si lo trae automaticamente
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;
}
