package com.intern.project.daoImpl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intern.project.POJO.Course;
import com.intern.project.POJO.Score;
import com.intern.project.POJO.Student;
import com.intern.project.dao.*;

public class ScoreDaoImpl implements ScoreDao{
private Session session;
	
	public ScoreDaoImpl(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("file:E:/workspace/school_new/src/main/java/com/intern/project/resources/Spring_hibernate.xml");
		SessionFactory sessionFactory  = (SessionFactory) ctx.getBean("sessionFactory");
		session = sessionFactory.openSession();
	}
	
	public void add(Score t) throws Exception {
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Score.class);
		cr.add(Restrictions.eq("student_ID", t.getStudent_ID()));
		cr.add(Restrictions.eq("course_ID", t.getCourse_ID()));
		List<Score> results = cr.list();
		if (results.size()>0){
			System.out.println("Same data found, insertion denied");
		}else{
		    session.save(t);
		}

	    tx.commit();
		
	}

	public void delete(Score t) throws Exception {
		Transaction tx = session.beginTransaction();
	    session.delete(t);
	    tx.commit();
		
	}

	public void deleteByStudentId(long id) throws Exception {
		Transaction tx = session.beginTransaction();
		List<Score> tempo = findByStudentID(id);
		for ( int i = 0; i < tempo.size(); i++){
		    session.delete(tempo.get(i));
		}
		 tx.commit();
		
	}
	
	public void deleteByStuIdANDCrsID(long stuid, long crsid) throws Exception {
		Score tempo = findbyStuIDandCrsID(stuid,crsid);
		delete(tempo);
		
	}

	public void update(Score t) throws Exception {
		Transaction tx = session.beginTransaction();
		long stuID = t.getStudent_ID();
		long crsID = t.getCourse_ID();
		Score tempo = findbyStuIDandCrsID(stuID,crsID);
		tempo.setScore(t.getScore());
		session.update(tempo);
	    tx.commit();
		
	}

	public List<Score> findByStudentID(long id) throws Exception {
		Criteria cr = session.createCriteria(Score.class);
		cr.add(Restrictions.eq("student_ID", id));
		List<Score> results = cr.list();
		return results;
	}
	
	public List<Score> findByCourseID(long id) throws Exception {
		Criteria cr = session.createCriteria(Score.class);
		cr.add(Restrictions.eq("course_ID", id));
		List<Score> results = cr.list();
		return results;
	}
	
	public Score findbyStuIDandCrsID(long StuID, long crsID){
		Criteria cr = session.createCriteria(Score.class);
		cr.add(Restrictions.eq("course_ID", crsID));
		cr.add(Restrictions.eq("student_ID", StuID));
		Score result = (Score) cr.list().get(0);
		return result;
	}
	
	public List<Score> findByStuIDWLimit(long StuIDmax, long StuIDmin, long crsMax, long crsMin, int scrMax, int scrMin) throws Exception {
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Score.class);
		cr.add(Restrictions.ge("student_ID", StuIDmin));
		cr.add(Restrictions.le("student_ID", StuIDmax));
		
		cr.add(Restrictions.le("course_ID", crsMax));
		cr.add(Restrictions.ge("course_ID", crsMin));
		
		cr.add(Restrictions.le("score", scrMax));
		cr.add(Restrictions.ge("score", scrMin));
		
		List<Score> results = cr.list();
		tx.commit();
		return results;
	}
	
	public List<Long> findStulistWlimit (long StuIDmax, long StuIDmin, long crsMax, long crsMin, int scrMax, int scrMin){

		String hql = "SELECT distinct student_ID FROM Score where student_ID <= :StuIDmax AND student_ID >= :StuIDmin"
		+" AND course_ID >= :crsMin AND course_ID <= :crsMax AND score >= :scrMin AND score <= :scrMax";
		//String hql = "SELECT distinct student_ID FROM score where student_ID < 2000 AND student_ID > 0 AND course_ID > 0 AND course_ID < 2000 AND course_Score> 0 AND course_Score < 2000";
		Query query = session.createQuery(hql);
	
		query.setParameter("StuIDmax",StuIDmax);
		query.setParameter("StuIDmin",StuIDmin);
		query.setParameter("crsMax",crsMax);
		query.setParameter("crsMin",crsMin);
		query.setParameter("scrMax",scrMax);
		query.setParameter("scrMin",scrMin);

		List results = query.list();
		
		return results;	
	}
	
	
	public List<Score> findAll() throws Exception {
	      Transaction tx = session.beginTransaction();

	        List<Score> score = (List<Score>)session.createQuery("from Score").list();
	      //  System.out.println(students.get(0).getName());
	       // System.out.println(students.get(1).getName());
	        
	        tx.commit();
	        return score;
	}
	
	public List<Long> ReturnStuList(){
		Transaction tx = session.beginTransaction();
		String hql = "SELECT distinct student_ID FROM Score";
		Query query = session.createQuery(hql);
		List stuID = query.list();
	    tx.commit();
	    return stuID;
	}
	
	
	public long CountStudent() {
		Transaction tx = session.beginTransaction();
		String hql = "SELECT count(distinct student_ID) FROM Score";
		Query query = session.createQuery(hql);
		long result = (Long) query.uniqueResult();
        tx.commit();
		return result;
		
		/* from student table
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Student.class);
		cr.setProjection(Projections.rowCount());
		int count = (Integer) cr.uniqueResult();
		 tx.commit();
		return count;
		*/
	}
	
	public Score findByID(long id) throws Exception {
		Transaction tx = session.beginTransaction();
		Score scr = (Score)session.get(Score.class, id);
	    tx.commit();
		return scr;
		
	}

	
	public void deleteById(long id) throws Exception {
		Transaction tx = session.beginTransaction();
		session.delete(this.findByID(id));
	    tx.commit();
	}
	

}
