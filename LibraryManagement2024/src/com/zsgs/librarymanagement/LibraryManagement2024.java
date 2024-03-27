package com.zsgs.librarymanagement;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.login.LoginView;

public class LibraryManagement2024 {
	private static LibraryManagement2024 libraryManagement;
	private String appName = "Library Management System";
	private String appVersion = "0.1.0";

	private LibraryManagement2024() {
	}

	public static LibraryManagement2024 getInstance() {
		if (libraryManagement == null) {
			libraryManagement = new LibraryManagement2024();
		}
		return libraryManagement;
	}

	private void create() {
		LoginView loginView = new LoginView();
		if(LibraryDatabase.getInstance().checkData()) {
			LibraryDatabase.getInstance().retriveData();
		}
		
		loginView.init();
	}

	public String getAppName() {
		return appName;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public static void main(String arg[]) {
		LibraryManagement2024.getInstance().create();
	}
}
