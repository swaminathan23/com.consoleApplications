package com.zsgs.librarymanagement.show;

import java.util.Scanner;

import com.zsgs.librarymanagement.model.Book;

public class ShowView {
	private ShowBook showBook;
	Scanner scanner = new Scanner(System.in);

	public ShowView() {
		showBook = new ShowBook(this);
	}

	public void printBook(Book book) {
		System.out.println(
				"bookname" + book.getName() + "authurname" + book.getAuthor() + "count" + book.getAvailableCount());
	}

	public void showBook() {
		showBook.getBook();
	}

	public void enterString(String a) {
		System.out.println(a);
	}

	public void removeBook() {
		System.out.println("\nEnter book details: ");
		System.out.println("\nEnter book name:");
		String name = scanner.nextLine();
		System.out.println("\nEnter book author:");
		String authur = scanner.nextLine();
		showBook.mainremove(name, authur);
	}

	public void getBook() {
		System.out.println("enter book name");
		String book = scanner.next();
		showBook.getBook(book);
	}
}
