package salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditAccount {

	WebDriver driver = null;

	@BeforeTest	
	public void driver() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}	
	//		WebDriverManager.firefoxdriver().setup();
	//		FirefoxOptions opt=new FirefoxOptions();
	//		opt.addArguments("--disable-notifications");
	//        opt.addPreference("dom.webnotifications.enabled", false);
	//        WebDriver driver = new FirefoxDriver(opt);
	//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	@Test
	public void editcase() {
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Bootcamp@123");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();		

		//		  Click on the App Launcher Icon left to Setup
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		//        Click on Accounts
		driver.findElement(By.xpath("//div[contains(@class,'slds-form-element__control')]/following::input[@placeholder='Search apps and items...']")).sendKeys("Accounts");
		//		driver.findElement(By.id("input-65")).sendKeys("Accounts");
		driver.findElement(By.xpath("//b[text()='Accounts']")).click();

		//        Search for the Account Using the unique account name created by you
		driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("Credits12");

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

		//       Phone number field verification
		WebElement phnum = driver.findElement(By.xpath("//td[@class='slds-cell-edit cellContainer']//following::span[@class='slds-truncate uiOutputPhone']"));

		String phone = phnum.getText();

		System.out.println(phone);

		if(phone.contains("(999) 888-7776")) {
			System.out.println("Phone Number Verified");

		}

		else {
			System.out.println("Re-check the number");
		}
	}

	@AfterTest
	public void close() {

		driver.quit();
	}
}