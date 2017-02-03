package com.service;

import com.model.*;
//import com.dao.*;
import com.util.*;

import java.util.*;

public class RolesCRUD {/*implements CRUD<Person> {

	private PersonCRUD personCRUD;
	
	public RolesCRUD() {
		personCRUD = new PersonCRUD();
	}

	public List<Person> read(int param) {return null;}

	//public void delete(int i) {}

	public void create(Person person) {
		Roles newRole;
		Set<Roles> roleSet;
		boolean addNew = true;
		List idList = new ArrayList<Integer>();
		List<Roles> lstRoles = personCRUD.readRoles();

		if(lstRoles != null) {
			System.out.println("\nList of roles : (Id) Role");
			idList.clear();
			for(Roles role : lstRoles) {
				System.out.println("\t\t(" + role.getId() + ") " + role.getValue());
				idList.add(role.getId());
			}
		}

		while(addNew && (lstRoles != null)) {
			newRole = new Roles();
			boolean choice = false;
			String answer;

			roleSet = person.getRoles();

			if(roleSet == null) {
				roleSet = new HashSet<Roles>();
				person.setRoles(roleSet);
				roleSet = person.getRoles();
			}

			while(!choice) {
				int roleId = Validation.enterInteger("Choose role (Id) to assign : ");
				
				if(idList.contains(roleId)) {
					choice = true;

					for(Roles role : lstRoles) {
						if(role.getId() == roleId) {
							newRole = role;
							break;
						}
					}
				}
				else {
					System.out.println("Role Id does not exist.");
				}
			}
			
			roleSet.add(newRole);

			choice = false;
			answer = Validation.acceptString("Would you like to assign another role to this person? (y/n) : ");
			
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
						answer = Validation.acceptString("Would you like to assign another role to this person? (y/n) : ");
						break;
				}
			}
		}

		personCRUD.update(person);

	}

	public void update(Person person) {}

	public void delete(Person person) {
		Set<Roles> roleSet = person.getRoles();

		if(!roleSet.isEmpty()) {
			Roles deleteRole = new Roles();
			List idList = new ArrayList<Integer>();
			int roleId = 0;
			boolean exists = false;
			boolean choice = false;

			System.out.println("(Id) Role");
			for(Roles role : roleSet) {
				System.out.println("\t(" + role.getId() + ") " + role.getValue());
				idList.add(role.getId());
			}

			while(!exists) {
				roleId = Validation.enterInteger("Enter Role Id to delete : ");

				if(idList.contains(roleId)) {
					exists = true;

					for(Roles role : roleSet) {
						if(role.getId() == roleId) {
							deleteRole = role;
							break;
						}
					}
				}
				else {
					System.out.println("Role Id does not exist.");
				}
			}

			String strChoice = Validation.acceptString("Are you sure you want to delete this role " + deleteRole.getValue() + " ? (y/n) : ");
			while(!choice) {	
				switch(strChoice) {
					case "Y" : case "y" :
						for(Roles role : roleSet) {
							if(role.getId() == roleId) {
								roleSet.remove(role);
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
						strChoice = Validation.acceptString("Are you sure you want to delete this role " + deleteRole.getValue() + " ? (y/n) : ");
						break;
				}
			}
		}
		else {
			System.out.println("There are no contacts.");
		}
	}
*/
}