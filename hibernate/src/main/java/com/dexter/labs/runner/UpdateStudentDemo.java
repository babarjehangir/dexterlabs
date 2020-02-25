package com.dexter.labs.runner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dexter.labs.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session ;

		try {

			int studentId = 1;
			
			
			session = factory.getCurrentSession();

			session.beginTransaction();

			System.out.println("\nGetting student with id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			System.out.println("Updating student ..");
			
			myStudent.setFirstName("Dexter");

			session.getTransaction().commit();

			
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("Update email for all students");
			
			session.createQuery("update Student set email='foo@gmail.com'")
					.executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done");

		} finally {
			factory.close();
		}

	}

}
