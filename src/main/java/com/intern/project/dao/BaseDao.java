package com.intern.project.dao;

import java.util.List;

import com.intern.project.POJO.Course;

public interface BaseDao<T> {
	public void add(T t) throws Exception;
	
	public void delete(T t)throws Exception;
	
	public void deleteById(long id)throws Exception;
	
	public void update(T t)throws Exception;
	
	public T findByID(long id)throws Exception;
	
	public List<T> findAll( )throws Exception;


	
}
