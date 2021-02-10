package com.pages.salesforce;

import org.openqa.selenium.By;


import com.base.salesforce.Baseclass;


public class LoginPage extends Baseclass {


	public void openUrl() {
		LoginPage lp = new LoginPage();
		lp.launchBrowser();

	}

	public void enterUsername(String uName) {
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(uName);

	}
	public void enterPassword(String pWord) {
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pWord);

	}

	public HomePage clickLogin() {
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		return new HomePage();
	}
}
