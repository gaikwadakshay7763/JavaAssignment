package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Teacher;
import com.example.service.TeacherService;

@RestController

@RequestMapping("/teachers")

public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;

	@RequestMapping("/info/{standred}")
	public List<Teacher> getTeacher(@PathVariable("standred") Long standred){
		return this.teacherService.getTeacher(standred) ;
		
	}
	
	
}
