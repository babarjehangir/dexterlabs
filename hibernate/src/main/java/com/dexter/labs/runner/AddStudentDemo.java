package com.dexter.labs.runner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dexter.labs.entity.Student;

public class AddStudentDemo {

	public static void main(String[] args) {
		// session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		Student student = new Student("Babar", "Khan", "babar@dummy.com");
		
		session.beginTransaction();
		
		System.out.println("saving...");
		
		session.save(student);
		
		session.getTransaction().commit();
		
		System.out.println("Done");
		
		try {
			
		} finally {
			factory.close();   
		}
					
	}

}
