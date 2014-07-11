package com.intern.project.daoImpl;



import java.util.Iterator;
import java.util.List;

import org.aspectj.bridge.Message;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.intern.project.POJO.Student;
import com.intern.project.dao.StudentDao;

public class StudentDaoImpl implements StudentDao{
	
	private Session session;
	
	public StudentDaoImpl(){
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Spring_hibernate.xml");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("file:E:/workspace/school_new/src/main/java/com/intern/project/resources/Spring_hibernate.xml");
		SessionFactory sessionFactory  = (SessionFactory) ctx.getBean("sessionFactory");
		session = sessionFactory.openSession();
	}
	
	public void add(Student t) throws Exception {
		// TODO Auto-generated method stub

		Transaction tx = session.beginTransaction();
	    session.save(t);
	    tx.commit();	
	}

	public void delete(Student t) throws Exception {
		Transaction tx = session.beginTransaction();
	    session.delete(t);
	    tx.commit();
		
	}

	public void deleteById(long id) throws Exception {
		Transaction tx = session.beginTransaction();
		session.delete(this.findByID(id));
	    tx.commit();
		
	}


	
	public void update(Student t) throws Exception {
		long ID = t.getID();
		Transaction tx = session.beginTransaction();
		session.delete(this.findByID(ID));
		session.save(t);
	    tx.commit();

	}

	public Student findByID(long iD) throws Exception {
		Student stu = (Student)session.get(Student.class, iD);
		return stu;
	}

	public List<Student> findAll() throws Exception {

		
        Transaction tx = session.beginTransaction();

        List<Student> students = (List<Student>)session.createQuery("from Student").list();
      //  System.out.println(students.get(0).getName());
       // System.out.println(students.get(1).getName());
        
        tx.commit();
        return students;
	}



}
