package com.tmf.sms.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.tmf.sms.daos.StudentDAODB;
import com.tmf.sms.daos.StudentDAOInterface;
import com.tmf.sms.daos.StudentsDAO;
import com.tmf.sms.models.Student;

public class StudentServices {
	private Scanner scan = new Scanner(System.in);
	private StudentDAOInterface dao = new StudentDAODB();
	
	
	public void addStudent(){
		System.out.println("Enter student Id ");
		int id = scan.nextInt();
		System.out.println("Enter student Name");
		String name = scan.next();
		System.out.println("Enter student gender");
		String gender = scan.next();
		System.out.println("Enter student Email");
		String email = scan.next();
		System.out.println("Enter student Course");
		String course = scan.next();
		System.out.println("Enter student Address");
		String address = scan.next();
		System.out.println("Enter student Password");
		String password = scan.next();
		System.out.println("Enter student Batch");
		String batch = scan.next();
		System.out.println("Enter student Phone number");
		long phone = scan.nextLong();
		
		//Set these details to student object.
		Student st =new Student(id, name, gender, email, course, address, password, batch, phone);
		
		//Send the student object to the DAO layer.
		dao.addStudent(st);
		
	}
	
	public void displayStudentById() {
		System.out.println("Enter the student id to fetch");
		int studentId = scan.nextInt();
		Student st = dao.findStudent(studentId);
		if(st.getStudentId() == 0) {
			System.out.println("Sorry!!! Student not found");
		}
		else {
			System.out.println(st);
		}
	}
	
	public void displayAllStudents(){
		List<Student> students = dao.findAll();
		if(students.isEmpty()) {
			System.out.println("No student has been registered");
		}
		else {
			for(Student st : students) {
				System.out.println(st);
			}
		}
	}
	
	public void menu(){
		while(true) {
			System.out.println("=========Student Monitoring System===========");
			System.out.println("\n\tPress 1 for Register new student ");
			System.out.println("\tPress 2 for All registered students ");
			System.out.println("\tPress 3 for Display student by Id ");
			System.out.println("\tPress 4 for Delete student by Id");
			System.out.println("\tPress 9 for Exit");
			System.out.println("\n\tPlease enter your choice ");
			int opt = scan.nextInt();
			switch(opt) {
			case 1 : addStudent();break;
			case 2 : displayAllStudents();break;
			case 3 : displayStudentById();break;
			case 4 : deleteStudentById();break;
			case 9 : System.exit(opt);
			default:System.out.println("Sorry!!! You've chosen a wrong option..");
			}
		}
	}

	private void deleteStudentById() {
		System.out.println("Enter the student id to delete");
		int studentId = scan.nextInt();
		Student st = dao.findStudent(studentId);
		if(st.getStudentId() == 0) {
			System.out.println("Sorry!!! Student not found");
		}
		else {
			dao.deleteStudent(st);
		}
	}
}
