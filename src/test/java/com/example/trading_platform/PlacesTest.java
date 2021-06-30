package com.example.trading_platform;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.trading_platform.model.Places;
import com.example.trading_platform.service.PlacesService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class PlacesTest {

	@Autowired
	private PlacesService placesService;

	@Test
	void test_thatAPlaceCanBePersisted() {
		Places place = new Places("London", "United Kingdom");
		placesService.create(place);
		assertTrue(place.getPlaceId() > 0);
	}

	@Test
	void test_thatAPlaceCanBeRetrievedById() {
		Places placeFromDb = placesService.retrieveOne(1).get();
		assertEquals(1, placeFromDb.getPlaceId());
	}

	@Test
	void test_thatAPlaceCanBeUpdated() {
		Places placeToUpdate = placesService.retrieveOne(2).get();
		String cityBeforeUpdate = placeToUpdate.getCity();
		placeToUpdate.setCity("updated city");
		placesService.update(placeToUpdate);
		Places updatePlaces = placesService.retrieveOne(2).get();
		String updatedCity = updatePlaces.getCity();
		assertNotEquals(updatedCity, cityBeforeUpdate);
	}

	@Test
	void test_thatAPlaceCanBeDeleted() {
		int numberBeforeDelete = placesService.retrieveAll().size();
		Long placeToDelete = placesService.retrieveOne(4).get().getPlaceId();
		placesService.delete(placeToDelete);
		int numberAfterDelete = placesService.retrieveAll().size();
		assertNotEquals(numberBeforeDelete, numberAfterDelete);
	}

}
