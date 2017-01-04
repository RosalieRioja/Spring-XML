package com.dao;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.*;
import com.model.*;

//import com.hibernate.model.ContactNumbers;
//import java.util.Collections;

public class PersonDao {

	private static SessionFactory factory;

	public PersonDao() {
		try {
			factory = new Configuration().configure().buildSessionFactory(); 
		}
		catch (Throwable ex) {
			System.err.println("Failed to create a sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public boolean addPerson(Person person) {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean success = false;

		try {
			tx = session.beginTransaction();
			session.save(person.getAddress());
			session.save(person); 
			tx.commit();

			success = true;
		}
		catch(HibernateException e) {
			if (tx != null){
				tx.rollback();
			}
			
			e.printStackTrace();
			System.out.println("Hibernate exception : addPerson");
		}
		finally {	
			session.close();
		}

		return success;
	}

	public List<Person> listPersons() {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean success = false;
		List<Person> people = null;
		
		try {
			tx = session.beginTransaction();
			people = session.createQuery("FROM Person").list();
			for(Person person : people) {
				Hibernate.initialize(person.getAddress());
			}
			tx.commit();
			success = true;
		}
		catch (HibernateException e) {
			if (tx!=null) {
				tx.rollback();
			}
			
			e.printStackTrace();
			System.out.println("Hibernate exception : listPersons");
		}
		catch (NullPointerException e) {
			if (tx!=null) {
				tx.rollback();
			}
			
			e.printStackTrace();
			System.out.println("Nullpointer exception : listPersons");
		}
		finally {
			session.close();
		}

		return people;
	}

	public Person getPerson(int personID){
		Person person = null;
		Session session = factory.openSession();
		Transaction tx = null;

		try{
			tx = session.beginTransaction();
			person = (Person)session.get(Person.class, personID);
			tx.commit();
			Hibernate.initialize(person.getAddress());
		}
		catch(HibernateException e){
			e.printStackTrace();
			System.out.println("Hibernate exception : getPerson");
		}
		catch(NullPointerException e){
			//e.printStackTrace();
			//System.out.println("Nullpointer exception : getPerson");
			//System.out.println("Person Id does not exist.");
		}
		catch (IllegalArgumentException e) {
			//e.printStackTrace();
			//System.out.println("IllegalArgument exception : getPerson");
			//System.out.println("Person Id does not exist.");
		}
		finally {
			session.close();

			if(person == null) {
				System.out.println("Person Id does not exist.");
			}
		}
		
		return person;
	}

	public boolean updatePerson(Person updatedPerson){
		Session session = factory.openSession();
		Transaction tx = null;
		boolean success = false;

		try{
			tx = session.beginTransaction();
			session.update(updatedPerson);
			session.update(updatedPerson.getAddress());
			tx.commit();
			success = true;
		}
		catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			
			e.printStackTrace();
			System.out.println("Hibernate exception : updatePerson");
		}
		finally {
			session.close();
		}

		return success;
	}

	public boolean deletePerson(int personID){
		Session session = factory.openSession();
		Transaction tx = null;
		boolean success = false;

		try{
			tx = session.beginTransaction();
			Person person = (Person)session.get(Person.class, personID);
			session.delete(person);
			tx.commit();
			success = true;
		}
		catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			
			e.printStackTrace();
			System.out.println("Hibernate exception : deletePerson");
		}
		catch (IllegalArgumentException e) {
			if (tx != null) {
				tx.rollback();
			}
			
			//e.printStackTrace();
			//System.out.println("IllegalArgument exception : deletePerson");
			System.out.println("Person Id does not exist.");
		}
		finally {
			session.close();
		}

		return success;
	}

}