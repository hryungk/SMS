package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;

public interface StudentCourseDAO {

	/**
	 * Takes a Student's email as a String and parses the Courses registered by that email
	 * and returns a List of those Courses
	 * 
	 * @return A List of Course objects containing all courses that the student is registered
	 */
	List<Course> getAllStudentCourses(String sEmail);

}
