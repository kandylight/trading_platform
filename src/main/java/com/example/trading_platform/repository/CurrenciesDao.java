package com.example.trading_platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.trading_platform.model.Currencies;

public interface CurrenciesDao extends JpaRepository<Currencies, Long> {

	@Query(value = "SELECT currencyId FROM currencies c WHERE c.currencyId = :currencyId and exists "
			+ " (SELECT currencyId FROM shares WHERE currencyId = c.currencyId)", nativeQuery = true)

	List<Integer> checkForShares(@Param("currencyId") long currencyId);

}
