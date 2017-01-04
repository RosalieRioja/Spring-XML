package com.model;

public class PersonAddress {

	private int id;	//serial primary key
	private int streetNumber;
	private String barangay;
	private String city;
	private int zipCode;

	public PersonAddress() {}

	public PersonAddress(int stNumber_param, String brgy_param, String city_param, int zipcode_param) {
		
		this.setStreetNumber(stNumber_param);
		this.setBarangay(brgy_param);
		this.setCity(city_param);
		this.setZipCode(zipcode_param);
	}

	public void setId(int id_param) {
		this.id = id_param;
	}

	public void setStreetNumber(int stNumber_param) {
		this.streetNumber = stNumber_param;
	}

	public void setBarangay(String brgy_param) {
		this.barangay = brgy_param;
	}

	public void setCity(String city_param) {
		this.city = city_param;
	}

	public void setZipCode(int zipcode_param) {
		this.zipCode = zipcode_param;
	}

	public int getId() {
		return this.id;
	}

	public int getStreetNumber() {
		return this.streetNumber;
	}

	public String getBarangay() {
		return this.barangay;
	}

	public String getCity() {
		return this.city;
	}

	public int getZipCode() {
		return this.zipCode;
	}

}