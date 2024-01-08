package com.api.smartfintrackapi.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.api.smartfintrackapi.enums.PaymentStatus;

public class CashFlowDTO {
	
	private Long id;
    private String name;
    private String description;
    private LocalDate creationDate;
    private LocalDate transactionDate;
    private PaymentStatus paymentStatus;
    private BigDecimal cashFlowValue;
    private BigDecimal remainingBudget;
    private CategoryDTO category;
    private BudgetGroupDTO budgetGroup;
    private boolean isRevenue;
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
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public BigDecimal getCashFlowValue() {
		return cashFlowValue;
	}
	public void setCashFlowValue(BigDecimal cashFlowValue) {
		this.cashFlowValue = cashFlowValue;
	}
	public BigDecimal getRemainingBudget() {
		return remainingBudget;
	}
	public void setRemainingBudget(BigDecimal remainingBudget) {
		this.remainingBudget = remainingBudget;
	}
	public CategoryDTO getCategory() {
		return category;
	}
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	public BudgetGroupDTO getBudgetGroup() {
		return budgetGroup;
	}
	public void setBudgetGroup(BudgetGroupDTO budgetGroup) {
		this.budgetGroup = budgetGroup;
	}
	public boolean isRevenue() {
		return isRevenue;
	}
	public void setRevenue(boolean isRevenue) {
		this.isRevenue = isRevenue;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
}
