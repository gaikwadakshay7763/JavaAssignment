package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.example.headers.CustomHeaders;
import com.example.headers.HeaderInterceptor;

@SpringBootApplication(scanBasePackages="com.example.demo")
@EntityScan(basePackages="com.example.model")
@ComponentScan(basePackages = "com.example.controller")
@ComponentScan(basePackages = "com.example.service")
@ComponentScan(basePackages = "com.example.headers")

public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		/*
		 * RestTemplate restTemplate = new RestTemplate();
		 * 
		 * HttpHeaders headers = new HttpHeaders();
		 * 
		 * headers.set("Authorization","Bearer"+" "+ customHeaders.tokenStore.get(0));
		 * 
		 * HttpEntity<String> httpEntity = new HttpEntity<>("some body", headers);
		 */
		 
		 //restTemplate.exchange(url, HttpMethod.PUT, httpEntity, String.class);
		return new RestTemplate();
	}
}
