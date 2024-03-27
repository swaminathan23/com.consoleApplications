package com.zsgs.librarymanagement.manageusers;

import java.util.List;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.Library;
import com.zsgs.librarymanagement.model.User;

class ManageUsersModel {

	private ManageUsersView manageUsersView;

	ManageUsersModel(ManageUsersView manageUsersView) {
		this.manageUsersView = manageUsersView;
	}

	public void addNewUser(User user) {
		if (LibraryDatabase.getInstance().insertUser(user)) {
			manageUsersView.onUserAdded(user);
		} else {
			manageUsersView.onUserExist(user);
		}
	}

	void mainRemove(String name, String email) {
		List<User> list = LibraryDatabase.getInstance().userList();
		list.remove(removeUser(name, email));
	}

	User removeUser(String name, String email) {
		User user = null;
		List<User> list = LibraryDatabase.getInstance().userList();
		if (list == null) {
			manageUsersView.enterString("no user in the list to delete");
		}
		for (User u : list) {
			if (email.equals(u.getEmailId())) {
				user = u;
			}
		}
		if (user == null) {
			manageUsersView.enterString("no such book available");
			return null;
		} else {
			manageUsersView.enterString("book removed successfully");
			return user;
		}

	}

	void getUserView() {
		List<User> userList = LibraryDatabase.getInstance().userList();
		for (User u : userList)
			manageUsersView.enterString("user name" + u.getName() + "user email" + u.getEmailId());
	}
}
