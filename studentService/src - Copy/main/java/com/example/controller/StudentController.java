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
	//@Autowired
	//private MutableHttpServletRequest mutableHttpServletRequest;
	
	 @Value("${demo.student.user.name}")
		private String Username;
	 
		@Value("${demo.student.user.password}")
		private String Password;
		
		
		//HttpEntity entity = new HttpEntity(headers);
		
		
		
	@RequestMapping(value ="/token/jwtRequest",method = RequestMethod.POST)
	public ResponseEntity<Object> getTokenFromSpring(@RequestBody JwtRequest jwtRequest) {
		 
		//System.out.println(jwtRequest);
		String url ="http://localhost:8080/token";
		
		// customHeaders.tokenStore.add(token);
      RestTemplate restTemplate = new RestTemplate();
		
		String token =  this.restTemplate.postForObject("http://localhost:8080/token",jwtRequest, String.class);
		
		customHeaders.tokenStore.add(token);
		
		//System.out.println();
		
		//System.out.println("token"+customHeaders.tokenStore.get(0));
		
        //HttpHeaders responseHeaders = new HttpHeaders();
		
		//studentService.addHeader(token);
		
		return new ResponseEntity<>(token,HttpStatus.OK);
		
		
		
		
		
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents( HttpServletRequest request,HttpServletResponse responce ) throws Exception{
		
		
		
		
	       //HttpHeaders requestHeader = new HttpHeaders();
	       //requestHeader.set("Authorization","Bearer"+" "+ customHeaders.tokenStore.get(0));
		
		 List<Student> list = studentService.getAllStudents();
		
		 
		/* if(list.size() <= 0) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }*/
		 
              //HttpHeaders headers = new HttpHeaders();
		 
		// headers.set("Authorization","Bearer"+" "+ customHeaders.tokenStore.get(0));
		  System.out.println("header" + responce.getHeader("Authorization"));
			return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
		
		 //return this.studentService.getAllStudents();
	}
	
	
	
	@GetMapping("/student/{studentId}")
	public Student getStudentDetails(@PathVariable(value ="studentId") int studentId,HttpServletRequest request,HttpServletResponse responce) throws Exception {
	
		try {
			if(!responce.getHeader("Authorization").equals(null)) {
				
				//restTemplate.getInterceptors().add(new HeaderInterceptor());
				
				return this.studentService.getStudentDetails(studentId);
				
				
				
			}else {
				System.out.println("User is Unauthorized");
				
				return null;
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception ("Unauthorized");
			
		}
		
		
		
	}
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student,HttpServletResponse responce) throws Exception {
		try {
			if(!responce.getHeader("Authorization").equals(null)) {
				
				//restTemplate.getInterceptors().add(new HeaderInterceptor());
				
				return this.studentService.addStudent(student);
			}else {
				System.out.println("User is Unauthorized");
				
				return null;
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception ("Unauthorized");
			
		}
	
	}
	@PostMapping("/addMultipleStudent")
	public List<Student> addMultipleStudent(@RequestBody Student student,HttpServletResponse responce) throws Exception {
		try {
			if(!responce.getHeader("Authorization").equals(null)) {
				
				//restTemplate.getInterceptors().add(new HeaderInterceptor());
				return this.studentService.addMultipleStudent(student);
			}else {
				System.out.println("User is Unauthorized");
				
				return null;
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

}
