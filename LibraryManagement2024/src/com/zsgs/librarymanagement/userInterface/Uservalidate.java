package com.zsgs.librarymanagement.userInterface;

import java.util.Scanner;

import com.zsgs.librarymanagement.model.User;

public class Uservalidate {
	private LendBook lendBook;

	public Uservalidate() {
		lendBook = new LendBook(this);
	}

	Scanner s = new Scanner(System.in);

	public boolean userValidated(String name, String emailid) {
		User u = null;

		u = lendBook.checkUser(name, emailid);
		if (u == null) {
			System.out.println("no");
			return false;}
		else {
		System.out.println("yes");	
			return true;
	}}

	public void enterString(String a) {
		System.out.println(a);
	}

	public void lendBook(String name, String emailid) {
		User u = lendBook.checkUser(name, emailid);
		if(u!=null) {
		System.out.println("enter book name");
		String bookName = s.next();
		lendBook.lending(u, bookName);}
		else System.out.println("no user available");
	}
    public void userlendedBook(String name, String emailid) {
    	User u=lendBook.checkUser(name, emailid);
    	if(u!=null) {
    		lendBook.userBook(u);
    	}
    	else System.out.println("no user available");
    }
	public void returnBook(String name, String emailid) {
		User u = lendBook.checkUser(name, emailid);
		System.out.println("enter book name");
		String bookName = s.next();
		lendBook.returning(u, bookName);
	}

	public void getBook() {
		// User u=lendBook.checkUser(name,emailid);
		System.out.println("enter book name");
		String bookName = s.next();
		lendBook.getBookName(bookName);
	}
	
}
