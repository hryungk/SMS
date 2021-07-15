package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;

public interface CourseDAO {

	/**
	 * Reads the course table in the database and returns the data as a
	 * List<Course>
	 * 
	 * @return A List of Course objects containing all courses in the database
	 */
	List<Course> getAllCourses();
}
