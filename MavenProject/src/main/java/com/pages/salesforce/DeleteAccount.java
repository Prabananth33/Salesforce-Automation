package com.pages.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteAccount extends HomePage{

	public void deleteAccount() {
		
		HomePage hp = new HomePage();
		hp.appLauncher();

		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Accounts");
		driver.findElement(By.xpath("//mark[text()='Accounts']")).click();

		driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("ParallelTest");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='slds-spinner_container slds-grid']")));

		WebElement delete = driver.findElement(By.xpath("//div[contains(@class,'forceVirtualActionMarker ')]//a[contains(@class,'rowActionsPlaceHolder ')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", delete);

		driver.findElement(By.xpath("//a[@title='Delete']")).click();

		driver.findElement(By.xpath("//button[@title='Delete']")).click();

	}

	public void validateDeletedAcct() {
		WebElement accname = driver.findElement(By.xpath("//div[@class='toastContent slds-notify__content']"));

		String acname = accname.getText();

		if(acname.contains("ParallelTest"))
		{
			System.out.println(acname + " and it is verified");
		}
		else {
			System.out.println("Re-check the Account Name because "+ acname);
		}
	}


}

