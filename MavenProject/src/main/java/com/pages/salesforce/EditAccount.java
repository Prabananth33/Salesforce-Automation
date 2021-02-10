package com.pages.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditAccount extends HomePage {

	public void editAccount() {
		HomePage hp = new HomePage();
		hp.appLauncher();

		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Accounts");
		driver.findElement(By.xpath("//mark[text()='Accounts']")).click();

		//        Search for the Account Using the unique account name created by you
		driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("TestPOM");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='slds-spinner_container slds-grid']")));

		WebElement edit = driver.findElement(By.xpath("//div[contains(@class,'forceVirtualActionMarker ')]//a[contains(@class,'rowActionsPlaceHolder ')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", edit);

		WebElement ed = driver.findElement(By.xpath("//li[@data-aura-class='uiMenuItem']//a[@title='Edit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ed);

		//        Select Type as Technology Partner
		driver.findElement(By.xpath("//span[text()='Type']//following::a[@class='select']")).click();
		driver.findElement(By.xpath("//a[@title='Technology Partner']")).click();

		//        Select Industry as Healthcare
		driver.findElement(By.xpath("(//a[@class='select'])[4]")).click();
		driver.findElement(By.xpath("//a[@title='Healthcare']")).click();

		//        Enter Billing Address
		driver.findElement(By.xpath("//textarea[@placeholder='Billing Street']")).sendKeys("Billing Address line 1 \n Billing Address Line2");

		//        Enter Shipping Address
		driver.findElement(By.xpath("//textarea[@placeholder='Shipping Street']")).sendKeys("Shipping Address line 1 \n Shipping Address Line2");

		//        Select Customer Priority as Low
		driver.findElement(By.xpath("//span[text()='Customer Priority']//following::a[@class='select']")).click();
		driver.findElement(By.xpath("//a[@title='Low']")).click();

		//        Select SLA as Silver
		driver.findElement(By.xpath("//span[text()='SLA']//following::a[@class='select']")).click();
		driver.findElement(By.xpath("//a[@title='Silver']")).click();

		//        Select Active as NO
		driver.findElement(By.xpath("//span[text()='Active']//following::a[@class='select']")).click();
		driver.findElement(By.xpath("//a[@title='No']")).click();

		//        Enter Unique Number in Phone Field
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9998887776");

		//        Click on save and verify Phone number
		driver.findElement(By.xpath("//button[@title='Save']")).click();

	}

	public void verifyPhNum() {
		//      Phone number field verification
		WebElement phnum = driver.findElement(By.xpath("//td[@class='slds-cell-edit cellContainer']//following::span[@class='slds-truncate uiOutputPhone']"));

		String phone = phnum.getText();

		System.out.println(phone);

		if(phone.contains("(999) 888-7776")) {
			System.out.println("Phone Number is " +phone +" and its is Verified");

		}

		else {
			System.out.println("Re-check the number because " +phone+ " is there instead" );
		}
	}

}


