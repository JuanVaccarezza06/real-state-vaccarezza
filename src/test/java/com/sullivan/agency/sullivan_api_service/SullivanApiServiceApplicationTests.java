package com.sullivan.agency.sullivan_api_service;

import com.sullivan.agency.sullivan_api_service.model.entity.CredentialEntity;
import com.sullivan.agency.sullivan_api_service.model.entity.UserEntity;
import com.sullivan.agency.sullivan_api_service.model.repositories.CredentialRepository;
import com.sullivan.agency.sullivan_api_service.model.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
class SullivanApiServiceApplicationTests {

	@Autowired
	UserRepository user_repository;

	@Autowired
	CredentialRepository credential_repository;

	@Test
	void contextLoads() {
	}

	@Test
	void save() {
		user_repository.save(
				UserEntity
				.builder()
				.id(null)
				.email("jprv@gmail.com")
				.firstName("Juan")
				.lastName("Ramon")
				.number_phone("123456789")
				.build()
		);

				user_repository.save(
						UserEntity
								.builder()
								.id(null)
								.email("jprvv@gmail.com")
								.firstName("Juan")
								.lastName("Ramon")
								.number_phone("123456749")
								.build()
		);

	}






}
