package com.example.timeclock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.timeclock.dto.LoginRequest;
import com.example.timeclock.dto.RegisterRequest;
import com.example.timeclock.entity.Member;
import com.example.timeclock.service.MemberService;

import jakarta.validation.Valid;

@RestController
public class MyController {

	@GetMapping("/home")
	public String home() {
		return "首頁";
	}
	
	@Autowired
	private MemberService memberService;
	
	/** Member Sign up */
	@PostMapping("/signup") 
	public String createMember(@Valid @RequestBody RegisterRequest registerRequest, BindingResult result) {//指示 Spring 從請求中讀取成員資料

		if (result.hasErrors()) {
			return result.getAllErrors().get(0).getDefaultMessage();
		}
		
		Member member = new Member();
		member.setUsername(registerRequest.getUsername());
		member.setPassword(registerRequest.getPassword());
		member.setEmail(registerRequest.getEmail());
		
		try {
		Member saveMember = memberService.createMember(member);
		return "成功加入！你好：" + saveMember.getUsername().toString();
		} catch (IllegalArgumentException e){
			return e.getMessage();
		}
	}
	
	/** Member login */
	@PostMapping("/login")
	public String loginMember(@RequestBody LoginRequest loginRequest) {
	    Member member = memberService.loginMember(loginRequest.getUsername(), loginRequest.getPassword());
	    if (member != null) {
	        return "登入成功：你好，" + member.getUsername();
	    } else {
	        return "登入失敗：找不到用戶";
	    }
	}
	
	/** Member list */
	@GetMapping("/members")
	public List<Member> getMembers(Member member) {
		return memberService.listMembers();
	}
}
