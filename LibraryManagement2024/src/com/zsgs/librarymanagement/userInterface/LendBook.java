package com.zsgs.librarymanagement.userInterface;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.jar.Attributes.Name;

import com.zsgs.librarymanagement.Validation;
import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.User;

public class LendBook {
	List<Book> listOfBook = LibraryDatabase.getInstance().giveBook();
	List<User> listOfUser = LibraryDatabase.getInstance().userList();
	private Uservalidate uservalidate;

	LendBook(Uservalidate uservalidate) {
		this.uservalidate = uservalidate;
	}

	User checkUser(String name, String emailid) {
		for (User u : listOfUser) {
			if (name.equals(u.getName())) {
				if (emailid.equals(u.getEmailId())) {
					return u;
				}
			}
		}
		return null;
	}
	
	 public void userBook(User u) {
		 List<Book> listOfBook=u.getListOfLended();
		 for(Book b:listOfBook) {
			 uservalidate.enterString("book name:"+b.getName()+"authur name"+b.getAuthor()
			 +"issued date:"+b.getIssueDate()+"dueDate:"+b.getDueDate());
		 }
	 }
	public void lending(User u, String bookName) {
		int a=0;
		for (Book b : listOfBook) {
			if (b.getName().equals(bookName)) {
				a=1;
				 LocalDate localDate = LocalDate.now();
			        LocalDateTime localDateTime = localDate.atStartOfDay();
			        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
			        Date Issuedate = Date.from(zonedDateTime.toInstant());
			        LocalDate localDate1 = LocalDate.now().plusDays(7);
			        LocalDateTime localDateTime1 = localDate1.atStartOfDay();
			        ZonedDateTime zonedDateTime1 = localDateTime1.atZone(ZoneId.systemDefault());
			          Date Issuedate1 = Date.from(zonedDateTime1.toInstant());
				b.setIssueDate(Issuedate);
				b.setDueDate(Issuedate1 );
				u.getListOfLended().add(b);
				if (b.getAvailableCount() > 0) {
					b.setAvailableCount(b.getAvailableCount() - 1);
					uservalidate.enterString("lending successfull");
					break;
				} else {
					uservalidate.enterString("not available ");
					break;}
				}
			} if(a==0) {
				uservalidate.enterString("no book available");
		}
			}
	

	public void getBookName(String name) {
//	ArrayList<Book> a=new ArrayList<Book>();
		for (Book b : listOfBook) {
			if (b.getName().contains(name)) {
				uservalidate.enterString("book name" + b.getName() + "authur name" + b.getAuthor());
			}
		}
	}

	public boolean returning1(User u, String bookName) {
		for (Book b : listOfBook) {
			if (b.getName().endsWith(bookName)) {
				b.setAvailableCount(b.getAvailableCount() + 1);
				return true;
			} else
				return false;
		}
		return false;
	}

	public void returning(User u, String bookName) {
		boolean a = returning1(u, bookName);
		if (a) {
			int index = 0;

			for (Book b : listOfBook) {

				if (b.getName().equals(bookName)) {
					break;
				}
				index += 1;
			}
			u.getListOfLended().remove(index);
			uservalidate.enterString("successfully removed");
		} else {
			uservalidate.enterString("so such book available");
		}

	}
}
