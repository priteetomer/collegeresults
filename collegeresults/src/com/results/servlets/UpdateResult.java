package com.results.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.results.beans.MarksBean;

@WebServlet("/updateresult")
public class UpdateResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String[] entryids = request.getParameterValues("entryid");
		String[] subject = request.getParameterValues("subject");
		String[] maximum = request.getParameterValues("maximum");
		String[] minimum = request.getParameterValues("minimum");
		String[] obtained = request.getParameterValues("obtained");
		
		MarksBean bean = new MarksBean();
		
		String updated = bean.updateResult(entryids, subject, maximum, minimum, obtained);

		if (updated.equals("updated"))
			response.sendRedirect("resultupdated.jsp?msg=Updated");
		else if (updated.equals("failed"))
			response.sendRedirect("resultupdated.jsp?msg=Failed");
		else if (updated.equals("error"))
			response.sendRedirect("resultupdated.jsp?msg=Error");
	}
}
