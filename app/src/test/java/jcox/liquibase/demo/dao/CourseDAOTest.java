package jcox.liquibase.demo.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import jcox.liquibase.demo.entity.Course;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-hibernate.xml","/applicationContext-app.xml", "/HibernateDAOTest.xml"})
@Transactional
public class CourseDAOTest {

	@Autowired
	DataSource dataSource;

	@Autowired
	CourseDAO dao;
	
	@Before
	public void beforeEachTest() throws SQLException {
		
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("test-data.sql"));
		populator.populate(dataSource.getConnection());
		
	}

	@Test
	public void findCourse1() {
		
		Course course1 = dao.getCourseByID(Long.valueOf(1));
		
		assertNotNull(course1);
		assertEquals("Some Course", course1.getCourseName());
		
		assertNotNull(course1.getStudents());
		assertFalse(course1.getStudents().isEmpty());
		assertEquals(2, course1.getStudents().size());
		
	}
		
}
