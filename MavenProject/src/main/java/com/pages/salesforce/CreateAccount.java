package com.pages.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount extends HomePage{

	public void createAccount() {

		HomePage hp = new HomePage();

		hp.appLauncher();


		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		//4. Click on Accounts tab 
		driver.findElement(By.xpath("//a[@title='Accounts']/..")).click();

		//5. Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();

		//6. Enter 'your name' as account name
		WebElement user = driver.findElement(By.xpath("//label[contains(@class,'label inputLabel')]//following::input[@class=' input']"));
		WebDriverWait wait1 = new WebDriverWait(driver, 5);
		wait1.until(ExpectedConditions.visibilityOf(user));
		user.sendKeys("TestNew");

		//7. Select Ownership as Public
		driver.findElement(By.xpath("//span[text()='Ownership']//following::a[@class='select']")).click();
		driver.findElement(By.xpath("//a[@title='Public']")).click();

		//8. Click save
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		

//		return this;

	}

	public static void verifyAcName() {
		//verify Account name 
		WebElement accname = driver.findElement(By.xpath("//div[@class='toastContent slds-notify__content']"));

		String acname = accname.getText();

		if(acname.contains("TestNew"))
		{
			System.out.println(acname+ " and verified");
		}
		else {
			System.out.println("Re-check the Account Name as" +acname);
		}
	}


}

