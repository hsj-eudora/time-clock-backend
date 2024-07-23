package com.example.timeclock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.timeclock.dto.LoginRequest;
import com.example.timeclock.dto.RegisterRequest;
import com.example.timeclock.entity.Member;
import com.example.timeclock.service.MemberService;

import io.swagger.annotations.ApiOperation;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
public class MemberController {

	@GetMapping("/home")
	public String home() {
		return "首頁";
	}
	
	@Autowired
	private MemberService memberService;
	
	@ApiOperation(" 註冊建立會員資料")
	@PostMapping("/signup") 
	public ResponseEntity<String> createMember(@Valid @RequestBody RegisterRequest registerRequest, BindingResult result) {//指示 Spring 從請求中讀取成員資料

		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getAllErrors().get(0).getDefaultMessage());
		}

	    try {
	        Member saveMember = memberService.createMember(registerRequest);
	        return ResponseEntity.ok("成功加入！你好：" + saveMember.getUsername());
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}
	
	@ApiOperation("會員修改個人資料")
	@PutMapping("/memberinfo/{id}")
	public ResponseEntity<Object> memberUpdate(@PathVariable Long id, @RequestBody Member memberInfo) {
		try {
			Member saveMember = memberService.updateMember(id, memberInfo);
			return ResponseEntity.ok(saveMember);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error","找不到"));		
		}
	  }	
	
	
	
	@ApiOperation("取得個別會員資料")
	@GetMapping("/memberinfo/{id}")
	public ResponseEntity<Object> memberInfo(@PathVariable Long id) {
		Optional<Member> member = memberService.member(id);
		
		return member.isPresent() 
				? ResponseEntity.ok(member.get())
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error","找不到"));
	}


	@ApiOperation("會員登入")
	@PostMapping("/login")
	public ResponseEntity<String> loginMember(@RequestBody LoginRequest loginRequest) {
	    Member member = memberService.loginMember(loginRequest.getUsername(), loginRequest.getPassword());
	    return member != null
		    		? ResponseEntity.ok("Hi," + member.getUsername())
		    		: ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	}

	@ApiOperation("會員總列表")
	@GetMapping("/members")
	public ResponseEntity<List<Member>> getMembers() {
		List<Member> members = memberService.listMembers();
		return ResponseEntity.ok(members);
	}
	
	
	
}
