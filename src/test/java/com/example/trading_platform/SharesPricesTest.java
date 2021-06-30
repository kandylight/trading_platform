package com.example.trading_platform;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.trading_platform.model.Shares;
import com.example.trading_platform.service.SharesService;

@SpringBootTest
class SharesPricesTest {

	@Autowired
	private SharesPricesService sharesPricesService;
	
	@Autowired
	private SharesService sharesService;
	
	@Test
	void test_thatASharesPriceCanBePersisted() {
		Shares share = sharesService.retrieveOne(1).get();
		SharesPrices sharesPrice = new SharesPrice(share, 468.15, "12-JUN-21", null);
		sharesPricesService.create(sharePrice);
		assertTrue(sharePrice.getTimeStart() > 0);
		
	}
	

}
