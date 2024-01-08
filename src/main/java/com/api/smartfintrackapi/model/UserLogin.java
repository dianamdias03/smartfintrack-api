package com.api.smartfintrackapi.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;


@Entity
public class UserLogin {
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    
    private String username;

    private String password;

    private transient String confirmPassword;
    
    @OneToMany(mappedBy = "userLogin")
    private Set<Category> categories;

    @OneToMany(mappedBy = "userLogin")
    private Set<BudgetGroup> budgetGroups;

    @OneToMany(mappedBy = "userLogin")
    private Set<CashFlow> cashFlows;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<BudgetGroup> getBudgetGroups() {
		return budgetGroups;
	}

	public void setBudgetGroups(Set<BudgetGroup> budgetGroups) {
		this.budgetGroups = budgetGroups;
	}

	public Set<CashFlow> getCashFlows() {
		return cashFlows;
	}

	public void setCashFlows(Set<CashFlow> cashFlows) {
		this.cashFlows = cashFlows;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}     
	
	
}