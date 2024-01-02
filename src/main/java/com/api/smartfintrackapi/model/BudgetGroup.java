package com.api.smartfintrackapi.model;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

@Entity
public class BudgetGroup {
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String description;
	
	private BigDecimal budget;
	
	@OneToMany(mappedBy = "budgetGroup", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Expense> listExpense;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getBudget() {
		return budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}

	public Set<Expense> getListExpense() {
		return listExpense;
	}

	public void setListExpense(Set<Expense> listExpense) {
		this.listExpense = listExpense;
	}
}
