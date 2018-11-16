package com.results.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Marks;

public class MarksDAO {

	public String addMarks(Marks marks) {

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

			String qry = "insert into marks(rollno,collegeyear,semester,exam,sessionaltype,subject,maximum,minimum,obtained) values(?,?,?,?,?,?,?,?,?)";

			st = con.prepareStatement(qry);
			st.setString(1, marks.getRollno());
			st.setString(2, marks.getYear());
			st.setString(3, marks.getSemester());
			st.setString(4, marks.getExam());
			st.setString(5, marks.getSessionalType());
			st.setString(6, marks.getSubject());
			st.setInt(7, marks.getMaximum());
			st.setInt(8, marks.getMinimum());
			st.setInt(9, marks.getObtained());

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

	public ArrayList<Marks> getMarks(String rollno, String year,
			String semester, String exam, String sessionalType) {

		ArrayList<Marks> studentMarks = new ArrayList<Marks>();
		
		Connection con = null; // to connect with database
		PreparedStatement st = null; // to execute queries
		ResultSet rs = null;

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

			String qry = null;
			
			if(sessionalType!=null)
				qry = "select entryid,subject,maximum,minimum,obtained from marks where rollno=? and collegeyear=? and exam=? and sessionaltype=? and semester=?";
			else
				qry = "select entryid,subject,maximum,minimum,obtained from marks where rollno=? and collegeyear=? and exam=? and semester=?";

			st = con.prepareStatement(qry);
			st.setString(1, rollno);
			st.setString(2, year);
			st.setString(3, exam);
			
			if(sessionalType!=null){
				st.setString(4, sessionalType);
				st.setString(5, semester);
			}
			else
				st.setString(4, semester);

			rs = st.executeQuery();
			
			if(rs.next()){
			
				do{
					Marks marks = new Marks();
					
					marks.setRollno(rollno);
					marks.setExam(exam);
					marks.setYear(year);
					marks.setSemester(semester);
					marks.setSessionalType(sessionalType);
					marks.setEntryid(rs.getInt("entryid"));
					marks.setSubject(rs.getString("subject"));
					marks.setMaximum(rs.getInt("maximum"));
					marks.setMinimum(rs.getInt("minimum"));
					marks.setObtained(rs.getInt("obtained"));
					
					studentMarks.add(marks);
					
				}while(rs.next());
				
			}
			else 
				studentMarks = null;

		} catch (Exception e) {
			System.out.println("Query error : " + e.getMessage());
			return null;
		} finally {
			try {
				st.close();
				con.close();

			} catch (Exception e) {
			}
		}
		
		return studentMarks;
	}

	public String updateResult(String[] entryids, String[] subject,
			String[] maximum, String[] minimum, String[] obtained) {

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

			String qry = "update marks set subject=?,maximum=?,minimum=?,obtained=? where entryid=?";

			for(int i=0;i<entryids.length;i++){
			
				st = con.prepareStatement(qry);
				st.setString(1, subject[i]);
				st.setInt(2, Integer.parseInt(maximum[i]));
				st.setInt(3, Integer.parseInt(minimum[i]));
				st.setInt(4, Integer.parseInt(obtained[i]));
				st.setInt(5, Integer.parseInt(entryids[i]));
	
				if (st.executeUpdate() > 0)
					result = "updated";
				else
					result = "failed";
			}
			

		} catch (Exception e) {
			System.out.println("Update result error : " + e.getMessage());
			e.printStackTrace();
			return "error";
		} finally {
			try {
				st.close();
				con.close();

			} catch (Exception e) {
			}
		}

		return result;	}
}