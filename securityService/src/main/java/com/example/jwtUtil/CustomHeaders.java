
 package com.example.jwtUtil; 
 import java.io.IOException; 
 import java.util.ArrayList;
 import javax.servlet.http.HttpServletRequest;
 import org.springframework.http.HttpHeaders; 
 import org.springframework.http.MediaType;
 import org.springframework.stereotype.Component;
  
  @Component
  
  public class CustomHeaders {
  
  String token;
  
  public ArrayList <String> tokenStore = new ArrayList<>();
  
  
  public void setToken(String token) { // TODO Auto-generated method stub
  
  
  tokenStore.add(token);
  
  System.out.println(tokenStore);
  
  }
  public String getToken() 
               { 
	String token = tokenStore.get(0); 
          return token;
  }
  
 }
 