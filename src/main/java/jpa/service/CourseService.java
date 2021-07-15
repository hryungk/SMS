package jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

public class CourseService implements CourseDAO {

	@Override
	public List<Course> getAllCourses() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entityManager = emfactory.createEntityManager();		
		
		// Use a TypedQuery to specify the type of output object by passing in the class parameter.
		TypedQuery<Course> query = entityManager.createNamedQuery("Course.findAll", Course.class);
		List<Course> courses = query.getResultList();
		
		entityManager.close();
		emfactory.close();
		return courses;
	}

	@Override
	public Course getCourseById(int cId) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entityManager = emfactory.createEntityManager();		
		
		Course course = entityManager.find(Course.class, cId);		
		
		entityManager.close();
		emfactory.close();
		return course;
	}

}
