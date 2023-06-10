package com.tmf.sms.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tmf.sms.config.DBConnect;
import com.tmf.sms.models.Student;

public class StudentDAODB implements StudentDAOInterface{

	DBConnect db = new DBConnect();
	Connection con = db.getDB();
	
	@Override
	public void addStudent(Student st){
		try {
		String query = "insert into student values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, st.getStudentId());
		ps.setString(2, st.getStudentName());
		ps.setString(3, st.getGender());
		ps.setLong(4, st.getPhoneNumber());
		ps.setString(5, st.getEmail());
		ps.setString(6, st.getCourse());
		ps.setString(7, st.getAddress());
		ps.setString(8, st.getPassword());
		ps.setString(9, st.getBatch());
		ps.execute();
		System.out.println("Student successfully registered..");
		}
		catch(SQLException e) {
			System.out.println("Unable to insert Data..");
		}
	}

	@Override
	public Student findStudent(int studentId){
	  Student st = null;
	  try {
		String query = "select * from student where stid=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, studentId);
		ResultSet rs = ps.executeQuery();
		
		
		if(rs.next()) {
			int id = rs.getInt("stid");
			String name = rs.getString("stname");
			String gender = rs.getString("gender");
			long phone = rs.getLong("phone");
			String email = rs.getString("email");
			String course = rs.getString("course");
			String batch = rs.getString("batch");
			String add = rs.getString("address");
			String pws = rs.getString("pwd");
			st = new Student(id, name, gender, email, course, add, pws, batch, phone);
		}
		else {
			st = new Student(0, null, null, null, null, null, null, null, 0);
		}
	  }catch(SQLException e) {
		  System.out.println("Unable to retrieve data from the database");
	  }
		return st;
	}

	@Override
	public List<Student> findAll(){
		// TODO Auto-generated method stub
		List<Student> lst = new ArrayList<Student>();
		String query = "select * from student";
	   try {
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("stid");
			String name = rs.getString("stname");
			String gender = rs.getString("gender");
			long phone = rs.getLong("phone");
			String email = rs.getString("email");
			String course = rs.getString("course");
			String batch = rs.getString("batch");
			String add = rs.getString("address");
			String pws = rs.getString("pwd");
			Student st = new Student(id, name, gender, email, course, add, pws, batch, phone);
			lst.add(st);
		}
	   }catch(SQLException e) {
		   System.out.println("Unable to retrieve data from the database");
	   }
		return lst;
	}

	@Override
	public void deleteStudent(Student st){
		// TODO Auto-generated method stub
		String query = "delete from student where stid=?";
		try {
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, st.getStudentId());
		ps.execute();
		System.out.println("Student Successfully deleted");
		}catch(SQLException e) {
			System.out.println("Unable to read data from the database");
		}
	}

	@Override
	public void updateStudent(Student st){
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> displayStudentsByCourse(String course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> displayStudentByBatch(String batch) {
		// TODO Auto-generated method stub
		return null;
	}

}
