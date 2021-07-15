package jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jpa.dao.StudentCourseDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.StudentCourse;

public class StudentCourseService implements StudentCourseDAO {

	@Override
	public List<Course> getAllStudentCourses(String sEmail) {
		List<Course> result = new ArrayList<>();
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entityManager = emfactory.createEntityManager();		
		
		// Use a TypedQuery to specify the type of output object by passing in the class parameter.
		TypedQuery<StudentCourse> query = entityManager.createNamedQuery("CoursesByStudent", StudentCourse.class);
		query.setParameter("email", sEmail);
		List<StudentCourse> studentCourses = query.getResultList();
		CourseService cs = new CourseService();
		for (StudentCourse sc : studentCourses) {
			result.add(cs.getCourseById(sc.getCourseID()));
		}
		
		entityManager.close();
		emfactory.close();
		return result;
	}

}
