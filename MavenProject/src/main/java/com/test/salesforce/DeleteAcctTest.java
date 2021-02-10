package com.test.salesforce;

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
