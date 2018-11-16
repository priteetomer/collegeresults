package com.results.beans;

import pojo.Student;

import com.results.dao.StudentDAO;

public class StudentBean {
	
	private String rollno;

	public boolean checkDuplicateStudent(Student student){
		return new StudentDAO().checkDuplicateStudent(student);
	}

	public String addStudent(Student student) {
		return new StudentDAO().addStudent(student);
	}

	public String updateStudent(Student student) {
		return new StudentDAO().updateStudent(student);
	}

	public Student getStudentByRollno() {
		return new StudentDAO().getStudentByRollno(rollno);
	}
	
	public void setStudentByRollno(Student student) {
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public Integer getRollNoToDelete(){
		return null;
	}
	
	public void setRollnoToDelete(Integer rollno) {
		new StudentDAO().removeStudent(rollno);
	}
}
