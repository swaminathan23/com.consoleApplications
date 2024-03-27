package com.interviewpanal;

import com.interviewpanal.datalayer.DataLayer;
import com.interviewpanal.login.LoginView;

public class InterviewMainPanal {
	private static InterviewMainPanal interviewPanal;
	private String interviewPanalName = "zoho interview panel";
	private String panaluser = "admin";

	private InterviewMainPanal() {
	}

	public static InterviewMainPanal getInstance() {
		if (interviewPanal == null) {
			interviewPanal = new InterviewMainPanal();
		}
		return interviewPanal;
	}

	private void init() {
		if(DataLayer.getInstance().checkData()) {
			DataLayer.getInstance().retriveData();
		}
		
		LoginView loginView = new LoginView();
		loginView.adminLogin();
	}

	public String getInterviewPanalName() {
		return interviewPanalName;
	}

	public String getPanalUser() {
		return panaluser;
	}

	public static void main(String[] args) {
		InterviewMainPanal.getInstance().init();
	}
}
