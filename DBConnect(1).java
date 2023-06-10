package com.tmf.sms.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	Connection con;
	public Connection getDB(){
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/cijd_10";
		String username = "root";
		String pwd = "root";
		con = DriverManager.getConnection(url,username,pwd);
		//Statement st = con.createStatement();
		//String query = "alter table student add column(course varchar(50),address varchar(300),pwd varchar(20),batch varchar(20))";
		//st.execute(query);
		System.out.println("Database has been Connected");
		}
		catch(SQLException e) {
			System.out.println("Unable to connect with a DataBase");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Check the class path or add a proper .jar file to the project");
		}
		return con;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		new DBConnect().getDB();
	}
}
