/*
 * Filename: StudentCourses.java
* Author: Stefanski
* 02/25/2020 
 */
package jpa.entitymodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Harry
 *
 */
@Entity
@Table(name="Student_Course")
@IdClass(StudentCourseID.class)
@NamedQuery(name="CoursesByStudent", query="Select sc from StudentCourse sc where sc.eMail = :email")
public class StudentCourse {
	@Id
	@Column(name="student_email")
	private String eMail;

	@Id
	@Column(name="course_id")
	private int courseID;

	public StudentCourse() {}
	
	/**
	 * @param eMail
	 * @param courseID
	 */
	public StudentCourse(String eMail, int courseID) {
		this.eMail = eMail;
		this.courseID = courseID;
	}

	/**
	 * @return the eMail
	 */
	public String geteMail() {
		return eMail;
	}

	/**
	 * @param eMail the eMail to set
	 */
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	/**
	 * @return the courseID
	 */
	public int getCourseID() {
		return courseID;
	}

	/**
	 * @param courseID the courseID to set
	 */
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseID;
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentCourse other = (StudentCourse) obj;
		if (courseID != other.courseID)
			return false;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		return true;
	}

}