package jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.entitymodels.Department;
import jpa.entitymodels.Teacher;

public class OneToManyApp {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager manager = emfactory.createEntityManager();
		manager.getTransaction().begin();
		
		Teacher teacher1 = new Teacher(1, "Mike", 60000);
		manager.persist(teacher1);
		
		Teacher teacher2 = new Teacher(2, "Bairon", 80000);
		manager.persist(teacher2);
		
		List<Teacher> teacherList = new ArrayList<>();
		teacherList.add(teacher1);
		teacherList.add(teacher2);
		
		Department dept1 = new Department(1, "Test Departement", teacherList);
		manager.persist(dept1);
		
//		// To test unique key constraint
//		Teacher teacher3 = new Teacher(3, "Charlie", 90000);
//		manager.persist(teacher3);
//		dept1 = manager.find(Department.class, 1);
//		dept1.getTeacherList().add(teacher3);
//		manager.merge(dept1);
//		
//		Department dept2 = new Department(2, "Test Departement Two", teacherList);
//		manager.persist(dept2);
		
		manager.getTransaction().commit();
		manager.close();
		emfactory.close();
		
		
	}

}
