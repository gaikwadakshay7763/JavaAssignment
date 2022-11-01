package com.example.config;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.jwtUtil.JwtAuthenticationFilter;
import com.example.jwtUtil.StudentJwtHelper;
import com.example.services.CustomUserDetailsService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class StudentSecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	 private CustomUserDetailsService customuserDetailsService;
	
	@Autowired
	private StudentJwtHelper studentJwtHelper;
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	 @Override
	 protected void configure(HttpSecurity http) throws Exception{
		 
		 http
		     .csrf()
		     .disable()
		     .cors()
		     .disable()
		     .authorizeRequests()
		     .antMatchers("/token","/students","/addStudent","/student/{studentId}").permitAll()
		     .anyRequest().authenticated()
		     .and()
		     .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	    http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
	    
	 
	 }
	 
	 
	 
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		 auth.userDetailsService(customuserDetailsService);  
	 }
	  
	@Bean
	 public PasswordEncoder passwordEncoder() {
		 return NoOpPasswordEncoder.getInstance();
	 }
	 
	 
	 @Bean( name="myAuthenticationManager")
	 @Override
	 public AuthenticationManager authenticationManagerBean() throws Exception {
	     return super.authenticationManagerBean();
	 }

	 /*public AuthenticationManager authenticationManagerBean() throws Exception{
		 return super.authenticationManagerBean();
	 }*/
	 
}
