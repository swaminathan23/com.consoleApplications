package com.interviewpanal.panalsetup;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.DateFormatter;

import com.interviewpanal.InterviewMainPanal;
import com.interviewpanal.candidate.CandidateView;
import com.interviewpanal.datalayer.DataLayer;
import com.interviewpanal.login.LoginView;
import com.interviewpanal.model.PanalSetup;

public class PanalView {
	Scanner s = new Scanner(System.in);
	private PanalModel panalModel;
	private LoginView loginView;

	public PanalView() {
		panalModel = new PanalModel(this);
		loginView = new LoginView();
	}

	public String checkName(String name) {
		String name1 = name;
		if (name1.length() < 20 && name1.length() > 3) {
			return name1;
		} else {
			System.out.println("please enter valid name");
			name=checkName(s.next());

		}
		return name1;
	}

////date check for no future
//	public static boolean isValidDate(String dateStr, Pattern pattern1) {
//		Matcher matcher = pattern1.matcher(dateStr);
//		return matcher.matches();
//	}
//
//	public String checkDate(String date) {
//		String date1 = date;
//		String DATE_REGEX = "^\\d{2}-\\d{2}-\\d{4}$";
//		Pattern pattern1 = Pattern.compile(DATE_REGEX);
//		if (isValidDate(date, pattern1)) {
//			return date;
//		} else {
//			System.out.println("enter valid date");
//			date=checkDate(s.next());
//		}
//		return date;
//	}

	public void init() {
		System.out.println("enter Panel name");
		String panalName = s.next();
		panalName = checkName(panalName);

//		System.out.println("enter panal date(dd-mm-yyyy)");
//		String panalDate = s.next();
		LocalDate panalDate = LocalDate.now();
		DateTimeFormatter f=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String fd=panalDate.format(f);
		panalModel.init(panalName, fd);

	}

	public void panalSetupComplete() {
		System.out.println("\n----" + PanalSetup.getInstance().getPanalName() + "----"
				+ PanalSetup.getInstance().getPanalDate() + "---");
		while (true) {
			System.out.println("\n enter\n 1. adding candidate" + "\n 2. view candidate" + "\n 3. view queue"
					+ "\n 4. send candidate" + "\n 5. exit \n 6. logout\n 7. deleting data");
			int a = s.nextInt();
			if (a == 1) {
				CandidateView candidate = new CandidateView();
				candidate.addCandidate();
			}
			if (a == 2) {
				CandidateView candidate = new CandidateView();
				candidate.printCandidate();
			}
			if (a == 3) {
				CandidateView candidate = new CandidateView();
				candidate.remain();
			}
			if (a == 4) {
				CandidateView candidate = new CandidateView();
				candidate.sendCandidate();
			}
			if (a == 5) {
				DataLayer.getInstance().clearqueue();
				System.exit(0);
			}
			if(a==7) {
				DataLayer.getInstance().resetData();
			}
			if (a == 6)
				loginView.adminLogin();
		}
	}

	public void enterstring(String a) {
		System.out.println(a);
	}
}
