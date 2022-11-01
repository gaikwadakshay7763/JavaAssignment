package com.example.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.JwtRequest;
import com.example.demo.Student;
import com.example.headers.CustomHeaders;
import com.example.service.StudentService;


@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private JwtRequest jwtRequest;
	
	@Autowired
	private CustomHeaders customHeaders;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private com.example.demo.Intercepter MyCustomHandlerInterceptor;
	
	@Value("${demo.student.user.name}")
	private String Username;
	 
	@Value("${demo.student.user.password}")
	private String Password;
		
		
		//HttpEntity entity = new HttpEntity(headers);
		
		
		
	@RequestMapping(value ="/token/jwtRequest",method = RequestMethod.POST)
	public ResponseEntity<Object> getTokenFromSpring(@RequestBody JwtRequest jwtRequest) {
		 
		
		String url ="http://localhost:8080/token";
		
		
      RestTemplate restTemplate = new RestTemplate();
		
		String token =  this.restTemplate.postForObject("http://localhost:8080/token",jwtRequest, String.class);
		
		customHeaders.tokenStore.add(token);
		
		
		
		return new ResponseEntity<>(token,HttpStatus.OK);
		
		
		
		
		
	}
	
	
	@GetMapping("/students")
	public ResponseEntity<Object> getAllStudents( HttpServletRequest request,HttpServletResponse responce ) throws Exception{
		
		System.out.println("header" + responce.getHeader("Authorization"));
		try {
			if(responce.getHeader("Authorization")!=null) {
				
		
	       //HttpHeaders requestHeader = new HttpHeaders();
	       //requestHeader.set("Authorization","Bearer"+" "+ customHeaders.tokenStore.get(0));
		
		 List<Student> list = studentService.getAllStudents();
		 
		 return new ResponseEntity<Object>(list,HttpStatus.OK);
			}else {
				String ad = "User is Unauthorized";
				
				return new ResponseEntity<Object>(ad,HttpStatus.UNAUTHORIZED);
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception ("Unauthorized");
			
		}
		
	}
	
	
	
	@GetMapping("/student/{studentId}")
	public ResponseEntity<Object> getStudentDetails(@PathVariable(value ="studentId") int studentId,HttpServletRequest request,HttpServletResponse responce) throws Exception {
	
		try {
			if(!responce.getHeader("Authorization").equals(null)) {
				
				//restTemplate.getInterceptors().add(new HeaderInterceptor());
				Object Student = this.studentService.getStudentDetails(studentId);
				
				return new ResponseEntity<Object>(Student,HttpStatus.OK);
				
				
				
			}else {
                  String ad = "User is Unauthorized";
				
				return new ResponseEntity<Object>(ad,HttpStatus.UNAUTHORIZED);
				
				
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception ("Unauthorized");
			
		}
		
		
		
	}
	
	
	@PostMapping("/addStudent")
	public ResponseEntity<Object> addStudent(@RequestBody Student student,HttpServletResponse responce) throws Exception {
		try {
			if(!responce.getHeader("Authorization").equals(null)) {
				
				
				Object Student= this.studentService.addStudent(student);
				return new ResponseEntity<Object>(Student,HttpStatus.OK);
			}else {
				
				
                 String ad = "User is Unauthorized";
				
				return new ResponseEntity<Object>(ad,HttpStatus.UNAUTHORIZED);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception ("Unauthorized");
			
		}
	
	}
	
	
	@PostMapping("/addMultipleStudent")
	public ResponseEntity<Object> addMultipleStudent(@RequestBody Student student,HttpServletResponse responce) throws Exception {
		try {
			if(!responce.getHeader("Authorization").equals(null)) {
				
				//restTemplate.getInterceptors().add(new HeaderInterceptor());
				Object Student = this.studentService.addMultipleStudent(student);
				
				return  new ResponseEntity<Object>(Student,HttpStatus.OK) ;
			}else {
				//System.out.println("User is Unauthorized");

                String ad = "User is Unauthorized";
				
				return new ResponseEntity<Object>(ad,HttpStatus.UNAUTHORIZED);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception ("Unauthorized");
			
		}
		
	}
	
	
	@GetMapping("/teacher/{standred}")
	public Student getTeacherDetails(@PathVariable Long standred,HttpServletResponse responce){
		//return this.studentService.getTeacherDetails(standred);
		
		Student student = this.studentService.getTeacherDetails(standred);
		
		List teachers = this.restTemplate.getForObject("http://localhost:8081/teachers/info/" + student.getStandred(), List.class);
		
		student.setTeacher(teachers);
		return student ;
	}
	
	
	@PostMapping("/removeStudent/{studentId}")
	public ResponseEntity<Object> removeStudent(@PathVariable int studentId,HttpServletResponse responce) throws Exception {
		
		try {
			if(!responce.getHeader("Authorization").equals(null)) {
				
		Object Student = this.studentService.removeStudent(studentId);
		
		return new ResponseEntity<Object>(Student,HttpStatus.OK);
			}else {
				//System.out.println("User is Unauthorized");

                String ad = "User is Unauthorized";
				
				return new ResponseEntity<Object>(ad,HttpStatus.UNAUTHORIZED);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception ("Unauthorized");
			
		}
		
		
	}

}
