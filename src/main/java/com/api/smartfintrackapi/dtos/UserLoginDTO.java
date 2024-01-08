package com.api.smartfintrackapi.dtos;

public class UserLoginDTO {
	private Long id;
	private Boolean sucessLogin;
	private String username;
	private String errorMessage;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getSucessLogin() {
		return sucessLogin;
	}
	public void setSucessLogin(Boolean sucessLogin) {
		this.sucessLogin = sucessLogin;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
