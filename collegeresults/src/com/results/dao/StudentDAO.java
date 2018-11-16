package com.results.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Student;

public class StudentDAO {

	public String addStudent(Student student) {

		String result = "";

		Connection con = null; // to connect with database
		PreparedStatement st = null; // to execute queries

		// load the driver
		try {
			Class.forName(DB.driver);
			con = DriverManager.getConnection(DB.url, DB.user, DB.password);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver error : " + e.getMessage());
			return "error";
		} catch (SQLException e) {
			System.out.println("DSN error : " + e.getMessage());
			return "error";
		}

		try {

			String qry = "insert into student(rollno,name,fathername) values(?,?,?)";

			st = con.prepareStatement(qry);
			st.setString(1, student.getRollno());
			st.setString(2, student.getName());
			st.setString(3, student.getFatherName());

			if (st.executeUpdate() > 0)
				result = "added";
			else
				result = "failed";

		} catch (Exception e) {
			System.out.println("Query error : " + e.getMessage());
			return "error";
		} finally {
			try {
				st.close();
				con.close();

			} catch (Exception e) {
			}
		}

		return result;
	}

	public String updateStudent(Student student) {

		String result = "";

		Connection con = null; // to connect with database
		PreparedStatement st = null; // to execute queries

		// load the driver
		try {
			Class.forName(DB.driver);
			con = DriverManager.getConnection(DB.url, DB.user, DB.password);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver error : " + e.getMessage());
			return "error";
		} catch (SQLException e) {
			System.out.println("DSN error : " + e.getMessage());
			return "error";
		}

		try {

			String qry = "update student set name=?,fathername=? where rollno=?";

			st = con.prepareStatement(qry);
			st.setString(1, student.getName());
			st.setString(2, student.getFatherName());
			st.setString(3, student.getRollno());

			if (st.executeUpdate() > 0)
				result = "updated";
			else
				result = "failed";

		} catch (Exception e) {
			System.out.println("Query error : " + e.getMessage());
			return "error";
		} finally {
			try {
				st.close();
				con.close();

			} catch (Exception e) {
			}
		}

		return result;
	}

	public boolean checkDuplicateStudent(Student student) {

		boolean duplicate = false;

		Connection con = null; // to connect with database
		PreparedStatement st = null; // to execute queries
		ResultSet rs = null; // to read data from table

		// load the driver
		try {
			Class.forName(DB.driver);
			con = DriverManager.getConnection(DB.url, DB.user, DB.password);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver error : " + e.getMessage());
			return false;
		} catch (SQLException e) {
			System.out.println("DSN error : " + e.getMessage());
			return false;
		}

		try {

			String qry = "select rollno from student where rollno=?";
			st = con.prepareStatement(qry);
			st.setString(1, student.getRollno());
			
			rs = st.executeQuery();

			duplicate = rs.next();
			
		} catch (Exception e) {
			System.out.println("Error checking duplicate student : " + e.getMessage());
			return false;
		} finally {
			try {
				rs.close();
				st.close();
				con.close();

			} catch (Exception e) {
			}
		}

		return duplicate;
	}

	public void removeStudent(Integer rollno) {
		
		Connection con = null; // to connect with database
		PreparedStatement st = null; // to execute queries

		// load the driver
		try {
			Class.forName(DB.driver);
			con = DriverManager.getConnection(DB.url, DB.user, DB.password);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver error : " + e.getMessage());
			return;
		} catch (SQLException e) {
			System.out.println("DSN error : " + e.getMessage());
			return;
		}

		try {
			String qry = "delete from student where rollno=?";
			st = con.prepareStatement(qry);
			st.setInt(1, rollno);
			
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error removing student : " + e.getMessage());
			return;
		} finally {
			try {
				st.close();
				con.close();

			} catch (Exception e) {
			}
		}
		
	}

	public Student getStudentByRollno(String rollno) {
	
		Student student = null;

		Connection con = null; // to connect with database
		PreparedStatement st = null; // to execute queries
		ResultSet rs = null; // to read data from table

		// load the driver
		try {
			Class.forName(DB.driver);
			con = DriverManager.getConnection(DB.url, DB.user, DB.password);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver error : " + e.getMessage());
			return null;
		} catch (SQLException e) {
			System.out.println("DSN error : " + e.getMessage());
			return null;
		}

		try {

			String qry = "select name,fathername from student where rollno=?";
			st = con.prepareStatement(qry);
			st.setString(1, rollno);
			
			rs = st.executeQuery();

			if( rs.next() ){
				student = new Student();
				
				student.setRollno(rollno);
				student.setName(rs.getString("name"));
				student.setFatherName(rs.getString("fathername"));
			}
			
		} catch (Exception e) {
			System.out.println("Error reading student : " + e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
				st.close();
				con.close();

			} catch (Exception e) {
			}
		}
		
		return student;
	}
}
