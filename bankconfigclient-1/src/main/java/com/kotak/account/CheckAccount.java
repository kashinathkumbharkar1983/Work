package com.kotak.account;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@EnableAutoConfiguration

public class CheckAccount {

	@RequestMapping("/accounts")
	public String getAccountNO()
	{
		
		return "0001501533538";
		
	}
	 private String greeting;

	    public String getGreeting() {
	        return greeting;
	    }

	    @Value("${greeting}")
	    public void setGreeting(String greeting) {
	        this.greeting = greeting;
	    }

	    @RequestMapping("/hello")
		public String hello() {
			return String.format("%s There!", getGreeting());
		}
}
