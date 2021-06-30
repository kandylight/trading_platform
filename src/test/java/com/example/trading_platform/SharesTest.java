package com.example.trading_platform;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.trading_platform.model.Companies;
import com.example.trading_platform.model.Currencies;
import com.example.trading_platform.model.Shares;
import com.example.trading_platform.service.CompaniesService;
import com.example.trading_platform.service.CurrenciesService;
import com.example.trading_platform.service.SharesService;

@SpringBootTest
class SharesTest {

	@Autowired
	private SharesService sharesService;

	@Autowired
	private CompaniesService companiesService;

	@Autowired
	private CurrenciesService currenciesService;

	@Test
	void test_thatAShareCanBePersisted() {
		Companies company = companiesService.retrieveOne(4).get();
		Currencies currency = currenciesService.retrieveOne(2).get();
		Shares share = new Shares(company, currency);
		sharesService.create(share);
		assertTrue(share.getShareId() > 0);
	}

	@Test
	void test_thatAShareCanBeRetrieved() {
		Shares shareFromDb = sharesService.retrieveOne(8).get();
		assertEquals(8, shareFromDb.getShareId());
	}

	@Test
	void test_thatAShareCanBeUpadated() {
		Shares shareToUpdate = sharesService.retrieveOne(8).get();
		Companies companyIdBeforeUpdate = shareToUpdate.getCompany();
		Companies company = companiesService.retrieveOne(6).get();
		shareToUpdate.setCompany(company);
		sharesService.update(shareToUpdate);
		Shares updatedShare = sharesService.retrieveOne(8).get();
		Companies companyIdAfterUpdate = updatedShare.getCompany();
		assertNotEquals(companyIdBeforeUpdate, companyIdAfterUpdate);
	}

	@Test
	void test_thatAShareCanBeDeleted() {
		int numberBeforeDelete = sharesService.retrieveAll().size();
		Long shareToDelete = sharesService.retrieveOne(1).get().getShareId();
		sharesService.delete(shareToDelete);
		int numberAfterDelete = sharesService.retrieveAll().size();
		assertNotEquals(numberBeforeDelete, numberAfterDelete);
	}

}
