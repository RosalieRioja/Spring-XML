package com.dao;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
//import org.hibernate.Criteria;
//import org.hibernate.criterion.Order;
//import org.hibernate.criterion.Restrictions;
//import org.hibernate.criterion.Projections;
//import org.hibernate.criterion.ProjectionList;
//import org.hibernate.criterion.SimpleExpression;
//import org.hibernate.transform.Transformers;
//import org.hibernate.FetchMode;
//import org.hibernate.sql.JoinType;

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
			session.save(person); 
			tx.commit();

			success = true;
		}
		catch(HibernateException e) {
			if (tx != null){
				tx.rollback();
			}
			
			e.printStackTrace();
		}
		finally {	
			session.close();
		}

		return success;
	}

	public boolean listPersons() {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean success = false;
		
		try {
			tx = session.beginTransaction();
			List<Person> people = session.createQuery("FROM Person").list();
			
			for (Iterator iterator =
				people.iterator(); iterator.hasNext();){
				Person person = (Person) iterator.next();
				System.out.print("Name: " + person.getPersonName());
				System.out.print("\tBirthday: " + person.getBirthday());
				System.out.println(" GWA: " + person.getGWA());
				System.out.println(" Date Hired: " + person.getDateHired());
				System.out.println(" Currently Employed: " + person.getCurrentlyEmployed());
				System.out.println(" Gender: " + person.getPersonGender());
			}

			tx.commit();
			success = true;
		}
		catch (HibernateException e) {
			if (tx!=null) {
				tx.rollback();
			}
			
			e.printStackTrace();
		}
		finally {
			session.close();
		}

		return success;
	}

	public Person getPerson(int personID){
		Person person = null;
		Session session = factory.openSession();
		Transaction tx = null;
		//boolean success = false;

		try{
			tx = session.beginTransaction();
			person = (Person)session.get(Person.class, personID);
			tx.commit();
			//success = true;
			System.out.println(person.getPersonName());
		} catch(HibernateException e){
			if (tx!=null) tx.rollback();
				e.printStackTrace();
		} catch(NullPointerException e){
			e.printStackTrace();		
		}finally {
			session.close();
		}
		//return success;
		return person;
	}

	public void updatePerson(Person updatedPerson){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(updatedPerson);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
				e.printStackTrace();
		} finally {
			session.close();
		}
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
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
				e.printStackTrace();
		} finally {
			session.close();
		}

		return success;
	}

/*	
    public List<Person> listPersons(String choice, String order) {
        Session session = factory.openSession();
        Transaction tx = null;      
        List<Person> persons = null;  
        String sql = null;

        try {
            tx = session.beginTransaction();
            if(!(choice.equals("grade") || choice.equals("last_name"))) {
                Criteria cr = session.createCriteria(Person.class); 
                if(order.equals("desc")) {
                    cr.addOrder(Order.desc(choice));
                } else { 
                    cr.addOrder(Order.asc(choice));    
                }
                
                persons = cr.list();
            } else if(choice.equals("last_name")) {              
                if(order.equals("asc")){
                    sql = "FROM Person ORDER BY last_name ASC";             
                } else {
                    sql = "FROM Person ORDER BY last_name DESC";          
                }
                persons  = session.createQuery(sql).list();
            } else {
                sql = "FROM Person"; 
                persons  = session.createQuery(sql).list();
            }
            tx.commit();
        } catch(HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return persons;
    }
    */
}