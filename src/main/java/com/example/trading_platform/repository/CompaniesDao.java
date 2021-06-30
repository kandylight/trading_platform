package com.example.trading_platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.trading_platform.model.Companies;

public interface CompaniesDao extends JpaRepository<Companies, Long> {

	@Query(value = "SELECT companyId FROM companies c WHERE c.companyId = :companyId and exists "
			+ " (SELECT companyId FROM shares WHERE companyId = c.companyId)", nativeQuery = true)

	List<Integer> checkForShares(@Param("companyId") long companyId);

}
