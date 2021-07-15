package jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService implements StudentDAO {

	@Override
	public List<Student> getAllStudents() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entityManager = emfactory.createEntityManager();		
		
		// Use a TypedQuery to specify the type of output object by passing in the class parameter.
		TypedQuery<Student> query = entityManager.createNamedQuery("Student.findAll", Student.class);
		List<Student> students = query.getResultList();
		entityManager.close();
		emfactory.close();
		return students;
	}

	@Override
	public Student getStudentByEmail(String sEmail) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entityManager = emfactory.createEntityManager();	
		
		Student student = entityManager.find(Student.class, sEmail);
		
		entityManager.close();
		emfactory.close();
		return student;
	}

	@Override
	public boolean validateStudent(String sEmail, String sPassword) {
		boolean result = false;
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entityManager = emfactory.createEntityManager();	
		
		Student student = entityManager.find(Student.class, sEmail);
		if (student != null) {// Student's email exists in the database
			result = student.getsPass().equals(sPassword);
		}
		
		entityManager.close();
		emfactory.close();
		return result;
	}

	@Override
	public void registerStudentToCourse(String sEmail, int cId) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entityManager = emfactory.createEntityManager();	
		
		Student student = entityManager.find(Student.class, sEmail);
		List<Course> courses = student.getsCourses();
		Course course = entityManager.find(Course.class, cId);
		if (!courses.contains(course)) { // If not already registered for this class
			courses.add(course);
//			student.setsCourses(courses);
		}

		entityManager.close();
		emfactory.close();
	}

	@Override
	public List<Course> getStudentCourses(String sEmail) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entityManager = emfactory.createEntityManager();	
		
		Student student = entityManager.find(Student.class, sEmail);
		List<Course> courses = student.getsCourses();
		
		entityManager.close();
		emfactory.close();
		return courses;
	}

}
