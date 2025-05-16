package com.sullivan.agency.sullivan_api_service.model.repositories;

import com.sullivan.agency.sullivan_api_service.model.entity.InquiryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<InquiryEntity,Long> {
    @Override
    <S extends InquiryEntity> S save(S entity);
}
