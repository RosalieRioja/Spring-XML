package com;

import com.model.*;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class App 
{
	private static SessionFactory factory;

    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
/*
		try{
			factory = new Configuration().configure().buildSessionFactory(); 
		}
		catch (Throwable ex) {
			System.err.println("Failed to create a sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

    	Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Integer modelID = null;
			// do some work
        	System.out.println( "Begin Transaction" );
        	
        	Person person = new Person("firstname", "lastname", "middlename",
        		"suffix", "title", new Date(2016-12-18), new Float(12.28), new Date(2016-12-28), true, "gender");
			modelID = (Integer) session.save(person);
			System.out.println(modelID);
			
			tx.commit();
		}
		catch (Exception e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}

		System.exit(0);
		*/
    }
}
