package com.service;

import com.model.*;
import com.dao.*;
import com.util.*;

//import java.util.List;
//import java.util.Date;
//import java.util.Iterator;

public class PersonCRUD implements CRUD<Person> {

	
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

	public void read() {
		if(personDao.listPersons()) { 
			//System.out.println("Record has been successfully added!\n");
		}
		else {
			System.out.println("Unsuccessful list person records.");
		}
	}

	public void update(Person person) {

	}

	public void delete(int id_param) {
		if(personDao.deletePerson(id_param)) {
			System.out.println("Record has been successfully deleted!\n");
		}
		else {
			System.out.println("Unsuccessful attempt to delete person record.");
		}
	}

	public void get(int id_param) {
		//if(personDao.getPerson(id_param)) {
//
//		//}
//		//else {
//		//	System.out.println("Get person record unsuccessful.");
		//}
		personDao.getPerson(id_param);
	}

}