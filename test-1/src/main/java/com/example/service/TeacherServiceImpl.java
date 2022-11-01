package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.model.Teacher;

@Service

public class TeacherServiceImpl implements TeacherService{

	
	List<Teacher> teachers = List.of( new Teacher (1,"Shekhar",5L),
			
			new Teacher(2,"Prajit",6L),
			new Teacher(3,"Pranav",7L),
			new Teacher(4,"Ankita",5L)
			
			
			);

	@Override
	public List<Teacher> getTeacher(Long standred) {
		
		return this.teachers.stream().filter(teacher -> teacher.getStandred().equals(standred)).collect(Collectors.toList());
		 
		//return this.teachers.stream().filter(teacher -> teacher.getStandred().equals(standred)).findAny().orElse(null);
	}
}
