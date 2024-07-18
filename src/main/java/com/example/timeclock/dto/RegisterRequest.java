package com.example.timeclock.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {
	
	@NotBlank(message = "用戶名不能為空")
	@Size(min = 3, max = 50, message = "請輸入3到50個字元內")
	private String username;
	
	@NotBlank(message = "密碼不能為空")
	@Size(min = 6, max = 500, message = "請輸入至少6個字元")
	private String password;
	
	@NotBlank(message = "E-mail不能為空")
	@Email(message = "E-mail格式錯誤")
	private String email;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
