package com.sullivan.agency.sullivan_api_service.model.repositories;

import com.sullivan.agency.sullivan_api_service.model.entity.CredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CredentialRepository extends JpaRepository<CredentialEntity,Long> {

    @Override
    List<CredentialEntity> findAll();

    @Override
    Optional<CredentialEntity> findById(Long aLong);

    @Override
    <S extends CredentialEntity> S save(S entity);

    @Override
    void delete(CredentialEntity entity);

}
