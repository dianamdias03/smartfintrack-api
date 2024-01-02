package com.api.smartfintrackapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.smartfintrackapi.model.BudgetGroup;

@Repository
public interface BudgetGroupRepository extends JpaRepository<BudgetGroup, Long>{
	Optional<BudgetGroup> findById(Long id);
}
