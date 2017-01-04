package com.service;

import com.model.*;
import com.dao.*;
import com.util.*;

import java.util.*;

public class PersonCRUD implements CRUD<Person> {

	private PersonDao personDao;
	
	public PersonCRUD() {
		personDao = new PersonDao();
	}

	public void delete(Person person) {}

	public void create(Person person) {
		if(personDao.addPerson(person)) { 
			System.out.println("Record has been successfully added!\n");
		}
		else {
			System.out.println("Unsuccessful attempt to add person.");
		}
	}

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
	}

	public void delete(int id_param) {
		if(personDao.deletePerson(id_param)) {
			System.out.println("Record has been successfully deleted!\n");
		}
		else {
			System.out.println("Unsuccessful attempt to delete person record.");
		}
	}

	public Person get(int id_param) {
		return personDao.getPerson(id_param);
	}

}