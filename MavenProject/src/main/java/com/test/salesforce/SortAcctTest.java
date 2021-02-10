package com.test.salesforce;

import org.testng.annotations.Test;

import com.pages.salesforce.SortAccount;

public class SortAcctTest extends SortAccount {

	@Test
	public void sorttest() {

		new SortAccount().
		sortAccount();
		quitBrowser();

	}

}
