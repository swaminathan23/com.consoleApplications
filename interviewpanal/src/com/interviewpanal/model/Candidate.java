package com.interviewpanal.model;

public class Candidate {
	private String candidaterName;
	private String candidateEmailId;

private String candidateContactInfo;
private String status;
//private int candidateYearOfPassout; 
private String candidateAddress;
	public String getCandidaterName() {
		return candidaterName;
	}

	public void setCandidaterName(String candidaterName) {
		this.candidaterName = candidaterName;
	}

	public String getCandidateEmailId() {
		return candidateEmailId;
	}

	public void setCandidateEmailId(String candidateEmailId) {
		this.candidateEmailId = candidateEmailId;
	}
public String getCandidateContactInfo() {
	return candidateContactInfo;
}
public void setCandidateContactInfo(String candidateContactInfo) {
	this.candidateContactInfo = candidateContactInfo;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
//public int getCandidateYearOfPassout() {
//	return candidateYearOfPassout;
//}
//public void setCandidateYearOfPassout(int candidateYearOfPassout) {
//	this.candidateYearOfPassout = candidateYearOfPassout;
//}
public String getCandidateAddress() {
	return candidateAddress;
}
public void setCandidateAddress(String candidateAddress) {
	this.candidateAddress = candidateAddress;
}

}
