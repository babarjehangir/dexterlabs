package com.dexter.labs.runner;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dexter.labs.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			displayStudents(theStudents);
			
			
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();

			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Shadow'").getResultList();

			System.out.println("\nStudents with last name Doe or first name Shadow");
			
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.email LIKE '%dummy.com'").getResultList();

			System.out.println("\nStudents with email like dummy.com");
			
			displayStudents(theStudents);
			
			session.getTransaction().commit();
			
			System.out.println("Done");

		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tStudent : theStudents) {
			System.out.println(tStudent);
		}
	}

}
