package com.task.address.model;

public class Address {
	protected int id;
	protected String name;
	protected String email;
	protected String country;
	protected String streetline1;
	protected String streetline2;
	protected String city;
	protected int pin;
	protected String state;
	
	public Address() {
	}
	
	public Address(String name, String email, String country,String streetline1,String streetline2,String city,int pin,String state) {
		super();
		this.name = name;
		this.email = email;
		this.country = country;
		this.streetline1 = streetline1;
		this.streetline2 = streetline2;
		this.city = city;
		this.pin = pin;
		this.state = state;
		
		
	}

	public Address(int id ,String name, String email, String country,String streetline1,String streetline2,String city,int pin,String state) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.streetline1 = streetline1;
		this.streetline2 = streetline2;
		this.city = city;
		this.pin = pin;
		this.state = state;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreetline1() {
		
		return streetline1;
	}

	public void setStreetline1(String streetline1) {
	this.streetline1 = streetline1;
		
	}

	public String getStreetline2 () { 
		
		return streetline2;
	}

	public void setStreetline2(String streetline2) {
		
		this.streetline2 = streetline2;
	}

	public String getCity() {
		
		return city;
	}

	public void setCity(String city) {
		
		this.city = city;
	}

	public int getPin() {
		
		return pin ;
	}

	public void setPin(int pin) {
		
		this.pin = pin;
	}

	public String getState() {
		
		return state;
	}

	public void setState(String state) {
		
		this.state = state;
	}

	
}
