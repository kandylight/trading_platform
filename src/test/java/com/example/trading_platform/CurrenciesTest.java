package com.example.trading_platform;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.trading_platform.model.Currencies;
import com.example.trading_platform.service.CurrenciesService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class CurrenciesTest {

	@Autowired
	private CurrenciesService currenciesService;

	@Test
	void test_thatACurrencyCanBePersisted() {
		Currencies currency = new Currencies("$", "Dollar");
		currenciesService.create(currency);
		assertTrue(currency.getCurrencyId() > 0);
	}

	@Test
	void test_thatACurrencyCanBeRetrieved() {
		Currencies currencyFromDb = currenciesService.retrieveOne(1).get();
		assertEquals(1, currencyFromDb.getCurrencyId());
	}

	@Test
	void test_thatACurrencyCanBeUpadated() {
		Currencies currencyToUpdate = currenciesService.retrieveOne(1).get();
		String nameBeforeUpdate = currencyToUpdate.getName();
		currencyToUpdate.setName("updated name");
		currenciesService.update(currencyToUpdate);
		Currencies updatedCurrency = currenciesService.retrieveOne(1).get();
		String nameAfterUpdate = updatedCurrency.getName();
		assertNotEquals(nameAfterUpdate, nameBeforeUpdate);
	}

	@Test
	void test_thatACurrencyCanBeDeleted() {
		int numberBeforeDelete = currenciesService.retrieveAll().size();
		Long currecyToDelete = currenciesService.retrieveOne(5).get().getCurrencyId();
		currenciesService.delete(currecyToDelete);
		int numberAfterDelete = currenciesService.retrieveAll().size();
		assertNotEquals(numberBeforeDelete, numberAfterDelete);
	}

}
