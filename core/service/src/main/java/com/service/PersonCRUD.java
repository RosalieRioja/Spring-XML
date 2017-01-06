package com.service;

import com.model.*;
import com.dao.*;
import com.util.*;

import java.util.*;

public class PersonCRUD implements CRUD<Person> {

	private PersonDao personDao;

	private final String SORT_ASC = "asc";
	private final String SORT_DESC = "desc";
	
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

	public List<Person> read(int sort) {
		List<Person> lstPerson = null;// = personDao.listPersons();

		switch(sort) {
			case 1 :	//gwa
				//lstPerson = personDao.listPersonsCriteria(SORT_ASC);
				lstPerson = personDao.listPersonsQuery(SORT_ASC, "GWA");
				break;
			case 2 :
				//lstPerson = personDao.listPersonsCriteria(SORT_DESC);
				lstPerson = personDao.listPersonsQuery(SORT_DESC, "GWA");
				break;
			case 3 :	//datehired
				lstPerson = personDao.listPersonsQuery(SORT_ASC, "dateHired");
				break;
			case 4 :
				lstPerson = personDao.listPersonsQuery(SORT_DESC, "dateHired");
				break;
			case 5 :	//lastName
				lstPerson = personDao.listPersonsQuery(SORT_ASC, "lastName");
				break;
			case 6 :
				lstPerson = personDao.listPersonsQuery(SORT_DESC, "lastName");
				break;
			case 7 :	//none
				lstPerson = personDao.listPersons();
		}

		if(lstPerson == null) {
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

	//================================================================

	public Roles getRole(int id_param) {
		return personDao.getRole(id_param);
	}

	public List<Roles> readRoles() {
		List<Roles> lstRoles = personDao.listRoles();

		if(lstRoles != null) { 
			//System.out.println("Record has been successfully added!\n");
		}
		else {
			System.out.println("There are no roles.");
		}

		return lstRoles;
	}

}