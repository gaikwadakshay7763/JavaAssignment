package com.example.headers;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import com.example.service.StudentService;



  public class HeaderInterceptor {
  
  @Autowired 
  private StudentService studentService;
  
 
  public  HeaderInterceptor() throws IOException { 
	 // TODOAuto-generated method stub
  
	  HttpHeaders headers = new HttpHeaders();
	  
	  headers.set("ApiIntegrationCode", "HUCXSL...");
	  headers.set("UserName", "fdfsk...");
	  headers.set("Secret", "yR*42...");
    }
  
   
  
  }
 
