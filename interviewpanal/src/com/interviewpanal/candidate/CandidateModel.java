package com.interviewpanal.candidate;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.interviewpanal.datalayer.DataLayer;
import com.interviewpanal.model.Candidate;

public class CandidateModel {
	

	private CandidateView candidateView;

	CandidateModel(CandidateView candidateView) {
		this.candidateView = candidateView;
	}

	void adding(String candidateName, String candidateEmailId,String contact,String address) {
		Candidate candidate = new Candidate();
			candidate.setCandidaterName(candidateName);
				candidate.setCandidateEmailId(candidateEmailId);
				candidate.setStatus("not attended");
				candidate.setCandidateContactInfo(contact);
				candidate.setCandidateAddress(address);
				DataLayer.getInstance().setCandidateList(candidate);
				DataLayer.getInstance().saveData();
		
		
	}
	void checkEmailForMulti(String email){
		int a=0;
		List<Candidate> candidate=DataLayer.getInstance().sendList();
		for(Candidate c:candidate) {
			a=1;
			if(email.equals(c.getCandidateEmailId())) {
				candidateView.checkEmail(candidateView.name());
			}
		}
		if(a==0) {
			candidateView.enterString("email already exist");
		}
	}
void changestatus(String name,String email) {
	List<Candidate> candidate=DataLayer.getInstance().sendList();
	for(Candidate e:candidate) {
		if(e.getCandidaterName().equals(name)) {
			if(e.getCandidateEmailId().equals(email)) {
				e.setStatus("attended");
			}
		}
	}
}
public void printingCandidate() {
	List<Candidate> candidate = DataLayer.getInstance().sendList();
	
	int i=1;
	candidateView.enterString("si.no: candidate Name:   candidate email:   candidate status:");
	for (Candidate c : candidate) {
		candidateView.enterString(i++ +"       "+  c.getCandidaterName() +"        "+ c.getCandidateEmailId()
		+"       "+c.getStatus());
	}
}
public void remaining() {
	ArrayDeque<Candidate> candidate = DataLayer.getInstance().remaincandidate();
	if(candidate.size()==0) {candidateView.enterString("no candidate for interview");
	return;}
	candidateView.enterString("si.no: candidate Name:   candidate email:");
	int i=1;
	for (Candidate c : candidate) {
		candidateView.enterString(i++ +"       " + c.getCandidaterName() + "     "+ c.getCandidateEmailId());
	}
}
	public void sendCandidate1() {
		ArrayDeque<Candidate> candidate = DataLayer.getInstance().remaincandidate();
		if (candidate.size() == 0) {
			candidateView.enterString("no candidate present");
		} else {
			candidateView.enterString("candidateName: " + candidate.peek().getCandidaterName() + "  candidateemail: "
					+ candidate.peek().getCandidateEmailId());
			changestatus(candidate.peek().getCandidaterName(),candidate.peek().getCandidateEmailId());
			DataLayer.getInstance().queueremoval();
			candidateView.enterString("candidate have been sended for interview");
		}
	}
}
