package com.test.salesforce;

import org.testng.annotations.Test;

import com.pages.salesforce.EditAccount;

public class EditAcctTest extends EditAccount {

	@Test
	public void editTest() {
		new EditAccount().
		editAccount();
		verifyPhNum();
		quitBrowser();

	}

}
