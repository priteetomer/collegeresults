package com.results.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Student;

import com.results.beans.StudentBean;

@WebServlet("/updatestudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String rollno = request.getParameter("txtrollno");
		String name = request.getParameter("txtname");
		String fatherName = request.getParameter("txtfathername");

		Student student = new Student();
		student.setRollno(rollno);
		student.setName(name);
		student.setFatherName(fatherName);

		StudentBean bean = new StudentBean();

		String updated = bean.updateStudent(student);

		if (updated.equals("updated"))
			response.sendRedirect("editstudent.jsp?msg=Student Updated");
		else if (updated.equals("failed"))
			response.sendRedirect("editstudent.jsp?msg=Failed");
		else if (updated.equals("error"))
			response.sendRedirect("editstudent.jsp?msg=Error");
	}
}
