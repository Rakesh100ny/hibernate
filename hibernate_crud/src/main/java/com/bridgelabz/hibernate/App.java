package com.bridgelabz.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bridgelabz.model.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		/*
		 * -----------Insert the record in the record------------ for(int i=0;i<10;i++)
		 * { Employee employee=new Employee(); employee.setEmpName("User : "+i);
		 * session.save(employee); }
		 */

		/*---------Retrive the data---------
		 Employee employee = session.get(Employee.class, 5);
		*/

		/*
		 * ---------delete------------ session.delete(employee);
		 */

		/*---------Update--------
		employee.setEmpName("Updated User");
		session.update(employee);
		
		System.out.println("User Name is : " + employee.getEmpName());
		*/

		/*
		 * ----------Knowledge of Transient State and Persistent State----------
		 * Transient Object b'Coz it only create Entity Object it did save by
		 * hibernate...
		 * 
		 * 
		 * Employee employee = new Employee(); employee.setEmpName("Test Name");
		 * 
		 * SessionFactory sessionFactory = new
		 * Configuration().configure().buildSessionFactory(); Session session =
		 * sessionFactory.openSession(); session.beginTransaction();
		 * 
		 * Here the Entity Object is save so thatit is Persistent Object
		 * session.save(employee); employee.setEmpName("Update User");
		 * employee.setEmpName("Update User Again");
		 * 
		 * session.getTransaction().commit(); session.close();
		 * 
		 */

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Employee employee = session.get(Employee.class, 1);

		session.getTransaction().commit();
		session.close();

		/*
		 * Que-> if no changes in the employee object and no update then hibernate
		 * select query fire if second i used session.update which i am use right now
		 * then hibernate update doing but you know that no object is change then why
		 * hibernate fire update query ???
		 * 
		 * Ans-> so that in this scenario we tell to hibernate using annotation show in
		 * Employee.java org.
		 *
		 employee.setEmpName("Update User Again After Session is over...!"); // did not update in 
		                                                                        database b'Coz the session is 
		                                                                        close
		  
		 */ 
		  

		session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(employee); // now employee object is updated...b'Coz 2nd session detached Object after
									// session
		// is closed and it is neccessary to open session

		/*
		 * 
		 * Que-> if no changes in the employee object and no update then hibernate
		 * select query fire if second i used session.update which i am use right now
		 * then hibernate update doing but you know that no object is change then why
		 * hibernate fire update query ???
		 * 
		 * Ans-> so that in this scenario we tell to hibernate using annotation show in
		 * Employee.java  
		 * 
		 employee.setEmpName("Change after update...!"); 
		 */ 
		
		session.getTransaction().commit();
		session.close();

	}
}
