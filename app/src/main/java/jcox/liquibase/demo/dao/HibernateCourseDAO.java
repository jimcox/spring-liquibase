package jcox.liquibase.demo.dao;

import jcox.liquibase.demo.entity.Course;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateCourseDAO implements CourseDAO{

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public Course getCourseByID(Long id) {
		
		return (Course) sessionFactory.getCurrentSession().get(Course.class, id);
	}

	
	
}
