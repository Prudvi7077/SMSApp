package com.tmf.sms.models;

public class Student {
	private int studentId;
	private String studentName, gender, email;
	private String course, address, password, batch;
	private long phoneNumber;
	
	
	
	public String getStudentName() {
		return studentName;
	}



	public String getGender() {
		return gender;
	}



	public String getEmail() {
		return email;
	}



	public String getCourse() {
		return course;
	}



	public String getAddress() {
		return address;
	}



	public String getPassword() {
		return password;
	}



	public String getBatch() {
		return batch;
	}



	public long getPhoneNumber() {
		return phoneNumber;
	}



	public Student(int studentId, String studentName, String gender, String email, String course, String address,
			String password, String batch, long phoneNumber) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.gender = gender;
		this.email = email;
		this.course = course;
		this.address = address;
		this.password = password;
		this.batch = batch;
		this.phoneNumber = phoneNumber;
	}



	public String toString() {
		return "[studentId : "+this.studentId+", studentName : "+this.studentName+
				", gender : "+this.gender+", email : "+this.email+
				", course : "+this.course+", address : "+this.address+
				", password : "+this.password+", batch : "+this.batch+
				", phone number : "+this.phoneNumber+"]\n";
	}
	
	public int getStudentId() {
		return this.studentId;
	}
}
