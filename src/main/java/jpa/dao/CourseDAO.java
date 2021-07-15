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
	
	/**
	 * Takes a Course's ID as a String and parses the Course with that ID
	 * and returns a Course object
	 * 
	 * @param cId An integer containing a Course's ID
	 * @return A Course object that has the same ID as cId
	 */
	Course getCourseById(int cId);
}
