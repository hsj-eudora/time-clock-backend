package com.example.timeclock;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	
	@RequestMapping(value = "/")
	public String spring() {
		return "Spring Boot!!";
	}
	
	@RequestMapping(value = "/hello")
	public String hello() {
		return "Hello!!!!!!";
	}
	
}
