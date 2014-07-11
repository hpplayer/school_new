package com.intern.project.POJO;

import java.util.Date;
import java.util.List;

public class Student {
	private long ID;
	private String name; 
	private String sex;
	private Date Bir;
	private String major;
	private String Adr;
	private String Remarks;
	private List courses;
	
	public List getCourses() {
		return courses;
	}
	public void setCourses(List courses) {
		this.courses = courses;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBir() {
		return Bir;
	}
	public void setBir(Date string) {
		Bir = string;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getAdr() {
		return Adr;
	}
	public void setAdr(String adr) {
		Adr = adr;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remark) {
		Remarks = remark;
	}
	
}
