package com.sullivan.agency.sullivan_api_service.model.repositories;

import com.sullivan.agency.sullivan_api_service.model.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OwnerRepository extends JpaRepository<OwnerEntity,Long> {
    @Override
    <S extends OwnerEntity> S save(S entity);

    @Query("""
    SELECT DISTINCT o
      FROM OwnerEntity o
      LEFT JOIN FETCH o.propertyOwnerList p
    """)
    List<OwnerEntity> getOwnersWithProperties();
}
