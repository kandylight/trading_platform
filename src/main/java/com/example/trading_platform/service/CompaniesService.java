package com.example.trading_platform.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trading_platform.model.Companies;
import com.example.trading_platform.repository.CompaniesDao;

@Service
public class CompaniesService {
	
	private static Logger LOGGER = LogManager.getLogger(CompaniesService.class);

	@Autowired
	CompaniesDao companiesDao;

	public void create(Companies company) {
		companiesDao.save(company);

	}

	public Optional<Companies> retrieveOne(long companyId) {
		return companiesDao.findById(companyId);
	}

	public void update(Companies company) {
		companiesDao.save(company);
	}

	public List<Companies> retrieveAll() {
		return companiesDao.findAll();
	}

	public void delete(long companyId) {
		if (companiesDao.checkForShares(companyId).size() > 0) {
			LOGGER.info("Shares exist");
		} else {
			companiesDao.deleteById(companyId);
		}
	}

}
