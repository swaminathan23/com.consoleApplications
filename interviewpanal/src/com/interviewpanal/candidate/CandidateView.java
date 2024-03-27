package com.interviewpanal.candidate;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.interviewpanal.datalayer.DataLayer;
import com.interviewpanal.model.Candidate;

public class CandidateView {
	Scanner s = new Scanner(System.in);
	private CandidateModel candidateModel;

	public CandidateView() {
		candidateModel = new CandidateModel(this);
	}

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

	public static boolean validateEmail(String email, Pattern pattern) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
public String name() {
	return s.next();
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
public String checkContact(String contact) {
	if(contact.length()==10) {
		return contact;
	}
	else {
		System.out.println("please enter correct contact");
		checkContact(s.next());
	}
	return contact;
	
}
	public void addCandidate() {
		System.out.println("enter candidate name");
		String candidateName = s.next();
		candidateName = checkName(candidateName);
		System.out.println("enter candidate email");
		String candidateEmailId = s.next();
		candidateEmailId = checkEmail(candidateEmailId);
		candidateModel.checkEmailForMulti(candidateEmailId);
		System.out.println("enter contact info");
		String contact=s.next();
		contact=checkContact(contact);
		s.nextLine();
		System.out.println("enter the address");
		String address=s.nextLine();
		candidateModel.adding(candidateName, candidateEmailId,contact,address);
		System.out.println("candidate added");
	}

	public void enterString(String a) {
		System.out.println(a);
	}

	public void printCandidate() {
		candidateModel.printingCandidate();
	}

	public void remain() {
candidateModel.remaining();
		
	}

	public void sendCandidate() {
		candidateModel.sendCandidate1();
	}
}
