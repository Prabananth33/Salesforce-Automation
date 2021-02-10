package com.pages.salesforce;

import org.openqa.selenium.By;

public class HomePage extends LoginPage {

	public void appLauncher() {
		
		LoginPage lp = new LoginPage();
		
		lp.openUrl();
		lp.enterUsername("makaia@testleaf.com");
		lp.enterPassword("Bootcamp@123");
		lp.clickLogin();
		
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		//3. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']/..")).click();


	}

}
