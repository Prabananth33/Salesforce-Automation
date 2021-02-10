package salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateAccounts  {

	WebDriver driver = null;


	@BeforeTest
	public void login() {

		WebDriverManager.chromedriver().setup(); 
		ChromeOptions opt = new ChromeOptions(); 	  
		opt.addArguments("--disable-notifications"); driver = new
				ChromeDriver(); driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}

	@Test	
	public void createtest() {	
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Bootcamp@123");

		driver.findElement(By.xpath("//input[@value='Log In']")).click();

		//2. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		//3. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']/..")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		//4. Click on Accounts tab 
		driver.findElement(By.xpath("//a[@title='Accounts']/..")).click();

		//5. Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();

		//6. Enter 'your name' as account name
		WebElement user = driver.findElement(By.xpath("//input[@class=' input']"));
		WebDriverWait wait1 = new WebDriverWait(driver, 5);
		wait1.until(ExpectedConditions.visibilityOf(user));
		user.sendKeys("TestNGtest");

		driver.findElement(By.xpath("(//a[@class='select'])[3]")).click();

		//7. Select Ownership as Public
		driver.findElement(By.xpath("//a[@title='Public']")).click();

		//8. Click save
		driver.findElement(By.xpath("//button[@title='Save']")).click();

		//verify Account name 
		WebElement accname = driver.findElement(By.xpath("//div[@class='toastContent slds-notify__content']"));

		String acname = accname.getText();

		if(acname.contains("TestNGtest"))
		{
			System.out.println("Account Name is successfully verified");
		}
		else {
			System.out.println("Re-check the Account Name");
		}
	}

	@AfterTest
	public void logout() {
		driver.quit();
	}
}



