package com.test.salesforce2;

import org.testng.annotations.Test;

import com.pages.salesforce.DeleteAccount;

public class DeleteAcctTest extends DeleteAccount{

	@Test
	public void deleteTest() {

		new DeleteAccount().
		deleteAccount();
		validateDeletedAcct();
		quitBrowser();
	}

}
