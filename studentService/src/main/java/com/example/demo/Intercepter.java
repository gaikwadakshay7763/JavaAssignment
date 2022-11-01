package com.example.demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class Intercepter implements  WebMvcConfigurer {
@Autowired
MyInterceptor myinterceptor;

 @Override
  public void addInterceptors(InterceptorRegistry registry) {
	  
	  registry.addInterceptor(myinterceptor);
	  
  }
}
