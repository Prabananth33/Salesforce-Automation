package com.pages.salesforce;

import org.openqa.selenium.By;

public class SortAccount extends HomePage {

	public void sortAccount() {

		HomePage hp = new HomePage();
		hp.appLauncher();

		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Accounts");
		driver.findElement(By.xpath("//mark[text()='Accounts']")).click();

		driver.findElement(By.xpath("//th[@title='Account Name']//following::a[contains(@class,'toggle slds-th__action')]")).click();

	}

}
