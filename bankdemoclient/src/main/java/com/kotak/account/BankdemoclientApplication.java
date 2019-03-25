package com.kotak.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class BankdemoclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankdemoclientApplication.class, args);
	}

}
