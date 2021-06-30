package com.example.trading_platform;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.trading_platform.model.Companies;
import com.example.trading_platform.model.Places;
import com.example.trading_platform.service.CompaniesService;
import com.example.trading_platform.service.PlacesService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class CompaniesTest {

	@Autowired
	private CompaniesService companiesService;

	@Autowired
	private PlacesService placesService;

	@Test
	void test_thatACompanyCanBePersisted() {
		Places place = placesService.retrieveOne(1).get();
		Companies company = new Companies("British Airways", place);
		companiesService.create(company);
		assertTrue(company.getCompanyId() > 0);
	}

	@Test
	void test_thatACompanyCanBeRetrievedById() {
		Companies companyFromDb = companiesService.retrieveOne(1).get();
		assertEquals(1, companyFromDb.getCompanyId());
	}

	@Test
	void test_thatACompanyCanBeUpdated() {
		Companies companyToUpdate = companiesService.retrieveOne(1).get();
		String nameBeforeUpdate = companyToUpdate.getName();
		companyToUpdate.setName("updated name");
		companiesService.update(companyToUpdate);
		Companies updateCompany = companiesService.retrieveOne(1).get();
		String updatedName = updateCompany.getName();
		assertNotEquals(updatedName, nameBeforeUpdate);
	}

	@Test
	void test_thatACompanyCanBeDeleted() {
		int numberBeforeDelete = companiesService.retrieveAll().size();
		Long companyToDelete = companiesService.retrieveOne(9).get().getCompanyId();
		companiesService.delete(companyToDelete);
		int numberAfterDelete = companiesService.retrieveAll().size();
		assertNotEquals(numberBeforeDelete, numberAfterDelete);
	}

}
