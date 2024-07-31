package com.example.timeclock.dto;

import jakarta.validation.constraints.NotBlank;

public class ProjectTypeRequest {
	
	@NotBlank(message = "不能為空")
	private String typeName;
	
//	private Long memberId; // 不需要從前端請求取得，因此為登入後才能使用，故在service取得當前已登入member資訊即可
	
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
