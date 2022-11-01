package com.example.demo;

public class Teacher {
	
	private int teacherId;
	private String teacherName;
	
	private Long standerd;
	
    public Teacher(int teacherId, String teacherName, Long standerd) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.standerd = standerd;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Long getStanderd() {
		return standerd;
	}

	public void setStanderd(Long standerd) {
		this.standerd = standerd;
	}


	
    
   
}
