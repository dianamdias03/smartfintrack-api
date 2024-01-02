package com.api.smartfintrackapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.smartfintrackapi.repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;
	
	/*public List<Expense> getAllExpenses(){
		List<Expense> expenses = expenseRepository.findAll();
		BigDecimal totalExpenseValue = BigDecimal.ZERO;
		for (Expense expense : expenses) {
			expense.setRemainingBudget(expense.getBudgetGroup().getListExpense().stream()
                .map(Expense::getExpenseValue)
                .filter(value -> value != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
			
			for (Expense expenseByGroup : expense.getBudgetGroup().getListExpense()) {
                if (expenseByGroup.getExpenseValue() != null) {
                    totalExpenseValue = totalExpenseValue.add(expenseByGroup.getExpenseValue());
                    expense.setRemainingBudget(totalExpenseValue);
                }
            }
		}
		return expenses;
	}*/
	
}
