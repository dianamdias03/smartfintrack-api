package com.api.smartfintrackapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.smartfintrackapi.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{
	Optional<Expense> findById(Long id);
	List<Expense> findByBudgetGroupId(Long id);
}