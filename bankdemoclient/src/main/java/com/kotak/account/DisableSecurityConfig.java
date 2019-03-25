package com.kotak.account;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DisableSecurityConfig extends WebSecurityConfigurerAdapter  {
	 public void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
         .antMatchers("/**").permitAll();
 }

 @Bean
 @LoadBalanced
 RestTemplate restTemplate () {
         return new RestTemplate();
 }
}
