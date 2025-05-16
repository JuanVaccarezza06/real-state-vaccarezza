package com.sullivan.agency.sullivan_api_service.model.repositories;

import com.sullivan.agency.sullivan_api_service.model.entity.PropertyStructureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyStructureRepository extends JpaRepository<PropertyStructureEntity,Long> {
    @Override
    <S extends PropertyStructureEntity> S save(S entity);
}
