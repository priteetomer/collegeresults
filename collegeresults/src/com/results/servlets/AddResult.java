package com.results.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Marks;

import com.results.beans.MarksBean;
import com.results.beans.StudentBean;

@WebServlet("/addresult")
public class AddResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String rollno = request.getParameter("txtrollno");
		String year = request.getParameter("year");
		String semester = request.getParameter("semester");
		String exam = request.getParameter("exam");
		String sessionalType = request.getParameter("sessionaltype");
		String maximum = request.getParameter("txtmaximum");
		String minimum = request.getParameter("txtminimum");
		String obtained = request.getParameter("txtobtained");
		String subject = request.getParameter("txtsubject");
		
		Marks marks = new Marks();
		
		marks.setRollno(rollno);
		marks.setExam(exam);
		marks.setYear(year);
		marks.setSemester(semester);
		marks.setSubject(subject);
		marks.setSessionalType(sessionalType);
		marks.setMaximum(Integer.parseInt(maximum));
		marks.setMinimum(Integer.parseInt(minimum));
		marks.setObtained(Integer.parseInt(obtained));
		
		MarksBean bean = new MarksBean();
		StudentBean sbean = new StudentBean();
		
		sbean.setRollno(rollno);
		
		if(sbean.getStudentByRollno()==null)
			response.sendRedirect("addresult.jsp?msg=Invalid roll number");
		else{
			String added = bean.addMarks(marks);
			
			if(added.equals("added"))
				response.sendRedirect("addresult.jsp?msg=Marks Added");
			else if(added.equals("failed"))
				response.sendRedirect("addresult.jsp?msg=Failed");
			else if(added.equals("error"))
				response.sendRedirect("addresult.jsp?msg=Error");
		}
	}
}
