package com.service;

import com.model.*;
import com.util.*;

public class Functions {

	private PersonCRUD personCRUD;

	public Functions() {
		personCRUD = new PersonCRUD();
	}

	public void addPerson() {
		Person newPerson = new Person();
		PersonName newPersonName = new PersonName();
		
		newPersonName.setFirstName(Validation.acceptString("Enter new person's first name : "));
		newPersonName.setLastName(Validation.acceptString("Enter new person's last name : "));
		newPersonName.setMiddleName(Validation.acceptString("Enter new person's middle name : "));
		newPersonName.setSuffix(Validation.acceptString("Enter new person's suffix : "));
		newPersonName.setTitle(Validation.acceptString("Enter new person's title : "));

		newPerson.setPersonName(newPersonName);
		newPerson.setBirthday(Validation.validateDate("Enter new person's birthday (mm/dd/yyyy) : "));
		newPerson.setGWA(Validation.validateFloat("Enter new person's Grade Weighted Average : "));
		newPerson.setDateHired(Validation.validateDate("Enter new person's Date Hired (mm/dd/yyyy) : "));
		newPerson.setCurrentlyEmployed(Validation.acceptBoolean("Enter if new person is currently employed (true/false) : "));
		newPerson.setPersonGender(Validation.validateGender("Enter new person's gender : "));

		personCRUD.create(newPerson);
	}

	public void listPersons() {
		personCRUD.read();
	}

	public void getPerson() {
		personCRUD.get(Validation.enterInteger("Enter id : "));
	}

	public void deletePerson() {
		personCRUD.delete(Validation.enterInteger("Enter id : "));
	}

}