package com.example.trading_platform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trading_platform.model.Places;
import com.example.trading_platform.repository.PlacesDao;

@Service
public class PlacesService {
	
	@Autowired
	private PlacesDao placesDao;

	public void create(Places place) {
		placesDao.save(place);
	}

	public Optional<Places> retrieveOne(long placeId) {
		return placesDao.findById(placeId);
	}

	public void update(Places place) {
		placesDao.save(place);
		
	}

	public List<Places> retrieveAll() {
		return placesDao.findAll();
	}

	public void delete(long placeId) {
		placesDao.deleteById(placeId);
	}

}
