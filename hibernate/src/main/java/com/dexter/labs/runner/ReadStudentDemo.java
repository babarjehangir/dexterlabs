package com.dexter.labs.runner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dexter.labs.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		Student student = new Student("Shadow", "Moon", "shadow@dummy.com");
		
		session.beginTransaction();
		
		System.out.println("saving...");
		
		System.out.println(student);
		
		session.save(student);
		
		session.getTransaction().commit();
		
		System.out.println("Saved student. Generated Id: " + student.getId());
		
		
		session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		System.out.println("\nGetting student with id: " + student.getId());
		
		
		Student myStudent = session.get(Student.class,  student.getId());
		
		
		System.out.println("Get Complete: " + myStudent);
		
		session.getTransaction().commit();
		
		System.out.println("Done");
		
		try {
			
		} finally {
			factory.close();   
		}
					
	}

}
