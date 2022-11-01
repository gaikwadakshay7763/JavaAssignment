package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.web.header.Header;
import org.springframework.web.client.RestTemplate;

import com.example.jwtUtil.CustomHeaders;

@SpringBootApplication
@EntityScan(basePackages="com.example.model")
@ComponentScan(basePackages = "com.example.jwtUtil")
@ComponentScan(basePackages = "com.example.config")
@ComponentScan(basePackages = "com.example.controller")
@ComponentScan(basePackages = "com.example.services")


public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
	@Autowired
	private CustomHeaders customHeaders;
	
	@Bean
	public RestTemplate restTemplate() {
		
		  return new RestTemplate();
	
	}

}
