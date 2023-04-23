package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int roll_no;
	
	@Column(name="name")
	private String name;
	@Column(name="DOB")
	private String DOB;
	@Column(name="marks")
	private int marks;
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Student(int roll_no, String name, String dOB, int marks) {
		super();
		this.roll_no = roll_no;
		this.name = name;
		DOB = dOB;
		this.marks = marks;
	}
	
	
	public Student() {
		
	}
	
	
	@Override
	public String toString() {
		return "Student [roll_no=" + roll_no + ", name=" + name + ", DOB=" + DOB + ", marks=" + marks + "]";
	}
	
	
	
	
	
	
}
 