package jpa.entitymodels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Entity implementation class for Entity: Teacher
 *
 */
@Entity
@Table
public class Teacher{

	@Id
	private int eid;
	private String ename;
	private double salary;
	
	public Teacher() {
		super();
	}   
	public Teacher(int eid, String ename, double salary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
	}

	public int getEid() {
		return this.eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}   
	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}   
	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
   
}
