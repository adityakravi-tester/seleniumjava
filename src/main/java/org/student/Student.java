package org.student;

import org.department.Department;

public class Student extends Department{
	public String studentName() {
		return "Aditya";
	}
	
	public String studentDept() {
		return "Computer Science";
	}
	
	public int studentId() {
		return 1;
	}
	
	public static void main(String[] args) {
		Student student = new Student();
		System.out.println("Student Information");
		System.out.printf("%s","===================================================");
		System.out.printf("%n%-30s%s", "College Name: ",student.collegeName());
		System.out.printf("%n%-30s%d", "College Code: ",student.collegeCode());
		System.out.printf("%n%-30s%d", "College Rank: ",student.collegeRank());
		System.out.printf("%n%-30s%s", "Department Name: ",student.deptName());
		System.out.printf("%n%-30s%s", "Student Name: ",student.studentName());
		System.out.printf("%n%-30s%s", "Student Department: ",student.studentDept());
		System.out.printf("%n%-30s%d", "Student Id: ",student.studentId());
	}
	
}
