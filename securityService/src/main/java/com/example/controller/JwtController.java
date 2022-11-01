package com.example.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.example.model.JwtRequest;
import com.example.demo.Student;
import com.example.jwtUtil.CustomHeaders;
import com.example.jwtUtil.JwtAuthenticationFilter;
import com.example.jwtUtil.StudentJwtHelper;
import com.example.model.JwtResponse;
import com.example.services.CustomUserDetailsService;

import io.jsonwebtoken.Header;



@RestController
@Component
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private StudentJwtHelper studentJwtHelper;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private CustomHeaders customHeaders;
	

	
    @Autowired
    private RestTemplate restTemplate;
    
	
	
	
	@PostMapping("/token")
	public  String  generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
	  System.out.println(jwtRequest);
	  try {
		  this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
	  } 
	  catch(UsernameNotFoundException e){
		  
		  e.printStackTrace(); 
		  throw new Exception("Bad credentials");
	  }catch(Exception e) {
		  e.printStackTrace();
		  throw new Exception("Bad Credentials");
	  }
	
	  //password username corret
	  UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
	  
	 // String requestKey = request.getHeader("Authorization");
	  
	  //if (requestKey == null) {
		 // System.out.println("token is not present");
		  
	 // }
	  
	  String token = this.studentJwtHelper.generateToken(userDetails);
	  
	  System.out.println("JWT" +token);
	  customHeaders.tokenStore.add(token);
	
	     return token;
	  
	  
          
	  
	  //{"token":"value"}
	  //HttpHeaders responseHeaders= new HttpHeaders();
	  
	  //responseHeaders.set("Authorization", "Bearer"+" "+token);
	  
	  //response.sendRedirect("/students");38781319
	  
	  //this.getResponceHeaderFromHttpRequest.setToken(token);
	  
	            //customHeaders.tokenStore.add(token);
	  
	// System.out.println( getResponceHeaderFromHttpRequest.tokenStore.get(0));
	  
	 // return (token);
	  
	  
	  
	   
	}
	
	
	
	@GetMapping("/students")
	public List<Student> getAllStudents(HttpServletResponse response,HttpServletRequest request ) throws Exception{
		
		//request.getHeader("Authorization");
		response.getHeader("Authorization");
		/*
		 * URL url = new URL("http://localhost:7575/students"); HttpURLConnection con =
		 * (HttpURLConnection) url.openConnection(); RestTemplate restTemplate = new
		 * RestTemplate();
		 * 
		 * con.setRequestProperty("","");
		 * 
		 * List<Student> students = this.restTemplate.getForObject(url , List.class);
		 * 
		 * //student.setTeacher(teachers); return students ;
		 */
		
		HttpHeaders headers = new HttpHeaders();
	      headers.set("Authorization","Bearer"+" "+customHeaders.tokenStore.get(0));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      System.out.println(headers.get("Authorization"));
	      
	      return restTemplate.exchange("http://localhost:7575/students", HttpMethod.GET, entity, List.class).getBody();
	}
	
	
	
	  @GetMapping("/student/{studentId}")
	  public ResponseEntity<Student> getStudentDetails(@PathVariable(value ="studentId") int studentId,HttpServletRequest request) {
		  
		  //String url ="https://localhost:7575/api/v1/nodes"; 
		  Enumeration<String> params = request.getHeaderNames(); 
			while(params.hasMoreElements()){
			 String paramName = params.nextElement();
			 System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
			}
		  
		  int URI = studentId;
	  
	  
		  Student students = this.restTemplate.getForObject("http://localhost:7575/student/{studentId}", Student.class,URI);
	  
	          return new ResponseEntity<Student>(students, HttpStatus.OK); 
	 }
	  
	 
	  
	  @PostMapping("/addStudent") 
	  public ResponseEntity<Student> addStudent(@RequestBody Student student, HttpServletRequest request) throws URISyntaxException {
		 String url = "http://localhost:7575/addStudent";
		 //String uriPath = "/addStudent";
		  
		  
			 
			
	  Student students = this.restTemplate.postForObject("http://localhost:7575/addStudent", student, Student.class);
	 
	    return new ResponseEntity<Student>(student, HttpStatus.OK);
	  }
	
	  }
