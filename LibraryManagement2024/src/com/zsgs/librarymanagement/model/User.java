package com.zsgs.librarymanagement.model;

import java.util.ArrayList;

public class User {

	private String name;
	private int id;
	private String phoneNo;
	private String emailId;
	private String address;
	private ArrayList<Book> listOfLended = new ArrayList<Book>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Book> getListOfLended() {
		return listOfLended;
	}

	public void setListOfLended(ArrayList<Book> listOfLended) {
		this.listOfLended = listOfLended;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
