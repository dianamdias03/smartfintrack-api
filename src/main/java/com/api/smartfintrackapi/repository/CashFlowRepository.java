package com.api.smartfintrackapi.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.smartfintrackapi.model.CashFlow;

public interface CashFlowRepository extends JpaRepository<CashFlow, Long>{
	Optional<CashFlow> findById(Long id);
	List<CashFlow> findByBudgetGroupId(Long id);
	List<CashFlow> findByIsRevenueFalseAndUserLoginId(Long userLoginId);
	List<CashFlow> findByIsRevenueTrueAndUserLoginId(Long userLoginId);
	List<CashFlow> findByUserLoginId(Long userId);
	
	@Query("SELECT COALESCE(SUM(c.cashFlowValue), 0) FROM CashFlow c WHERE c.isRevenue = true AND c.userLogin.id = :userLoginId")
    BigDecimal totalRevenue(Long userLoginId);

    @Query("SELECT COALESCE(SUM(c.cashFlowValue), 0) FROM CashFlow c WHERE c.isRevenue = false AND c.userLogin.id = :userLoginId")
    BigDecimal totalExpense(Long userLoginId);

    @Query("SELECT COALESCE(SUM(c.cashFlowValue), 0) FROM CashFlow c WHERE c.isRevenue = true AND c.transactionDate >= :startDate AND c.userLogin.id = :userLoginId")
    BigDecimal totalRevenueLast30Days(LocalDate startDate, Long userLoginId);

    @Query("SELECT COALESCE(SUM(c.cashFlowValue), 0) FROM CashFlow c WHERE c.isRevenue = false AND c.transactionDate >= :startDate AND c.userLogin.id = :userLoginId")
    BigDecimal totalExpenseLast30Days(LocalDate startDate, Long userLoginId);
}