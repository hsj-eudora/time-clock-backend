package com.example.timeclock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//下列標註exclude是排除登入8080時輸入用戶帳密
@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class} )
@ComponentScan(basePackages = "com.example.timeclock")
public class TimeclockApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeclockApplication.class, args);
	}

}
