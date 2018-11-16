package com.results.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Student;

import com.results.beans.StudentBean;

@WebServlet("/addstudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String rollno = request.getParameter("txtrollno");
		String name = request.getParameter("txtname");
		String fatherName = request.getParameter("txtfathername");
		
		Student student = new Student();
		student.setRollno(rollno);
		student.setName(name);
		student.setFatherName(fatherName);
		
		StudentBean bean = new StudentBean();
		
		boolean duplicate = bean.checkDuplicateStudent(student);
		
		if(duplicate){
			response.sendRedirect("addstudent.jsp?msg=Rollno already added");
		}
		else{
			String added = bean.addStudent(student);
			
			if(added.equals("added"))
				response.sendRedirect("addstudent.jsp?msg=Student Added");
			else if(added.equals("failed"))
				response.sendRedirect("addstudent.jsp?msg=Failed");
			else if(added.equals("error"))
				response.sendRedirect("addstudent.jsp?msg=Error");
		}					
	}
}
