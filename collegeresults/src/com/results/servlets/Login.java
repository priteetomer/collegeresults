package com.results.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.results.beans.LoginBean;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("txtid");
		String password = request.getParameter("txtpassword");
		
		LoginBean bean = new LoginBean();
		bean.setId(id);
		bean.setPassword(password);
		
		boolean logged = bean.checkLogin();
		
		if(logged){
			request.getSession(true).setAttribute("loggeduser", id);
			response.getWriter().print("logged");
		}
		else
			response.getWriter().print("incorrect");
	}
}
