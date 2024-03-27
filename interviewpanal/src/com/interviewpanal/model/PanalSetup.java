package com.interviewpanal.model;

public class PanalSetup {
	private static PanalSetup panalSetup;
	private String panalName;
	private String panalDate;

	private PanalSetup() {

	}

	public static PanalSetup getInstance() {
		if (panalSetup == null) {
			panalSetup = new PanalSetup();
		}
		return panalSetup;
	}

	public String getPanalName() {
		return panalName;
	}

	public void setPanalName(String panalName) {
		this.panalName = panalName;
	}

	public String getPanalDate() {
		return panalDate;
	}

	public void setPanalDate(String panaldate) {
		this.panalDate = panaldate;
	}
}
