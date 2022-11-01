package com.example.jwtUtil;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.services.CustomUserDetailsService;

@Component

public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private CustomUserDetailsService customeUserDetailsService;
	
	@Autowired
	private StudentJwtHelper studentJwtHelper;

	public String jwtToken;
	
	
	
	  
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken=null;
		
		if (requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer")) {
			
			jwtToken = requestTokenHeader.substring(7);
			
		
		
		try {
			username = this.studentJwtHelper.extractUsername(jwtToken);
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		UserDetails userDetails = this.customeUserDetailsService.loadUserByUsername(username);
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
		    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		    
		    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		} 
		else {
			System.out.println("token is not valid");
		}
		
		}
		
	
	
	filterChain.doFilter(request, response);
	
	}
	
	 public void doStoreToken(HttpServletRequest request, HttpServletResponse response) {
		 
		 String jwtToken;
		 String requestTokenHeader = request.getHeader("Authorization");
		 jwtToken = requestTokenHeader.substring(7);
		 
		 HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.add("thisiskey", "this is value");
	        headers.add("Authorization","Bearer"+ jwtToken);
	        System.out.println(jwtToken);
	 }
	

}


