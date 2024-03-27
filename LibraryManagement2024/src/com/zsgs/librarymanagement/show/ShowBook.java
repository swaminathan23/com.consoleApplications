package com.zsgs.librarymanagement.show;

import java.util.ArrayList;
import java.util.List;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Book;

public class ShowBook {
	private ShowView showView;

	ShowBook(ShowView showView) {
		this.showView = showView;
	}

	void getBook() {
		List<Book> listOfBook = LibraryDatabase.getInstance().giveBook();
		for (Book b : listOfBook) {
			showView.printBook(b);
		}
	}

	void getBook(String bookname) {
		List<Book> list = LibraryDatabase.getInstance().sendBook(bookname);
		for (Book b : list) {
			showView.enterString("book name" + b.getName() + "authur name" + b.getAuthor());
		}
	}

	void mainremove(String name, String auther) {
		List<Book> listOfBook = LibraryDatabase.getInstance().giveBook();
		listOfBook.remove(removeBook(name, auther));
	}

	Book removeBook(String name, String auther) {
		Book book = null;
		List<Book> listOfBook = LibraryDatabase.getInstance().giveBook();
		if (listOfBook == null) {
			showView.enterString("no book in the list to delete");
		}
		for (Book b : listOfBook) {
			if (name.equals(b.getName())) {
				book = b;
			}
		}
		if (book == null) {
			showView.enterString("no such book available");
			return null;
		} else {
			showView.enterString("book removed successfully");
			return book;
		}
	}
}
