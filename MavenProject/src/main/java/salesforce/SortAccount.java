package salesforce;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortAccount {
	WebDriver driver = null;

	@BeforeTest	
	public void driver() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@Test
	public void sortaccount() {

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Bootcamp@123");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();		

		//		  Click on the App Launcher Icon left to Setup
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		//        Click on Accounts
		driver.findElement(By.xpath("//div[contains(@class,'slds-form-element__control')]/following::input[@placeholder='Search apps and items...']")).sendKeys("Accounts");
		driver.findElement(By.xpath("//b[text()='Accounts']")).click();

		//		 Click sorting button
		driver.findElement(By.xpath("//th[@title='Account Name']//following::a[contains(@class,'toggle slds-th__action')]")).click();
		

		
	
		WebElement table = driver.findElement(By.xpath("//table[contains(@class,'slds-table forceRecordLayout')]"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int rsize = rows.size();
		
		
		for(int row=0;row<rsize;row++) {
			
			List<WebElement> colrow = driver.findElements(By.tagName("td"));
			
		}
		}

	@AfterTest
	public void close() {

		driver.quit();
	}

}
