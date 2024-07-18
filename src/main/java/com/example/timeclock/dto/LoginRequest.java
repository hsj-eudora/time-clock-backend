package com.example.timeclock.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
	
	@NotBlank(message = "用戶名不能為空")
	private String username;
	
	@NotBlank(message = "密碼不能為空")
	private String password;
	
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
	

}
