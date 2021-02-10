package com.test.salesforce;

import org.testng.annotations.Test;

import com.pages.salesforce.CreateAccount;

public class CreateAcctTest extends CreateAccount{

	@Test
	public void createtest() {

		new CreateAccount().		
		createAccount();
		verifyAcName();
		quitBrowser();

	}
}


