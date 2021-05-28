package com.multithreading;

public class AddressBookData {
	
	   public String FirstName;
	   public String LastName;
	   public String Address;
	   public String City;
	   public String State;
	   public String ZipCode;
	   public String PhoneNumber;
	   public String EmailId;
	   public String date_added;
	
	   public AddressBookData(String firstName, String lastName, String address, String city, String state, String zipCode,
			String phoneNumber, String emailId, String date) {
		   
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Address = address;
		this.City = city;
		this.State = state;
		this.ZipCode = zipCode;
		this.PhoneNumber = phoneNumber;
		this.EmailId = emailId;
		this.date_added = date;
	}
}
