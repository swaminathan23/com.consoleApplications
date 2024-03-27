package com.interviewpanal.datalayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.interviewpanal.model.Candidate;

public class DataLayer {
	private static DataLayer dataLayer;
	private static final String FILE_PATH = "C:\\Users\\nandhu\\Desktop\\java zoho\\task 2\\interviewpanal\\src\\com\\interviewpanal\\json.json";
	List<Candidate> candidate = new ArrayList<>();
	private static Gson gson = new Gson();
	ArrayDeque<Candidate> candidateinterview = new ArrayDeque<Candidate>();

	public static DataLayer getInstance() {
		if (dataLayer == null) {
			dataLayer = new DataLayer();
		}
		return dataLayer;
	}

	public void saveData() {
		try (FileWriter f = new FileWriter(FILE_PATH)) {
			gson.toJson(this, f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
//		e.printStackTrace();
		}
	}

	public void clearqueue() {
		candidateinterview.clear();
	}

	public void resetData() {
		File f = new File("C:\\Users\\nandhu\\Desktop\\java zoho\\task 2\\interviewpanal\\src\\com\\interviewpanal");
		File files[] = f.listFiles();
		for (File file : files) {
		if (file.getName().endsWith(".json")) {
			file.delete();
		}
		}
		
	}
	public boolean checkData() {
		File f = new File("C:\\Users\\nandhu\\Desktop\\java zoho\\task 2\\interviewpanal\\src\\com\\interviewpanal");
		File files[] = f.listFiles();
		for (File file : files) {
		if (file.getName().endsWith(".json")) {
			//file.delete();
			if(file.length()!=0)
			return true;
		}
		}
		return false;
	}
	public void retriveData() {
		try (FileReader f1 = new FileReader(FILE_PATH)) {
			DataLayer d = gson.fromJson(f1, DataLayer.class);
			candidate = d.candidate;
			candidateinterview = d.candidateinterview;
		} catch (IOException e) {
			// TODO Auto-generated catch block
//		e.printStackTrace();
		}
	}

	public void setCandidateList(Candidate candidate) {
		this.candidate.add(candidate);
		setCandidateInterview(candidate);
	}

	public List<Candidate> sendList() {
		return candidate;
	}

	public void setCandidateInterview(Candidate candidate) {
		candidateinterview.add(candidate);
	}

	public ArrayDeque<Candidate> remaincandidate() {
		return candidateinterview;
	}

	public void queueremoval() {
		candidateinterview.poll();
	}
}
