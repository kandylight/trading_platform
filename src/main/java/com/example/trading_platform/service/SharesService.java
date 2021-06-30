package com.example.trading_platform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trading_platform.model.Shares;
import com.example.trading_platform.repository.SharesDao;

@Service
public class SharesService {

	@Autowired
	SharesDao sharesDao;

	public void create(Shares share) {
		sharesDao.save(share);
	}

	public Optional<Shares> retrieveOne(long shareId) {
		return sharesDao.findById(shareId);
	}

	public void update(Shares share) {
		sharesDao.save(share);
	}

	public List<Shares> retrieveAll() {
		return sharesDao.findAll();
	}

	public void delete(Long shareId) {
		sharesDao.deleteById(shareId);
	}

}
