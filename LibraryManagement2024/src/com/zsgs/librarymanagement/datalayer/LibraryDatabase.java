package com.zsgs.librarymanagement.datalayer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.Library;
import com.zsgs.librarymanagement.model.User;

public class LibraryDatabase {

	private static LibraryDatabase libraryDatabase;

	private Library library;
	private List<Book> bookList = new ArrayList();
	private List<User> userList = new ArrayList();
	private static final String FILE_PATH="C:\\Users\\nandhu\\Desktop\\java zoho\\task 2\\LibraryManagement2024\\src\\com\\zsgs\\librarymanagement\\NewTextDocument1.json";
	
	private static Gson gson=new Gson();
	public static LibraryDatabase getInstance() {

		if (libraryDatabase == null) {
			libraryDatabase = new LibraryDatabase();
		}
		return libraryDatabase;
	}
	public void saveData() {
		try(
			FileWriter f=new FileWriter(FILE_PATH)
		){
			gson.toJson(this,f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void resetData() {
		File f = new File("C:\\Users\\nandhu\\Desktop\\java zoho\\task 2\\LibraryManagement2024\\src\\com\\zsgs\\librarymanagement");
		File files[] = f.listFiles();
		for (File file : files) {
		if (file.getName().endsWith(".json")) {
			file.delete();
		}
		}
	}
	public boolean checkData() {
		File f = new File("C:\\Users\\nandhu\\Desktop\\java zoho\\task 2\\LibraryManagement2024\\src\\com\\zsgs\\librarymanagement");
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
		try(FileReader f1=new FileReader(FILE_PATH)){
			LibraryDatabase d=gson.fromJson(f1, LibraryDatabase.class);
			bookList=d.bookList;
			userList=d.userList;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private LibraryDatabase() {

	}

	public Library getLibrary() {
		return library;// SQL query and it's result here.
	}

	public Library insertLibrary(Library library2) {
		this.library = library2;
		this.library.setLibraryId(1);
		return library;
	}

	public Book getBook(int bookId) {
		for (Book book : bookList) {
			if (book.getId() == bookId) {
				return book;
			}
		}
		// select query with where condition.
		return null;
	}

	public List<Book> giveBook() {
		return bookList;
	}

	public List<User> userList() {
		return userList;
	}

	public List<Book> sendBook(String bookname) {
		List<Book> listOfBook = new ArrayList<Book>();
		for (Book b : bookList) {
			if (b.getName().contains(bookname)) {
				listOfBook.add(b);
			}
		}
		return listOfBook;

	}

	public List<Book> searchBooks(String bookName) {
		List<Book> searchResult = new ArrayList();
		for (Book book : bookList) {
			if (book.getName().contains(bookName)) {
				searchResult.add(book);
			}
		}
		return searchResult;
	}

	public boolean insertBook(Book book) {
		boolean hasBook = false;
		for (Book addedBook : bookList) {
			if (addedBook.getName().equals(book.getName()) && addedBook.getAuthor().equals(book.getAuthor())) {
				hasBook = true;
				System.out.println("book there");
				break;
			}
		}
		if (hasBook) {
			return false;
		} else {
			bookList.add(book);
			return true;
		}

	}

	public boolean insertUser(User user) {
		boolean hasUser = false;
		for (User addedUser : userList) {
			if (addedUser.getEmailId().equals(user.getEmailId())) {
				hasUser = true;
				break;
			}
		}
		if (hasUser) {
			return false;
		} else {
			userList.add(user);
			return true;
		}
	}
}
