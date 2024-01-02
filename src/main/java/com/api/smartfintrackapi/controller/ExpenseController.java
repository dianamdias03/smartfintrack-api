package com.api.smartfintrackapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.smartfintrackapi.model.Expense;
import com.api.smartfintrackapi.repository.ExpenseRepository;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class ExpenseController {
	@Autowired
	ExpenseRepository expensesRepository;
	
	@GetMapping("/expenses")
	public List<Expense> listExpenses(){
		List<Expense> expenses = expensesRepository.findAll();
		/*BigDecimal totalExpenseValue = BigDecimal.ZERO;
		for (Expense expense : expenses) {
			for (Expense expenseByGroup : expense.getBudgetGroup().getListExpense()) {
                if (expenseByGroup.getExpenseValue() != null) {
                    totalExpenseValue = totalExpenseValue.add(expenseByGroup.getExpenseValue());
                    //expense.setRemainingBudget(totalExpenseValue);
                }
            }
		}*/
		return expenses;
	}
	
	@GetMapping("/expenses/{id}")
	public Optional<Expense> listExpenseUnic(@PathVariable(value="id") long id){
		return expensesRepository.findById(id);
	}
	
	@PostMapping("/expense")
	public Expense saveExpense(@RequestBody Expense expense) {
		return expensesRepository.save(expense);
	}
	
	@PostMapping("/expenses")
	public List<Expense> saveExpenses(@RequestBody List<Expense> expenses) {
		return expensesRepository.saveAll(expenses);
	}
	
	@DeleteMapping("/expenses")
	public void deleteExpenses(@RequestBody List<Long> data) {
		expensesRepository.deleteAllById(data);
	}
}
