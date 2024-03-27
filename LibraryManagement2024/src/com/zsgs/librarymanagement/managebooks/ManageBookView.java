package com.zsgs.librarymanagement.managebooks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.zsgs.librarymanagement.Validation;
import com.zsgs.librarymanagement.model.Book;

public class ManageBookView {

	private ManageBookModel manageBookModel;

	public ManageBookView() {
		manageBookModel = new ManageBookModel(this);
	}

	public void initAdd() {
		System.out.println("\nEnter book details: ");
		Scanner scanner = new Scanner(System.in);
		Validation v = new Validation();
		System.out.println("\nEnter book name:");
		String name = scanner.nextLine();
		name = v.checkName(name);
		System.out.println("\nEnter book author:");
		String authur = scanner.nextLine();
		authur = v.checkEmail(authur);
		System.out.println("\n enter count");
		int count = scanner.nextInt();
		count = v.checkInt(count);
		Book book = new Book(name, authur, count);
		manageBookModel.addNewBook(book);
	}

	public void showLibraryName(String libraryName) {
		System.out.println("Current Library Name - " + libraryName);
	}

	public void onBookAdded(Book book) {
		System.out.println("\n------- Book '" + book.getName() + "' added successfully ------- \n");
		checkForAddNewBook();
	}

	public void onBookExist(Book book) {
		System.out.println("\n------- Book '" + book.getName() + "' already exist -------\n");
		checkForAddNewBook();
	}

	private void checkForAddNewBook() {

		System.out.println("\nDo you want to add more books? \nType Yes/No");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		if (choice.equalsIgnoreCase("yes")) {
			initAdd();
		} else if (choice.equalsIgnoreCase("no")) {
			System.out.println("\n Thanks for adding books");
		} else {
			System.out.println("\nInvalid choice, Please enter valid choice.\n");
			checkForAddNewBook();
		}

	}
}
