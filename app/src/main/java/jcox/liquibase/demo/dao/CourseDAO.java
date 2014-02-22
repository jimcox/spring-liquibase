package jcox.liquibase.demo.dao;

import jcox.liquibase.demo.entity.Course;

public interface CourseDAO {

	Course getCourseByID(Long id);
	
}
