package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.headers.CustomHeaders;

@SuppressWarnings("deprecation")
@Component
public class MyInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	CustomHeaders customHeaders;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		  if (request.getServletPath().contains("/token/jwtRequest")) {
			  System.out.println("prehandler is bypassed");
		  }
		  else {
			  response.setHeader("Authorization", "Bearer"+" "+ customHeaders.tokenStore.get(0));
		 
	      //requestHeader.set("Authorization","Bearer"+" "+ customHeaders.tokenStore.get(0));
		  }
	    
	        
		return true;
		}

}