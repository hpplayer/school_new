package com.intern.project.tests;

import java.text.SimpleDateFormat;
//import java.util.Date;
import java.sql.Date;









import com.intern.project.POJO.Course;
import com.intern.project.POJO.Score;
import com.intern.project.POJO.Student;
import com.intern.project.daoImpl.CourseDaoImpl;
import com.intern.project.daoImpl.ScoreDaoImpl;
import com.intern.project.daoImpl.StudentDaoImpl;

public class SimpleTest {
	public static void main(String[] args){
		//new SimpleTest().testCourse();
		new SimpleTest().testScore();
	}
	
	
	
	public void testScore(){
		ScoreDaoImpl scrImpl = new ScoreDaoImpl();
		Score scr = new Score();
		scr.setCourse_ID(1101L);
		scr.setScore(100);
		scr.setStudent_ID(0L);
		
		Score scr2 = new Score();
		scr2.setCourse_ID(1102L);
		scr2.setScore(101);
		scr2.setStudent_ID(0L);
		
		Score scr3 = new Score();
		scr3.setCourse_ID(1103L);
		scr3.setScore(60);
		scr3.setStudent_ID(0L);
		
		Score scr4 = new Score();
		scr4.setCourse_ID(1103L);
		scr4.setScore(60);
		scr4.setStudent_ID(222L);
		
		
		Score scr5 = new Score();
		scr5.setCourse_ID(1102L);
		scr5.setScore(60);
		scr5.setStudent_ID(222L);
		
		Score scr6 = new Score();
		scr6.setCourse_ID(1104L);
		scr6.setScore(61);
		scr6.setStudent_ID(222L);
		
		try {
			scrImpl.add(scr);
			scrImpl.add(scr2);
			scrImpl.add(scr3);
			scrImpl.add(scr4);
			scrImpl.add(scr5);
			scrImpl.add(scr6);
			//System.out.println(scrImpl.CountStudent());
			//System.out.println(scrImpl.findByStudentID(0).get(0).getScore());
			//scrImpl.deleteByStudentId(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void testCourse(){
		CourseDaoImpl stuImpl = new CourseDaoImpl();
		try{
		System.out.println(stuImpl.findByAnyInfo("%"+"%","%", "%","%").get(0).getCourseID());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		/*
		try{
			Course cor = new Course();
			cor.setCourseID(26130201031L);
			cor.setCourseName("swimming");
			cor.setPassline(100);
			cor.setRemarks("come and join us");
			CourseDaoImpl stuImpl = new CourseDaoImpl();
			stuImpl.add(cor);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		*/
	}
	public void testStudent(){
		try {
			
			Student Stu = new Student();
			Stu.setID(12345);
			Stu.setName("David");
			// set date
			String strDate = "1988/08/01";
			//SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");	
			//Date date = format.parse(strDate);
			Date date = Date.valueOf(strDate);
			Stu.setBir(date);
			
			Stu.setSex("M");
			Stu.setMajor("06_ME");
			Stu.setAdr("123 white house, USA");
			Stu.setRemarks("USA SPY");
			StudentDaoImpl stuImpl = new StudentDaoImpl();
			stuImpl.add(Stu);
			stuImpl.deleteById(12345);
			stuImpl.findAll();
		
		}catch(Exception ex){
			ex.printStackTrace();
		}//end catch 
			
	}
}
