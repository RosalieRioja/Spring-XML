package com.service;

import com.model.*;
import com.dao.*;
import com.util.*;

<<<<<<< HEAD
import java.util.*;

public class PersonCRUD implements CRUD<Person> {

=======
//import java.util.List;
//import java.util.Date;
//import java.util.Iterator;

public class PersonCRUD implements CRUD<Person> {

	
>>>>>>> 73f5e5b4ca6f3300f19dc4612b4298afad1366ec
	private PersonDao personDao;
	
	public PersonCRUD() {
		personDao = new PersonDao();
	}

	public void create(Person person) {
		if(personDao.addPerson(person)) { 
			System.out.println("Record has been successfully added!\n");
		}
		else {
			System.out.println("Unsuccessful attempt to add person.");
		}
	}

<<<<<<< HEAD
	public List<Person> read() {
		List<Person> lstPerson = personDao.listPersons();

		if(lstPerson != null) { 
			//System.out.println("Record has been successfully added!\n");
		}
		else {
			System.out.println("Nothing to show.");
		}

		return lstPerson;
	}

	public void update(Person person) {
		if(personDao.updatePerson(person)) {
			System.out.println("Record has been successfully updated!\n");
		}
		else {
			System.out.println("Unsuccessful attempt to update person record.");
		}
=======
	public void read() {
		if(personDao.listPersons()) { 
			//System.out.println("Record has been successfully added!\n");
		}
		else {
			System.out.println("Unsuccessful list person records.");
		}
	}

	public void update(Person person) {

>>>>>>> 73f5e5b4ca6f3300f19dc4612b4298afad1366ec
	}

	public void delete(int id_param) {
		if(personDao.deletePerson(id_param)) {
			System.out.println("Record has been successfully deleted!\n");
		}
		else {
			System.out.println("Unsuccessful attempt to delete person record.");
		}
	}

<<<<<<< HEAD
	public Person get(int id_param) {
		return personDao.getPerson(id_param);
=======
	public void get(int id_param) {
		//if(personDao.getPerson(id_param)) {
//
//		//}
//		//else {
//		//	System.out.println("Get person record unsuccessful.");
		//}
		personDao.getPerson(id_param);
>>>>>>> 73f5e5b4ca6f3300f19dc4612b4298afad1366ec
	}

}