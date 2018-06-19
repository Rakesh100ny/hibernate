package com.bridgelabz.controller;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.bridgelabz.model.User;

public class Manager {
	public SessionFactory getSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}

	public void register(User user) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("email", user.getEmail()))
				.setProjection(Projections.count("email"));

		List<Long> count = (List<Long>) criteria.list();

		for (Long value : count) {
			if(value>=1)
			 {
              System.out.println("User is Already exists...!");
			 }
			 else
			 {
				 session.save(user);
				 
				  session.getTransaction().commit();; session.close();
				  
				  System.out.println("Registration is successfully done...!");	 
			 }
		}
		
		

		
		 
		 
	}

	public void login(User user) {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("email", user.getEmail()))
				.add(Restrictions.eq("password", user.getPassword()));

		List<User> users = (List<User>) criteria.list();

		System.out.println("list : " + users.isEmpty());
		System.out.println("r1");
		if (!users.isEmpty()) {
			System.out.println("xyz");
			for (User user1 : users) {
				System.out.println("mid : " + user1.getEmail());
				System.out.println("pas : " + user1.getPassword());
				if (user1.getEmail().equals(user.getEmail()) && user1.getPassword().equals(user.getPassword())) {
					System.out.println("Login is successfully...!");
				}
			}
		} else {
			System.out.println("EmailId and Password is invalid...!");
		}

		System.out.println("r3");
		/*
		 * String mid="",pass=""; for(User user1 : users) {
		 * if(user.getEmail().equals(user1.getEmail())) { mid=user1.getEmail();
		 * pass=user1.getPassword(); } }
		 * 
		 * System.out.println("mid  : "+mid); System.out.println("pass : "+pass);
		 * 
		 * if(mid.equals(user.getEmail()) && pass.equals(user.getPassword())) {
		 * System.out.println("Login is successfully...!"); } else {
		 * System.out.println("EmailId and Password is invalid...!"); }
		 */
	}

	public void display() {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(User.class);

		List<User> users = (List<User>) criteria.list();

		for (User user : users) {
			System.out.println(user.getId());
			System.out.println(user.getFirstName());
			System.out.println(user.getLastName());
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
		}

	}

}
