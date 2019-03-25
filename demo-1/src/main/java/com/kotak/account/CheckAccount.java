package com.kotak.account;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckAccount {

	@RequestMapping("/accounts")
	public String getAccountNO()
	{
		
		return "0001501533538";
		
	}
}
