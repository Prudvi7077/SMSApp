package com.tmf.sms.daos;

import java.util.List;

import com.tmf.sms.models.Student;

public class StudentsDAO implements StudentDAOInterface{
	//datatype arrayName[] = new datatype[size];
	//ClassName arrayName[] = new ClassName[size];
	//An Object array.
	Student students[] = new Student[3];
	int index = 0;
	
	//Call by reference
	public void addStudents(Student st) {
		if(index >= (students.length-1)) {
			System.out.println("Sorry!!! Admission got Filled..");
		}
		else {
			//add objects to the array.
			students[index] = st;
			index++;
			System.out.println("Student got registered successfully..");
		}
	}
	
	public Student[] displayAllStudents() {
		//Displaying all students using for-each loop
		/*
		 *  for(ClassName objectName : arrayName){
		 *          System.out.println(objectName);
		 *  }
		 */
		
		return students;
	}
	
	//Call by Value
	public void displayStudent(int studentId) {
		Student stu = null;
		int flag=0;
		for(Student st : students) {
			if(studentId == st.getStudentId()) {
				flag++;
				stu = st;
				break;
			}
		}
		if(flag == 0) {
			System.out.println("Sorry student not found with the given ID");
		}
		else {
			System.out.println(stu);
		}
	}

	@Override
	public void addStudent(Student st) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student findStudent(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudent(Student st) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStudent(Student st) {
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
