package jpa.entitymodels;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Department {

	@Id
	private int did;
	private String dname;
	
	@OneToMany(targetEntity = Teacher.class)
	private List teacherList;
	

	public Department() {
		super();
	}
	public Department(int did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}
	public Department(int did, String dname, List teacherList) {
		super();
		this.did = did;
		this.dname = dname;
		this.teacherList = teacherList;
	}
	public List getTeacherList() {
		return teacherList;
	}
	public String getDname() {
		return dname;
	}
	
}
