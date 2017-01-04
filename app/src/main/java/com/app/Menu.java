package com.app;

import com.util.*;
import com.service.*;

public class Menu {

	private Functions function;

	public Menu() {
		function = new Functions();

		System.out.println("\nMINI REGISTRATION SYSTEM\n");

		this.startMenu();
	}

	private void startMenu() {
		int iAction = 0;

		while(iAction != 8) {
			System.out.println("\nActions (Enter the number of the desired action) :");
			System.out.println("(1) Register Person");
			System.out.println("(2) Update Person record");
			System.out.println("(3) Delete Person record");
			System.out.println("(4) Print list of Person record\n");
			System.out.println("(5) Add Contact to Person");
			System.out.println("(6) Update Contact of Person");
			System.out.println("(7) Delete Contact of Person\n");
			System.out.println("(8) Exit\n");

			iAction = Validation.enterInteger("Action no.: ");

			switch(iAction) {

				case 1 :
					System.out.println("Register Person");
					function.addPerson();
					break;
				case 2 :
					System.out.println("Update Person record");
					function.getPerson();	//get record, print, get new record, update
					break;
				case 3 :
					System.out.println("Delete Person record");
					function.deletePerson();
					break;
				case 4 :
					System.out.println("List of Person record");	//sort
					function.listPersons();
					break;
				case 5 :
					System.out.println("Add Contact to Person");
					//action.addRow(false, null);
					break;
				case 6 :
					System.out.println("Update Contact of Person");
					//action.sort();
					break;
				case 7 :
					System.out.println("Delete Contact of Person");
					break;
				case 8 :
					System.out.println("Exit\n");
					System.exit(0);
					break;
				default : 
					System.out.println("There is no action for that number.");	//then print menu again
					break;
			}
		}

	}
}