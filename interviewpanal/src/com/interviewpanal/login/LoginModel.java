package com.interviewpanal.login;

import com.interviewpanal.cerdentialsmodel.LoginCredentialsModel;
import com.interviewpanal.panalsetup.PanalView;

public class LoginModel {
	private LoginView loginView;

	LoginModel(LoginView loginView) {
		this.loginView = loginView;
	}

	void enter() {
		PanalView panalView = new PanalView();
		panalView.init();

	}

	void validateUser(String userName, String password) {
		if (LoginCredentialsModel.getInstance().getUserName().equals(userName)) {
			if (LoginCredentialsModel.getInstance().getPassword().equals(password)) {
				loginView.enterText("login successfull");
			} else {
				loginView.enterText("invalid password");
				loginView.optionLogin();
			}
		} else {
			loginView.enterText("invalid user name");
			loginView.optionLogin();
		}
	}

	void changePassword(String userName, String password) {
		if (LoginCredentialsModel.getInstance().getUserName().equals(userName)) {
			if (LoginCredentialsModel.getInstance().getPassword().equals(password)) {
				loginView.enterText("enter new user name");
				LoginCredentialsModel.getInstance().setUserName(loginView.enterString());
				loginView.enterText("enter new password");
				LoginCredentialsModel.getInstance().setPassword(loginView.enterString());
				loginView.enterText("new user set successfully");
				loginView.adminLogin();
			} else {
				loginView.enterText("invalid password");
				loginView.optionLogin();
			}
		} else {
			loginView.enterText("invalid user name");
			loginView.optionLogin();
		}
	}

	void checkOption(String answer) {
		if (answer.equals("yes")) {
			loginView.adminLogin();
		} else if (answer.equals("no")) {
			loginView.enterText("thankyou");
			System.exit(0);
		} else {
			loginView.enterText("invalid answer give proper answer");
			loginView.optionLogin();
		}
	}
}
