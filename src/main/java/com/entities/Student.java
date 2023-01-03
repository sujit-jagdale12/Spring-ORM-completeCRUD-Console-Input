package com.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Student_Data")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Student_Id")
	private int studentId;
	@Column(name = "Student_Name")
	private String studentName;
	
	@Column(name = "Student_Email")
	private String studentEmail;
	
	@Column(name = "Student_Branch")
	private String branch;
	
	@Column(name = "Student_College")
	private String college;

	public Student() {
	}

	public Student(String studentName, String studentEmail, String branch, String college) {
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.branch = branch;
		this.college = college;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

}
