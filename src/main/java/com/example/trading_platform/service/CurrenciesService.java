package com.example.trading_platform.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trading_platform.model.Currencies;
import com.example.trading_platform.repository.CurrenciesDao;

@Service
public class CurrenciesService {
	
	private static Logger LOGGER = LogManager.getLogger(CurrenciesService.class);
	
	@Autowired
	CurrenciesDao currenciesDao;

	public void create(Currencies currency) {
		currenciesDao.save(currency);
	}

	public Optional<Currencies> retrieveOne(long currencyId) {
		return currenciesDao.findById(currencyId);
	}

	public void update(Currencies currency) {
		currenciesDao.save(currency);
	}

	public List<Currencies> retrieveAll() {
		return currenciesDao.findAll();
	}

	public void delete(Long currencyId) {
		if (currenciesDao.checkForShares(currencyId).size() > 0) {
			LOGGER.info("Shares exist");
		} else {
			currenciesDao.deleteById(currencyId);
		}
		
	}
	
	
	
	

}
