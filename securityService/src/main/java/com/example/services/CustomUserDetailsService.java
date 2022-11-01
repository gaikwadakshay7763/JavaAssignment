package com.example.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.example.jwtUtil.StudentJwtHelper;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	StudentJwtHelper studentJwtHealper;
	
	@Value("${spring.security.user.name}")
	private String UserName;
	@Value("${spring.security.user.password}")
	private String Password;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		if (username.equals(UserName)) {
			return new User(UserName, Password, new ArrayList<>());
		} else {

			throw new UsernameNotFoundException("user not Found");
		}

	}

	/*
	 * public Header () {
	 * 
	 * String url = "http://localhost:7575/students";
	 * 
	 * //RestTemplate restTemplate = new RestTemplate(); //UserDetails userDetails =
	 * studentJwtHealper.loadUserByUsername( );
	 * 
	 * //String token = studentJwtHealper.generateToken(userDetails);
	 * 
	 * JwtRequest jwtRequest = new JwtRequest(UserName,Password);
	 * 
	 * HttpHeaders headers = new HttpHeaders();
	 * 
	 * 
	 * 
	 * UserDetails loadUserByUsername(String username) { // TODO Auto-generated
	 * method stub public return null; }
	 * 
	 * }
	 */
	
}
