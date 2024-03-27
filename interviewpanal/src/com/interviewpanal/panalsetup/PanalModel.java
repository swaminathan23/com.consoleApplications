package com.interviewpanal.panalsetup;

import com.interviewpanal.model.PanalSetup;

public class PanalModel {
	private PanalView panalView;

	PanalModel(PanalView panalView) {
		this.panalView = panalView;
	}

	void init(String panalName, String panalDate) {
		PanalSetup.getInstance().setPanalName(panalName);
		PanalSetup.getInstance().setPanalDate(panalDate);
		panalView.enterstring("panal setup complete");
		panalView.panalSetupComplete();
	}
}
