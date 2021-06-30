package com.example.trading_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trading_platform.model.Places;

public interface PlacesDao extends JpaRepository<Places, Long> {

}
