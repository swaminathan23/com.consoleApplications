package com.interviewpanal.cerdentialsmodel;

import com.interviewpanal.model.LoginCredentials;

public class LoginCredentialsModel {
	private static LoginCredentialsModel loginCredentialsModel;
	private LoginCredentials logincredentials = new LoginCredentials();;

	public static LoginCredentialsModel getInstance() {
		if (loginCredentialsModel == null) {
			loginCredentialsModel = new LoginCredentialsModel();
		}
		return loginCredentialsModel;
	}

	public String getUserName() {
		return logincredentials.getUserName();

	}

	public String getPassword() {
		return logincredentials.getPassword();
	}

	public void setUserName(String userName) {
		logincredentials.setUserName(userName);
	}

	public void setPassword(String password) {
		logincredentials.setPassword(password);
	}
}
