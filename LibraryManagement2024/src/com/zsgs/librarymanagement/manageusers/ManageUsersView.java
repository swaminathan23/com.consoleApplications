package com.zsgs.librarymanagement.manageusers;

import java.util.Scanner;

import com.zsgs.librarymanagement.Validation;
import com.zsgs.librarymanagement.model.User;

public class ManageUsersView {

	private ManageUsersModel manageUserModel;

	public ManageUsersView() {
		manageUserModel = new ManageUsersModel(this);
	}

	Scanner scanner = new Scanner(System.in);

	public void initAdd() {
		System.out.println("Enter the following user Details: ");
		User user = new User();
		Validation v = new Validation();
		System.out.println("\nEnter user name:");
		user.setName(v.checkName(scanner.nextLine()));
		System.out.println("\nEnter user emailId:");
		user.setEmailId(v.checkEmail(scanner.next()));
		manageUserModel.addNewUser(user);
	}

	public void removeUser() {
		System.out.println("\nEnter user name:");
		String name = scanner.nextLine();
		System.out.println("\nEnter user email:");
		String email = scanner.nextLine();
		manageUserModel.mainRemove(name, email);
	}

	public void showLibraryName(String libraryName) {
		System.out.println("Current Library Name - " + libraryName);
	}

	public void onUserAdded(User user) {
		System.out.println("\n------- User '" + user.getName() + "' added successfully ------- \n");
		checkForAddNewUser();
	}

	public void enterString(String a) {
		System.out.println(a);
	}

	public void onUserExist(User user) {
		System.out.println("\n------- User '" + user.getName() + "' already exist -------\n");
		checkForAddNewUser();
	}

	public void viewUser() {
		manageUserModel.getUserView();
	}

	private void checkForAddNewUser() {
		System.out.println("Do you want to add more users? \nType Yes/No");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		if (choice.equalsIgnoreCase("yes")) {
			initAdd();
		} else if (choice.equalsIgnoreCase("no")) {
			System.out.println("\n Thanks for adding users");
		} else {
			System.out.println("\nInvalid choice, Please enter valid choice.\n");
			checkForAddNewUser();
		}
	}
}
