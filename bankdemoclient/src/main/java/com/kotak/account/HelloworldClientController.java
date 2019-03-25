package com.kotak.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController

public class HelloworldClientController {
	@Autowired
    RestTemplate restTemplate;

    @GetMapping("/helloclient")
    @HystrixCommand(fallbackMethod = "getOfflineMessage")

    public String getMessage() {
    	System.out.println(">>>>"+restTemplate.getForEntity("http://BANKDEMO/accounts",String.class));
            return         restTemplate.getForObject("http://BANKDEMO/accounts",String.class );
    }
    public String getOfflineMessage() {
        return "Service is Offline Message";
}
}