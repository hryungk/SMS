package jpa.entitymodels;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Student")
@NamedQuery(name = "Student.findAll", query = "SELECT s from Student s")
public class Student {

	/* Make sure the table name and the field name match by either
	 * changing the field name or
	 * using annotation
	 * */ 
	@Id
	@Column(name="email")
	private String sEmail; // Student's current school email, unique student identifier
	@Column(name="name")
	private String sName; // The full name of the student
	@Column(name="password")
	private String sPass; // Student's password in order to login
	@OneToMany(targetEntity = Course.class)
	private List<Course> sCourses; // All the courses that a student's registered for
	
	public Student() {
		sEmail = "";
		sName = "";
		sPass = "";
		sCourses = new ArrayList<>();
	}
	public Student(String sEmail, String sName, String sPass, List<Course> sCourses) {
		super();
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
		this.sCourses = sCourses;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsPass() {
		return sPass;
	}
	public void setsPass(String sPass) {
		this.sPass = sPass;
	}
	public List<Course> getsCourses() {
		return sCourses;
	}
	public void setsCourses(List<Course> sCourses) {
		this.sCourses = sCourses;
	}	
		
}
