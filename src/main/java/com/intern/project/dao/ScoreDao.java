package com.intern.project.dao;
import java.util.List;

import com.intern.project.POJO.Score;

public interface ScoreDao extends BaseDao<Score>{

	void deleteByStuIdANDCrsID(long stuid, long crsid) throws Exception;

	List<Score> findByStudentID(long id) throws Exception;

	List<Score> findByCourseID(long id) throws Exception;

	Score findbyStuIDandCrsID(long StuID, long crsID);

	List<Score> findByStuIDWLimit(long StuIDmax, long StuIDmin, long crsMax, long crsMin, int scrMax, int scrMin) throws Exception;

	List<Long> findStulistWlimit(long StuIDmax, long StuIDmin, long crsMax, long crsMin, int scrMax, int scrMin);

	List<Long> ReturnStuList();

	long CountStudent();

}
