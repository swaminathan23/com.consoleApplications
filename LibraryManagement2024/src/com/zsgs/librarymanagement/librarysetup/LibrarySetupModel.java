package com.zsgs.librarymanagement.librarysetup;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Library;

class LibrarySetupModel {
	private LibrarySetupView librarySetupView;
	private Library library;

	LibrarySetupModel(LibrarySetupView librarySetupView) {
		this.librarySetupView = librarySetupView;
		library = LibraryDatabase.getInstance().getLibrary();
	}

	public void startSetup() {
		if (library == null || library.getLibraryId() == 0) {
			librarySetupView.initiateSetup();
		} else {
			librarySetupView.onSetupComplete(library);
		}
	}

	public void createLibrary(Library library) {
		if (library.getLibraryName().length() < 3 || library.getLibraryName().length() > 50) {
			librarySetupView.showAlert("Enter valid name");
			return;
		}
		this.library = LibraryDatabase.getInstance().insertLibrary(library);
		librarySetupView.onSetupComplete(library);
	}
}
