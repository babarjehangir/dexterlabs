package com.dexter.labs.runner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dexter.labs.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session ;

		try {

			int studentId = 3;
			
			
			session = factory.getCurrentSession();

			session.beginTransaction();

			System.out.println("\nGetting student with id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			System.out.println("Delete student ..");
			
			session.delete(myStudent);

			session.getTransaction().commit();

			
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("deleting with query id 2");
			
			session.createQuery("delete from Student where id=2")
					.executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done");

		} finally {
			factory.close();
		}

	}

}
