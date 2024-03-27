package com.zsgs.librarymanagement;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
Scanner s=new Scanner(System.in); 
	public String checkName(String name) {
		String name1 = name;
		if (name1.length() < 20 && name1.length() > 3) {
			return name1;
		} else {
			System.out.println("enter valid name");
			checkName(s.next());

		}
		return name1;
	}
	public LocalDate nowDate() {
		return LocalDate.now();
	}
	public LocalDate futueDate() {
		return LocalDate.now().plusDays(7);
	}
public int checkInt(int a) {
	if(a>0&&a<1000) {
		return a;
	}
	else {
		System.out.println("enter valid count");
		checkInt(s.nextInt());
	}
	return a;
}
	public static boolean validateEmail(String email, Pattern pattern) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public String checkEmail(String emailid) {
		String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		if (validateEmail(emailid, pattern))
			return emailid;
		else {
			System.out.println("enter valid emailid");
			checkEmail(s.next());
		}
		return emailid;
	}
}
