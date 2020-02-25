package com.dexter.labs.runner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dexter.labs.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// session factory
		
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class).buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();
				
				Student student1 = new Student("Maya", "Doe", "maya@dummy.com");
				Student student2 = new Student("Joe", "Doe", "joe@dummy.com");
				Student student3 = new Student("John", "Smith", "john@dummy.com");
				
				session.beginTransaction();
				
				System.out.println("saving...");
				
				session.save(student1);
				session.save(student2);
				session.save(student3);
				
				session.getTransaction().commit();
				
				System.out.println("Done");
				
				try {
					
				} finally {
					factory.close();   
				}
	}

}
