package com.api.smartfintrackapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.smartfintrackapi.dtos.BudgetGroupDTO;
import com.api.smartfintrackapi.model.BudgetGroup;
import com.api.smartfintrackapi.repository.BudgetGroupRepository;

@Service
public class BudgetGroupService {
	
	@Autowired
	BudgetGroupRepository budgetGroupRepository;
	
	public BudgetGroupDTO convertToDto(BudgetGroup budgetGroup) {
        BudgetGroupDTO dto = new BudgetGroupDTO();
        dto.setId(budgetGroup.getId());
        dto.setName(budgetGroup.getName());
        dto.setDescription(budgetGroup.getDescription());
        dto.setBudget(budgetGroup.getBudget()); 
        dto.setHasRelatedData(budgetGroup.getListCashFlow() != null && !budgetGroup.getListCashFlow().isEmpty());
        return dto;
    }
	
	public List<BudgetGroupDTO> findAllBudgetGroups(Long userLoginId) {
		List<BudgetGroup> budgetGroups = budgetGroupRepository.findByUserLoginId(userLoginId);
		List<BudgetGroupDTO> dtos = new ArrayList<>();
		for (BudgetGroup group : budgetGroups) {
			dtos.add(convertToDto(group));
		}
		return dtos;
	}
	
	public BudgetGroup findById(Long id) {
		return budgetGroupRepository.findById(id).orElseThrow();
	}
}
