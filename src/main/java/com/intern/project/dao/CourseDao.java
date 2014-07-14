package com.intern.project.dao;

import java.util.List;

import com.intern.project.POJO.Course;

public interface CourseDao extends BaseDao<Course>{

	List<Course> findByAnyInfo(String ID, String Name, String passline, String remarks);



}
