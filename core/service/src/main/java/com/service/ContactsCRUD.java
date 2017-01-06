package com.service;

import com.model.*;
//import com.dao.*;
import com.util.*;

import java.util.*;

public class ContactsCRUD implements CRUD<Person> {

	private PersonCRUD personCRUD;
	
	public ContactsCRUD() {
		personCRUD = new PersonCRUD();
	}

	public List<Person> read(int param) {return null;}

	//public void delete(int i) {}

	public void create(Person person) {
		Contacts newContact;
		Set<Contacts> contactSet;
		boolean addNew = true;

		while(addNew) {
			newContact = new Contacts();
			boolean choice = false;
			String answer;

			contactSet = person.getContacts();

			if(contactSet == null) {
				contactSet = new HashSet<Contacts>();
				person.setContacts(contactSet);
				contactSet = person.getContacts();
			}

			while(!choice) {
				int iContactType = Validation.enterInteger("Choose type of contact (1) Landline | (2) Mobile | (3) Email : ");
				
				switch(iContactType) {
					case 1 :
						newContact.setType(ContactType.LANDLINE);
						choice = true;
						break;
					case 2 :
						newContact.setType(ContactType.MOBILE);
						choice = true;
						break;
					case 3 :
						newContact.setType(ContactType.EMAIL);
						choice = true;
						break;
					default :
						System.out.println("There is no contact type for that number.");
						break;
				}
			}
			
			newContact.setValue(Validation.acceptString("Enter new person's " + newContact.getType().toString().toLowerCase() + " : "));

			contactSet.add(newContact);

			choice = false;
			answer = Validation.acceptString("Would you like to add another contact to this person? (y/n) : ");
			
			while(!choice) {
				switch(answer) {
					case "Y" : case "y" :
						choice = true;
						break;
					case "N" : case "n" :
						choice = true;
						addNew = false;
						break;
					default :
						answer = Validation.acceptString("Would you like to add another contact to this person? (y/n) : ");
						break;
				}
			}
		}

		personCRUD.update(person);
	}

	public void update(Person person) {
		Set<Contacts> setContacts = person.getContacts();

		if(!setContacts.isEmpty()) {
			Contacts updateContact = new Contacts();
			List idList = new ArrayList<Integer>();
			int contactId;
			boolean exists = false;
			boolean choice = false;

			System.out.println("(Id) Type = Value");
			for(Contacts contact : setContacts) {
				System.out.println("\t(" + contact.getId() + ") " + contact.getType() + " = " + contact.getValue());
				idList.add(contact.getId());
			}

			while(!exists) {
				contactId = Validation.enterInteger("Enter Contact Id to be updated : ");

				if(idList.contains(contactId)) {
					exists = true;

					for(Contacts contact : setContacts) {
						if(contact.getId() == contactId) {
							updateContact = contact;
							break;
						}
					}
				}
				else {
					System.out.println("Contact Id does not exist.");
				}
			}

			while(!choice) {
				int iContactType = Validation.enterInteger("Choose type of contact (1) Landline | (2) Mobile | (3) Email : ");
				
				switch(iContactType) {
					case 1 :
						updateContact.setType(ContactType.LANDLINE);
						choice = true;
						break;
					case 2 :
						updateContact.setType(ContactType.MOBILE);
						choice = true;
						break;
					case 3 :
						updateContact.setType(ContactType.EMAIL);
						choice = true;
						break;
					default :
						System.out.println("There is no contact type for that number.");
						break;
				}
			}
			
			updateContact.setValue(Validation.acceptString("Enter new person's " + updateContact.getType().toString().toLowerCase() + " : "));

			personCRUD.update(person);
		}
		else {
			System.out.println("There are no contacts.");
		}
	}

	public void delete(Person person) {
		Set<Contacts> setContacts = person.getContacts();

		if(!setContacts.isEmpty()) {
			Contacts deleteContact = new Contacts();
			List idList = new ArrayList<Integer>();
			int contactId = 0;
			boolean exists = false;
			boolean choice = false;

			System.out.println("(Id) Type = Value");
			for(Contacts contact : setContacts) {
				System.out.println("\t(" + contact.getId() + ") " + contact.getType() + " = " + contact.getValue());
				idList.add(contact.getId());
			}

			while(!exists) {
				contactId = Validation.enterInteger("Enter Contact Id to delete : ");

				if(idList.contains(contactId)) {
					exists = true;

					for(Contacts contact : setContacts) {
						if(contact.getId() == contactId) {
							deleteContact = contact;
							break;
						}
					}
				}
				else {
					System.out.println("Contact Id does not exist.");
				}
			}

			String strContactType = Validation.acceptString("Are you sure you want to delete this contact " + deleteContact.getType() + " = " + deleteContact.getValue() + " ? (y/n) : ");
			while(!choice) {	
				switch(strContactType) {
					case "Y" : case "y" :
						for(Contacts contact : setContacts) {
							if(contact.getId() == contactId) {
								setContacts.remove(contact);
								break;
							}
						}

						personCRUD.update(person);
						choice = true;
						break;
					case "N" : case "n" :
						choice = true;
						break;
					default :
						strContactType = Validation.acceptString("Are you sure you want to delete this contact " + deleteContact.getType() + " = " + deleteContact.getValue() + " ? (y/n) : ");
						break;
				}
			}
		}
		else {
			System.out.println("There are no contacts.");
		}
	}

}