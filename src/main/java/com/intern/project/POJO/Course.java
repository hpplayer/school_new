package com.intern.project.POJO;

import java.util.List;


public class Course {
	private long courseID;
	private String courseName;
	private String Remarks;
	private int passline;
	private List students;
	

	public List getStudents() {
		return students;
	}

	public void setStudents(List students) {
		this.students = students;
	}

	public long getCourseID() {
		return courseID;
	}

	public void setCourseID(long courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public int getPassline() {
		return passline;
	}

	public void setPassline(int passline) {
		this.passline = passline;
	}

	public String toString(){
		Course cor = new Course();
		return cor.getCourseName() + cor.getCourseID() + cor.getPassline() + cor.getRemarks();
	}
	
	public static Course CreateAccount(long ID, String name, int PL, String Remarks){
		Course cor = new Course();
		cor.setCourseID(ID);
		cor.setCourseName(name);
		cor.setPassline(PL);
		cor.setRemarks(Remarks);	
		return cor;
	}
	
}
