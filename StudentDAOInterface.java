package com.tmf.sms.daos;

import java.sql.SQLException;
import java.util.List;

import com.tmf.sms.models.Student;

public interface StudentDAOInterface {
	public void addStudent(Student st);
	public Student findStudent(int studentId);
	public List<Student> findAll();
	public void deleteStudent(Student st);
	public void updateStudent(Student st);
	public List<Student> displayStudentsByCourse(String course);
	public List<Student> displayStudentByBatch(String batch);
}
