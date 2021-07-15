package jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.entitymodels.Student;
import jpa.entitymodels.Course;

public class ServiceTest {

	public static void main(String[] args) {
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SchoolManagementSystem");
		EntityManager manager = emfactory.createEntityManager();
		manager.getTransaction().begin();
		
		Course course1 = new Course(111, "Solid Mechanics", "John Smith");
		manager.persist(course1);
		
		Course course2 = new Course(222, "Fluid Mechanics", "Michael Daym");
		manager.persist(course2);
		
		List<Course> courseList = new ArrayList<>();
		courseList.add(course1);
		courseList.add(course2);
		
		Student student1 = new Student("james@email.com", "James Palmer", "Djdl1Gue",courseList);
		manager.persist(student1);

		manager.getTransaction().commit();
		manager.close();
		emfactory.close();
		
		
//		StudentService ss = new StudentService();
//		List<Student> students = ss.getAllStudents();
//		students.forEach(s -> System.out.println(s.getsName()));
	}
}
