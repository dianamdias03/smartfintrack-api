package com.api.smartfintrackapi.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.smartfintrackapi.dtos.CashFlowDTO;
import com.api.smartfintrackapi.model.BudgetGroup;
import com.api.smartfintrackapi.model.CashFlow;
import com.api.smartfintrackapi.repository.CashFlowRepository;

@Service
public class CashFlowService {

	@Autowired
	CashFlowRepository cashFlowRepository;
	
	@Autowired 
	BudgetGroupService budgetGroupService;
	
	@Autowired
	CategoryService categoryService;
	
	public List<CashFlowDTO> getAllExpenses(Long userId){
		List<CashFlow> expenses = cashFlowRepository.findByIsRevenueFalseAndUserLoginId(userId);
		List<CashFlowDTO> dtos = new ArrayList<>();
		for (CashFlow expense : expenses) {
			dtos.add(convertToDto(expense));
		}
		return dtos;
	}
	
	public List<CashFlowDTO> getAllRevenues(Long userId){
		List<CashFlow> expenses = cashFlowRepository.findByIsRevenueTrueAndUserLoginId(userId);
		List<CashFlowDTO> dtos = new ArrayList<>();
		for (CashFlow expense : expenses) {
			dtos.add(convertToDto(expense));
		}
		return dtos;
	}
	
	public List<CashFlowDTO> getAllCashFlow(Long userId){
		List<CashFlow> expenses = cashFlowRepository.findByUserLoginId(userId);
		List<CashFlowDTO> dtos = new ArrayList<>();
		for (CashFlow expense : expenses) {
			dtos.add(convertToDto(expense));
		}
		return dtos;
	}
	
	public CashFlowDTO convertToDto(CashFlow cashFlow) {
        CashFlowDTO dto = new CashFlowDTO();
        dto.setId(cashFlow.getId());
        dto.setName(cashFlow.getName());
        dto.setCreationDate(cashFlow.getCreationDate());
        dto.setPaymentStatus(cashFlow.getPaymentStatus());
        dto.setDescription(cashFlow.getDescription());
        dto.setCashFlowValue(cashFlow.getCashFlowValue());
        dto.setTransactionDate(cashFlow.getTransactionDate());
        dto.setRevenue(cashFlow.isRevenue());

        if (cashFlow.getCategory() != null) {
            dto.setCategory(categoryService.convertToDto(cashFlow.getCategory()));
        }

        if (cashFlow.getBudgetGroup() != null) {
            dto.setBudgetGroup(budgetGroupService.convertToDto(cashFlow.getBudgetGroup()));
        }

        BigDecimal remainingBudget = calculateRemainingBudget(cashFlow.getBudgetGroup().getId(), cashFlow.isRevenue());
        dto.setRemainingBudget(remainingBudget);

        return dto;
    }
	
	public BigDecimal calculateRemainingBudget(Long budgetGroupId, boolean isRevenue) {
        if (budgetGroupId == null) {
            return BigDecimal.ZERO;
        }

        BudgetGroup budgetGroup = budgetGroupService.findById(budgetGroupId);

        if (budgetGroup == null || budgetGroup.getBudget() == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal totalCashFlows = budgetGroup.getListCashFlow().stream()
            .filter(Objects::nonNull)
            .map(cashFlow -> {
                BigDecimal value = cashFlow.getCashFlowValue();
                if (value == null) {
                    value = BigDecimal.ZERO;
                }
                return cashFlow.isRevenue() ? value : value.negate();
            })
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        return budgetGroup.getBudget().add(totalCashFlows);
    }	
	
	public BigDecimal getTotalRevenue(Long userLoginId) {
        return cashFlowRepository.totalRevenue(userLoginId);
    }

    public BigDecimal getTotalExpense(Long userLoginId) {
        return cashFlowRepository.totalExpense(userLoginId);
    }

    public BigDecimal getTotalRevenueLast30Days(Long userLoginId) {
        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
        return cashFlowRepository.totalRevenueLast30Days(thirtyDaysAgo, userLoginId);
    }

    public BigDecimal getTotalExpenseLast30Days(Long userLoginId) {
        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
        return cashFlowRepository.totalExpenseLast30Days(thirtyDaysAgo, userLoginId);
    }

    public BigDecimal getRemainingBalance(Long userLoginId) {
        BigDecimal totalRevenue = getTotalRevenue(userLoginId);
        BigDecimal totalExpense = getTotalExpense(userLoginId);
        return totalRevenue.subtract(totalExpense);
    }
    
    public BigDecimal getExpensePercentage(Long userLoginId) {
        BigDecimal totalRevenue = getTotalRevenue(userLoginId);
        BigDecimal totalExpense = getTotalExpense(userLoginId);

        // Evita divisão por zero
        if (totalRevenue.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        return totalExpense
                .divide(totalRevenue, 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100)); 
    }
}
