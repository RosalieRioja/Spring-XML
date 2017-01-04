package com.model;

import java.util.*;

import com.util.PersonGender;

public class Person {

	private int id;	//serial primary key
<<<<<<< HEAD
	private PersonName name;
=======
	//private String firstName;
	//private String lastName;
	//private String middleName;
	//private String suffix;
	//private String title;
	private PersonName personName;
>>>>>>> 73f5e5b4ca6f3300f19dc4612b4298afad1366ec
	private Date birthday;
	private float GWA;
	private Date dateHired;
	private boolean currentlyEmployed;
	private PersonGender gender;
<<<<<<< HEAD
	private PersonAddress address;

	public Person() {}
=======

	public Person() {}
/*
	public Person(PersonName personName_param,	//String fname_param, String lname_param, String mname_param, String suffix_param, String title_param,
		Date bday_param, float gwa_param, Date datehired_param, boolean currEmployed_param, PersonGender gender_param) {
		
		//this.setFirstName(fname_param);
		//this.setLastName(lname_param);
		//this.setMiddleName(mname_param);
		//this.setSuffix(suffix_param);
		//this.setTitle(title_param);
		this.setPersonName(personName_param);
		this.setBirthday(bday_param);
		this.setGWA(gwa_param);
		this.setDateHired(datehired_param);
		this.setCurrentlyEmployed(currEmployed_param);
		this.setGender(gender_param);
	}

	//public getPerson() {
	//	;
	//}
>>>>>>> 73f5e5b4ca6f3300f19dc4612b4298afad1366ec

	public void setId(int id_param) {
		this.id = id_param;
	}

<<<<<<< HEAD
	public void setName(PersonName name_param) {
		this.name = name_param;
	}

=======
	public void setPersonName(PersonName personName_param) {
		this.personName = personName_param;
	}
/*
	public void setFirstName(String fname_param) {
		this.firstName = fname_param;
	}

	public void setLastName(String lname_param) {
		this.lastName = lname_param;
	}

	public void setMiddleName(String mname_param) {
		this.middleName = mname_param;
	}

	public void setSuffix(String suffix_param) {
		this.suffix = suffix_param;
	}

	public void setTitle(String title_param) {
		this.title = title_param;
	}
*/
>>>>>>> 73f5e5b4ca6f3300f19dc4612b4298afad1366ec
	public void setBirthday(Date bday_param) {
		this.birthday = bday_param;
	}

	public void setGWA(float gwa_param) {
		this.GWA = gwa_param;
	}

	public void setDateHired(Date datehired_param) {
		this.dateHired = datehired_param;
	}

	public void setCurrentlyEmployed(boolean currEmployed_param) {
		this.currentlyEmployed = currEmployed_param;
	}

	public void setGender(PersonGender gender_param) {
		this.gender = gender_param;
	}

<<<<<<< HEAD
	public void setAddress(PersonAddress address_param) {
		this.address = address_param;
	}

=======
>>>>>>> 73f5e5b4ca6f3300f19dc4612b4298afad1366ec
	public int getId() {
		return this.id;
	}

<<<<<<< HEAD
	public PersonName getName() {
		return this.name;
	}

=======
	public PersonName getPersonName() {
		return this.personName;
	}
/*
	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public String getTitle() {
		return this.title;
	}
*/
>>>>>>> 73f5e5b4ca6f3300f19dc4612b4298afad1366ec
	public Date getBirthday() {
		return this.birthday;
	}

	public float getGWA() {
		return this.GWA;
	}

	public Date getDateHired() {
		return this.dateHired;
	}

	public boolean getCurrentlyEmployed() {
		return this.currentlyEmployed;
	}

	public PersonGender getGender() {
		return this.gender;
	}

<<<<<<< HEAD
	public PersonAddress getAddress() {
		return this.address;
	}

=======
>>>>>>> 73f5e5b4ca6f3300f19dc4612b4298afad1366ec
}