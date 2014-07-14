package com.intern.project.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intern.project.POJO.Course;
import com.intern.project.POJO.Score;
import com.intern.project.POJO.Student;
import com.intern.project.dao.CourseDao;

public class CourseDaoImpl implements CourseDao{
	private Session session;
	public CourseDaoImpl(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("file:E:/workspace/school_new/src/main/java/com/intern/project/resources/Spring_hibernate.xml");
		SessionFactory sessionFactory  = (SessionFactory) ctx.getBean("sessionFactory");
		session = sessionFactory.openSession();
	}
	public void add(Course t) throws Exception {
		Transaction tx = session.beginTransaction();
	    session.save(t);
	    tx.commit();
		
	}


	public void delete(Course t) throws Exception {
		Transaction tx = session.beginTransaction();
	    session.delete(t);
	    tx.commit();
	}

	public void deleteById(long id) throws Exception {
		Transaction tx = session.beginTransaction();
		session.delete(this.findByID(id));
	    tx.commit();
		
	}

	public void update(Course t) throws Exception {
		Transaction tx = session.beginTransaction();
		String crsName = t.getCourseName();
		int PL = t.getPassline();
		String remarks = t.getRemarks();
		long crsID = t.getCourseID();
		Course tempo = findByID(crsID);
		tempo.setCourseName(crsName);
		tempo.setPassline(PL);
		tempo.setRemarks(remarks);
		session.update(tempo);
	    tx.commit();
		
	}


	public List<Course> findByAnyInfo (String ID, String Name, String passline, String remarks ){

		
		Transaction tx = session.beginTransaction();
		
		String sql = "select course_ID, course_Name, course_Passline, Remarks from course where course_ID like :course_ID AND course_Name like :course_Name AND course_Passline like :course_Passline AND Remarks like :course_RMKS"  ;
		SQLQuery query = session.createSQLQuery(sql);
		//query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP );
		query.addEntity(Course.class);
		query.setParameter("course_ID", ID);
		query.setParameter("course_Name", Name);
		query.setParameter("course_Passline", passline);
		query.setParameter("course_RMKS", remarks);
		
		
		List<Course> results = query.list();
		
	    tx.commit();
	    return results;
	
		
	
	}
	
	
	public Course findByID(long id) throws Exception {
		//Transaction tx = session.beginTransaction();
		Course crs = (Course)session.get(Course.class, id);
	    //tx.commit();
		return crs;
	}

	public List<Course> findAll() throws Exception {
	      Transaction tx = session.beginTransaction();

	        List<Course> Courses = (List<Course>)session.createQuery("from Course").list();

	        tx.commit();
	        return Courses;
	}

}
