package com.api.smartfintrackapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.api.smartfintrackapi.enums.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CashFlow {
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String description;
	
	private LocalDate creationDate;
	
	private LocalDate transactionDate;
	
	private PaymentStatus paymentStatus;
	
	private BigDecimal cashFlowValue;
	
	private boolean isRevenue;
	
	@ManyToOne
    @JoinColumn(name = "budgetGroupId")
	private BudgetGroup budgetGroup;
	
	@ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
	
	@ManyToOne
    @JoinColumn(name = "userLoginId", nullable = false)
    private UserLogin userLogin;
	
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BudgetGroup getBudgetGroup() {
		return budgetGroup;
	}

	public void setBudgetGroup(BudgetGroup budgetGroup) {
		this.budgetGroup = budgetGroup;
	}

	public BigDecimal getCashFlowValue() {
		return cashFlowValue;
	}

	public void setCashFlowValue(BigDecimal cashFlowValue) {
		this.cashFlowValue = cashFlowValue;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public boolean isRevenue() {
		return isRevenue;
	}

	public void setRevenue(boolean isRevenue) {
		this.isRevenue = isRevenue;
	}

	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
	
	
}
