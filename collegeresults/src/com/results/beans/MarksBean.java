package com.results.beans;

import java.util.ArrayList;

import pojo.Marks;
import pojo.Student;

import com.results.dao.MarksDAO;

public class MarksBean {
	
	private String rollno;
	private String year;
	private String semester;
	private String sessionalType;
	private String exam;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getSessionalType() {
		return sessionalType;
	}

	public void setSessionalType(String sessionalType) {
		this.sessionalType = sessionalType;
	}

	public String getExam() {
		return exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public String addMarks(Marks marks) {
		return new MarksDAO().addMarks(marks);
	}

	public ArrayList<Marks> getMarks() {
		return new MarksDAO().getMarks(rollno,year,semester,exam, sessionalType);
	}
	
	public void setStudentByRollno(Student student) {
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String updateResult(String[] entryids, String[] subject,
			String[] maximum, String[] minimum, String[] obtained) {
		return new MarksDAO().updateResult(entryids, subject, maximum, minimum, obtained);
	}
}
