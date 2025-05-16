package com.sullivan.agency.sullivan_api_service;

import com.sullivan.agency.sullivan_api_service.model.entity.*;
import com.sullivan.agency.sullivan_api_service.model.enums.AMENITIES;
import com.sullivan.agency.sullivan_api_service.model.enums.OPERATION_TYPE;
import com.sullivan.agency.sullivan_api_service.model.enums.PROPERTY_TYPE;
import com.sullivan.agency.sullivan_api_service.model.enums.STATE;
import com.sullivan.agency.sullivan_api_service.model.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.Local;


import java.time.LocalDate;
import java.time.Year;
import java.util.List;

@SpringBootTest
class SullivanApiServiceApplicationTests {

	@Autowired
	UserRepository user_repository;

	@Autowired
	CredentialRepository credential_repository;

	@Autowired
	PropertyRepository propertyRepository;

	@Autowired
	PropertyAdressRepository propertyAdressRepository;

	@Autowired
	PropertyStructureRepository propertyStructureRepository;

	@Autowired
	InquiryRepository inquiryRepository;

	@Autowired
	OwnerRepository ownerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void save() {

		// All the ids = null, are ids provided by the DB

		UserEntity u = UserEntity // a default user. Without credential.
				.builder()
				.id(null)
				.email("jprv@gmail.com")
				.firstName("Sonia")
				.lastName("Ramon")
				.credential(null)
				.number_phone("123456789")
				.build();
		user_repository.save(u);

		credential_repository.save( // a default credential linked with u.
				CredentialEntity
						.builder()
						.id(null)
						.creationDate(LocalDate.now())
						.username("JuanpitoLargo")
						.password("JuanpitoCorto")
						.user(u)
						.build()
		);

		OwnerEntity owner = OwnerEntity.builder() // a default owner.
				.id(null)
				.email("jprvv@gmail.com")
				.firstName("Juancitoo")
				.lastName("Ramoncitoo")
				.number_phone("6575345342")
				.build();
		ownerRepository.save(owner);

		PropertyEntity p = PropertyEntity.builder() // Default property linked with owner.
				.active(true)
				.amenitiesList(
						List.of(
								AMENITIES.GARAJE,
								AMENITIES.FREEZER,
								AMENITIES.OLLAS,
								AMENITIES.UTENSILIOS_COCINA
						)
				)
				.operationType(OPERATION_TYPE.VENTA)
				.price(567312D)
				.title("Campo en miramar")
				.propertyType(PROPERTY_TYPE.CASA)
				.publicationDate(LocalDate.now())
				.description("Mansa casa!! Nashe!!")
				.owner(owner)
				.build();
		propertyRepository.save(p);

		propertyAdressRepository.save( // Default property linked with p.
				PropertyAdressEntity.builder()
						.city("Mar del plata")
						.zone("Mogotes")
						.main_street("Carasa")
						.numering(9090)
						.id(null)
						.property(p)
						.province("Buenos aires")
						.secondary_street("Aguado")
						.build()
		);

		propertyStructureRepository.save( // Default property linked with p.
				PropertyStructureEntity.builder()
						.property(p)
						.areaStructure(657.8)
						.bathrooms(2)
						.bedrooms(3)
						.id(null)
						.totalArea(800.9)
						.rooms(4)
						.yearConstruction(1910)
						.build()
		);

		inquiryRepository.save( // Default inquiry linked with p and u.
				InquiryEntity.builder()
						.id(null)
						.InquiryDate(LocalDate.now())
						.message("Che me regalan el campo!?!?!")
						.state(STATE.PENDIENTE)
						.user(u)
						.property(p)
						.build()
		);
	}

	@Test
	void getOwnerWithProperties() {
		List<OwnerEntity> owners = ownerRepository.getOwnersWithProperties();
		System.out.println("Lista = ");
		owners.forEach(System.out::println);
	}






}
