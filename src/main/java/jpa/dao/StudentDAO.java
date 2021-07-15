package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public interface StudentDAO {

	/**
	 * Reads the student table in the database and returns the data as a
	 * List<Student>
	 * 
	 * @return A List of Student objects containing all students in the database
	 */
	List<Student> getAllStudents();

	/**
	 * Takes a Student's email as a String and parses the Student with that email
	 * and returns a Student object
	 * 
	 * @param sEmail A String containing a Student's email address
	 * @return A Student object that has the same email as sEmail
	 */
	Student getStudentByEmail(String sEmail);

	/**
	 * Takes Student's credentials and checks if the student is in the system
	 * 
	 * @param sEmail    A String containing a Student's email address
	 * @param sPassword A String containing a Student's password
	 * @return true if the Student is found, false otherwise
	 */
	boolean validateStudent(String sEmail, String sPassword);

	/**
	 * Takes a Student's email and a Course ID and registers the student to the
	 * course if not attending already It checks in the join table (i.e.
	 * Student_Course) generated by JPA to find if a Student with that email is
	 * currently attending a Course with that ID. If the Student is not attending
	 * that Course, register the student to that Course; otherwise not.
	 * 
	 * Prerequisite: validateStudent() returns true
	 * 
	 * @param sEmail
	 * @param cId
	 */
	void registerStudentToCourse(String sEmail, int cId);

	/**
	 * Takes a Student's email and returns all the courses the Student is registered
	 * 
	 * @param sEmail A String containing a Student's email address
	 * @return A List of Course objects that the Student is registered
	 */
	List<Course> getStudentCourses(String sEmail);
}