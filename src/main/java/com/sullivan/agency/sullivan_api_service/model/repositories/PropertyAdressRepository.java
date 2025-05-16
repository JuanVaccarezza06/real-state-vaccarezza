package com.sullivan.agency.sullivan_api_service.model.repositories;

import com.sullivan.agency.sullivan_api_service.model.entity.PropertyAdressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyAdressRepository extends JpaRepository<PropertyAdressEntity,Long> {
    @Override
    <S extends PropertyAdressEntity> S save(S entity);
}
