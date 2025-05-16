package com.sullivan.agency.sullivan_api_service.model.repositories;

import com.sullivan.agency.sullivan_api_service.model.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<PropertyEntity,Long> {
    @Override
    <S extends PropertyEntity> S save(S entity);
}
