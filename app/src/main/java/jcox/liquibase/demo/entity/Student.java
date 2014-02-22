package jcox.liquibase.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the STUDENT database table.
 * 
 */
@Entity
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="STUDENT_ID")
	private Long studentId;

	@Column(name="LAST_NAME")
	private String lastName;

	//bi-directional many-to-many association to Course
	@ManyToMany
	@JoinTable(
		name="STUDENT_COURSE"
		, joinColumns={
			@JoinColumn(name="STUDENT_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="COURSE_ID")
			}
		)
	private List<Course> courses;

	public Student() {
	}

	public Long getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}