package salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class DeleteAccount {
	WebDriver driver = null;
	
@BeforeTest
public void driver() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions opt = new ChromeOptions();
	opt.addArguments("--disable-notifications");
	driver = new ChromeDriver(opt);
}

@Test
public void deletecase() {
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Bootcamp@123");
		
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
        driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();			
        
        driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']")).sendKeys("Accounts");
        driver.findElement(By.xpath("//b[text()='Accounts']")).click();
                
        driver.findElement(By.xpath("F")).sendKeys("PrabananthR");
        
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='slds-spinner_container slds-grid']")));
        
        WebElement delete = driver.findElement(By.xpath("//div[contains(@class,'forceVirtualActionMarker ')]//a[contains(@class,'rowActionsPlaceHolder ')]"));
        JavascriptExecutor js = (JavascriptExecutor)driver; 
        js.executeScript("arguments[0].click();", delete);


//        delete.click();
        
        driver.findElement(By.xpath("//a[@title='Delete']")).click();
        
        driver.findElement(By.xpath("//button[@title='Delete']")).click();
        
		WebElement accname = driver.findElement(By.xpath("//div[@class='toastContent slds-notify__content']"));
		
		String acname = accname.getText();
		
		if(acname.contains("PrabananthR"))
		{
		System.out.println(acname);
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
