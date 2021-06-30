package com.example.trading_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trading_platform.model.Shares;

public interface SharesDao extends JpaRepository<Shares, Long> {

}
