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
public class Expense {
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String description;
	
	private LocalDate creationDate;
	
	private LocalDate expiringDate;
	
	private PaymentStatus paymentStatus;
	
	private BigDecimal expenseValue;
	
	@ManyToOne
    @JoinColumn(name = "budgetGroupId")
	private BudgetGroup budgetGroup;
	
	@ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
	
	/*@Transient
    private BigDecimal remainingBudget;
*/
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

	public LocalDate getExpiringDate() {
		return expiringDate;
	}

	public void setExpiringDate(LocalDate expiringDate) {
		this.expiringDate = expiringDate;
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

	public BigDecimal getExpenseValue() {
		return expenseValue;
	}

	public void setExpenseValue(BigDecimal expenseValue) {
		this.expenseValue = expenseValue;
	}
}
