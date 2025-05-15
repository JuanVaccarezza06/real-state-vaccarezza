package com.sullivan.agency.sullivan_api_service.model.repositories;

import com.sullivan.agency.sullivan_api_service.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Override
    List<UserEntity> findAll();
    @Override
    Optional<UserEntity> findById(Long aLong);

    @Override
    <S extends UserEntity> S save(S entity);

    @Override
    void delete(UserEntity entity);

}
