package com.api.smartfintrackapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.smartfintrackapi.model.CashFlow;

public interface CashFlowRepository extends JpaRepository<CashFlow, Long>{
	Optional<CashFlow> findById(Long id);
	List<CashFlow> findByBudgetGroupId(Long id);
	List<CashFlow> findByIsRevenueFalseAndUserLoginId(Long userLoginId);
	List<CashFlow> findByIsRevenueTrueAndUserLoginId(Long userLoginId);
	List<CashFlow> findByUserLoginId(Long userId);
}