package com.interviewpanal.login;

import java.util.Scanner;

import com.interviewpanal.InterviewMainPanal;

public class LoginView {
	Scanner s = new Scanner(System.in);
	private LoginModel loginModel;

	public LoginView() {
		loginModel = new LoginModel(this);
	}

	public void adminLogin() {
		System.out.println(" welcome ---" + InterviewMainPanal.getInstance().getInterviewPanalName() + "-----"
				+ InterviewMainPanal.getInstance().getPanalUser() + "\n\n login \n --------- ");

		while (true) {
			System.out.println("enter username");
			String userName = s.next();
			System.out.println("enter password");
			String password = s.next();
			loginModel.validateUser(userName, password);
			System.out.println(
					" -----enter \n 1 for login\n 2 for changing password\n 3 to end session-----\nenter your option(int)  ");
			int a = s.nextInt();
			if (a == 1) {
				loginModel.enter();
			}
			if (a == 2) {
				loginModel.changePassword(userName, password);
			}
			if (a == 3)
				System.exit(0);
		}
	}

	public void enterText(String a) {
		System.out.println(a);
	}

	public String enterString() {
		String a = s.next();
		return a;
	}

	public void optionLogin() {
		System.out.println("enter yes for try again or\n no for exit");
		String answer = s.next();
		loginModel.checkOption(answer);
	}

}
