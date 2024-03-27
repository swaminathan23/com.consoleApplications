package com.zsgs.librarymanagement.model;

import java.time.LocalDate;
import java.util.Date;

public class Book {

	private String name;
	private int id;
	private static int idCounter;
	private String author;

	private String publication;
	private String edition;
	private String journer;
	private int availableCount;
	private int volume;
	Date issueDate;
	Date dueDate;

	public Book(String name, String author, int count) {
		this.name = name;
		this.id = ++idCounter;
		this.author = author;
		availableCount = count;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date date) {
		this.issueDate = date;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getJourner() {
		return journer;
	}

	public void setJourner(String journer) {
		this.journer = journer;
	}

	public int getAvailableCount() {
		return availableCount;
	}

	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
}
