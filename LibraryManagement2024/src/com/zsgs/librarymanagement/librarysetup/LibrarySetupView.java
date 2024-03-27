package com.zsgs.librarymanagement.librarysetup;

import java.util.Scanner;
import com.zsgs.librarymanagement.LibraryManagement2024;
import com.zsgs.librarymanagement.Validation;
import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.login.LoginView;
import com.zsgs.librarymanagement.managebooks.ManageBookView;
import com.zsgs.librarymanagement.manageusers.ManageUsersView;
import com.zsgs.librarymanagement.model.Library;
import com.zsgs.librarymanagement.show.ShowView;
import com.zsgs.librarymanagement.userInterface.Uservalidate;

public class LibrarySetupView {
	private LibrarySetupModel librarySetupModel;

	public LibrarySetupView() {
		librarySetupModel = new LibrarySetupModel(this);
	}

	public void init() {
		librarySetupModel.startSetup();
	}

	Scanner scanner = new Scanner(System.in);

	public boolean confirmation() {
		System.out.println("do you really want to reset?\n yes or no");
		String a = scanner.next();
		boolean b = true;
		if (a.equalsIgnoreCase("yes"))
			return true;
		else if (a.equalsIgnoreCase("no"))
			return false;
		else {
			System.out.println("enter valid option");
			b = confirmation();
		}
		return b;

	}

	public void onSetupComplete(Library library) {
		System.out.println("\nLibrary setup completed\n");
		System.out.println("\nCurrent Library Name - " + library.getLibraryName());
		System.out.println(
				"1. manage book\n 2.manage user \n 3.userinterface \n 4.reset data\n5.save data \n 9. Logout \n 0. Exit \n Enter your Choice:");

		int choice = scanner.nextInt();
		while (true) {

			switch (choice) {
			case 1:
				managebook(library);
				break;
			case 2:
				manageuser(library);
				break;
			case 3:
				userInterface(library);
				break;
			case 4:
				if (confirmation()) {
					LibraryDatabase.getInstance().resetData();
				onSetupComplete(library);}
				else {
					onSetupComplete(library);
				}
				break;
			case 5:
				System.out.println("upload data to folder");
				LibraryDatabase.getInstance().saveData();
				onSetupComplete(library);
				return;
			case 9:
				System.out.println("\n-- You are logged out successfully -- \n\n");
				new LoginView().init();
				return; // Exit from the current session
			case 0:

				System.out.println("\n-- Thanks for using " + LibraryManagement2024.getInstance().getAppName() + " --");
				System.exit(0); // Exit from the application
			default:
				System.out.println("\nPlease Enter valid choice\n");
			}
		}
	}

	public void userInterface(Library library) {
		Uservalidate user = new Uservalidate();
		System.out.println("enter your name");
		String name = scanner.next();
		System.out.println("enter your emailid");
		String emailid = scanner.next();
		if (user.userValidated(name, emailid)) {
			System.out.println("user-------");
			while (true) {
				System.out.println("enter 1.lending book\n 2.returning book"
						+ "\n 3.view avialable book \n 4.userLended book \n 5.return");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					user.lendBook(name, emailid);
					break;
				case 2:
					user.returnBook(name, emailid);
					break;
				case 3:
					user.getBook();
					break;
				case 4:
					user.userlendedBook(name, emailid);
					break;
				case 5:
					onSetupComplete(library);
					break;
				}
			}
		} else {
			onSetupComplete(library);
		}
	}

	public void manageuser(Library library) {
		while (true) {
			System.out.println("\n 1. Add user\n2.view user\n 3.remove user\n 5.return");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				new ManageUsersView().initAdd();
				break;
			case 2:
				new ManageUsersView().viewUser();
				break;
			case 3:
				new ManageUsersView().removeUser();
				break;

			case 5:
				onSetupComplete(library);
				break;
			}
		}
	}

	public void managebook(Library library) {
		exit: while (true) {
			System.out.println("\\n 1. Add Book \n 2. Search Book \n 3.remove book\n 4.get book\n 5.return");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				new ManageBookView().initAdd();
				break;
			case 2:
				new ShowView().getBook();
				break;
			case 3:
				new ShowView().removeBook();
				break;
			case 4:
				new ShowView().showBook();
				break;
			case 5:
				onSetupComplete(library);
				break;
			}
		}
	}

	public void showAlert(String alert) {
		System.out.println(alert);
		initiateSetup();
	}

	public void initiateSetup() {
		System.out.println("\n\nEnter library details:");
		Scanner scanner = new Scanner(System.in);
		Library library = new Library();
		Validation v = new Validation();
		System.out.println("\nEnter library name:");
		library.setLibraryName(v.checkName(scanner.nextLine()));
		System.out.println("\nEnter library email:");
		library.setEmailId(v.checkEmail(scanner.nextLine()));
		librarySetupModel.createLibrary(library);
	}
}
