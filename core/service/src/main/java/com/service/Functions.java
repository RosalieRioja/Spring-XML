package com.service;

import com.model.*;
import com.util.*;

import java.util.*;

public class Functions {

	private PersonCRUD personCRUD;
	private ContactsCRUD contactsCRUD;

	public Functions() {
		personCRUD = new PersonCRUD();
		contactsCRUD = new ContactsCRUD();
	}

	public void addPerson() {
		Person newPerson = new Person();
		PersonName newPersonName = new PersonName();
		PersonAddress newPersonAddress = new PersonAddress();
		String answer;
		boolean choice = false;

		newPersonName.setFirstName(Validation.acceptString("Enter new person's first name : "));
		newPersonName.setLastName(Validation.acceptString("Enter new person's last name : "));
		newPersonName.setMiddleName(Validation.acceptString("Enter new person's middle name : "));
		newPersonName.setSuffix(Validation.acceptString("Enter new person's suffix : "));
		newPersonName.setTitle(Validation.acceptString("Enter new person's title : "));

		System.out.println("Enter new person's address");
		newPersonAddress.setStreetNumber(Validation.enterInteger("Street number : "));
		newPersonAddress.setBarangay(Validation.acceptString("Barangay : "));
		newPersonAddress.setCity(Validation.acceptString("City : "));
		newPersonAddress.setZipCode(Validation.enterInteger("Zip code : "));

		newPerson.setName(newPersonName);
		newPerson.setBirthday(Validation.validateDate("Enter new person's birthday (mm/dd/yyyy) : "));
		newPerson.setGWA(Validation.validateFloat("Enter new person's Grade Weighted Average : "));
		newPerson.setDateHired(Validation.validateDate("Enter new person's Date Hired (mm/dd/yyyy) : "));
		newPerson.setCurrentlyEmployed(Validation.acceptBoolean("Enter if new person is currently employed (true/false) : "));
		newPerson.setGender(Validation.validateGender("Enter new person's gender (MALE/FEMALE) : "));
		newPerson.setAddress(newPersonAddress);

		personCRUD.create(newPerson);

		answer = Validation.acceptString("Do you want to add contact/s to this person? (y/n) : ");

		while(!choice) {
			switch(answer) {
				case "Y" : case "y" :
					choice = true;
					contactsCRUD.create(newPerson);
					break;
				case "N" : case "n" :
					choice = true;
					break;
				default :
					answer = Validation.acceptString("Do you want to add contact/s to this person? (y/n) : ");
					break;
			}
		}
	}

	public void listPersons() {
		/*
		int sort;
		boolean choice = false;
		String sortBy;

		while(!choice) {
			sort = Validation.enterInteger("Sort records by (1) GWA | (2) Date Hired | (3) Last Name | (4) None : ");

			switch(sort) {
				case 1 :
					//gwa
					choice = true;
					break;
				case 2 :
					//date hired
					choice = true;
					break;
				case 3 :
					//last name
					choice = true;
					break;
				case 4 :
					//none
					choice = true;
					break;
			}
		}
		*/
		//
		List<Person> lstPerson = personCRUD.read();

		for (Iterator iterator = lstPerson.iterator(); iterator.hasNext(); ){
			Person person = (Person) iterator.next();
			PersonName personName = person.getName();
			PersonAddress personAddress = person.getAddress();
			Set<Contacts> personContacts = person.getContacts();

			System.out.println("\n=======================================\n");
			System.out.println("\nName: " + personName.getTitle() + " " + personName.getFirstName() + " " + personName.getMiddleName() + " " 
				+ personName.getLastName() + " " + personName.getSuffix());
			System.out.println("Person Id : " + person.getId());
			System.out.println("\tAddress: " + personAddress.getStreetNumber() + " " + personAddress.getBarangay()
				+ " " + personAddress.getCity() + " " + personAddress.getZipCode());
			System.out.println("\tBirthday: " + person.getBirthday());
			System.out.println("\tGWA: " + person.getGWA());
			System.out.println("\tDate Hired: " + person.getDateHired());
			System.out.println("\tCurrently Employed: " + person.getCurrentlyEmployed());
			System.out.println("\tGender: " + person.getGender());
			System.out.println("\tContacts : (Id) Type = Value");
			for(Contacts contact : personContacts) {
				System.out.println("\t\t(" + contact.getId() + ") " + contact.getType() + " = " + contact.getValue());
			}
		}

		System.out.println("\n=======================================\n");
	}

	public void updatePerson() {
		int personId = Validation.enterInteger("Enter Person Id to be updated : ");
		Person person = personCRUD.get(personId);
		
		if(person != null) {
			PersonName personName = person.getName();
			PersonAddress personAddress = person.getAddress();

			System.out.println("\nName: " + personName.getTitle() + " " + personName.getFirstName() + " " + personName.getMiddleName() + " " 
				+ personName.getLastName() + " " + personName.getSuffix());
			System.out.println("Person Id : " + person.getId());
			System.out.println("\tAddress: " + personAddress.getStreetNumber() + " " + personAddress.getBarangay()
				+ " " + personAddress.getCity() + " " + personAddress.getZipCode());
			System.out.println("\tBirthday: " + person.getBirthday());
			System.out.println("\tGWA: " + person.getGWA());
			System.out.println("\tDate Hired: " + person.getDateHired());
			System.out.println("\tCurrently Employed: " + person.getCurrentlyEmployed());
			System.out.println("\tGender: " + person.getGender());

			String answer = Validation.acceptString("\nAre you sure you want to update this record? (y/n) : ");
			boolean choices = false;

			while(!choices) {
				switch(answer) {
					case "Y" : case "y" :
						personName.setFirstName(Validation.acceptString("Enter person's updated first name : "));
						personName.setLastName(Validation.acceptString("Enter person's updated last name : "));
						personName.setMiddleName(Validation.acceptString("Enter person's updated middle name : "));
						personName.setSuffix(Validation.acceptString("Enter person's updated suffix : "));
						personName.setTitle(Validation.acceptString("Enter person's updated title : "));

						System.out.println("Enter person's updated address");
						personAddress.setStreetNumber(Validation.enterInteger("Street number : "));
						personAddress.setBarangay(Validation.acceptString("Barangay : "));
						personAddress.setCity(Validation.acceptString("City : "));
						personAddress.setZipCode(Validation.enterInteger("Zip code : "));

						person.setName(personName);
						person.setBirthday(Validation.validateDate("Enter person's updated birthday (mm/dd/yyyy) : "));
						person.setGWA(Validation.validateFloat("Enter person's updated Grade Weighted Average : "));
						person.setDateHired(Validation.validateDate("Enter person's updated Date Hired (mm/dd/yyyy) : "));
						person.setCurrentlyEmployed(Validation.acceptBoolean("Enter if person is currently employed (true/false) : "));
						person.setGender(Validation.validateGender("Enter person's gender (MALE/FEMALE) : "));
						person.setAddress(personAddress);

						personCRUD.update(person);
						choices = true;
						break;
					case "N" : case "n" :
						choices = true;
						break;
					default :
						answer = Validation.acceptString("\nAre you sure you want to update this record? (y/n) : ");
						break;
				}
			}
		}
	}

	public void deletePerson() {
		int personId = Validation.enterInteger("Enter Person Id to delete : ");
		String answer = Validation.acceptString("Are you sure you want to delete person record " + personId + "? (y/n) : ");
		boolean choices = false;

		while(!choices) {
			switch(answer) {
				case "Y" : case "y" :
					personCRUD.delete(personId);
					choices = true;
					break;
				case "N" : case "n" :
					choices = true;
					break;
				default :
					answer = Validation.acceptString("Are you sure you want to delete person record " + personId + "? (y/n) : ");
					break;
			}
		}
	}

	//================================================================

	public void contactFunction(String action) {
		boolean exists = false;
		int personId;
		Person person;

		while(!exists) {
			personId = Validation.enterInteger("Enter Person Id : ");
			person = personCRUD.get(personId);

			if(person != null) {
				switch(action) {
					case "add" :
						contactsCRUD.create(person);
						break;
					case "update" :
						contactsCRUD.update(person);
						break;
					case "delete" :
						contactsCRUD.delete(person);
						break;
				}
				exists = true;
			}
		}
	}

}