package salesforce;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteOppurtunity {
	
	WebDriver driver = null;
	
@BeforeTest
public void driver() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions opt = new ChromeOptions();
	opt.addArguments("--disable-notifications");
	driver = new ChromeDriver(opt);
}

@Test
public void deloppur() throws IOException {
	driver.get("https://login.salesforce.com/");
	driver.manage().window().maximize();

	driver.findElement(By.xpath("//input[@type='email']")).sendKeys("makaia@testleaf.com");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Bootcamp@123");
	
	driver.findElement(By.xpath("//input[@value='Log In']")).click();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();			
    
    driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']")).sendKeys("Opportunities");
    
    driver.findElement(By.xpath("//b[text()='Opportunities']")).click();
    
    driver.findElement(By.xpath("//div[contains(@class,'slds-form-element__control')]//following::input[@name='Opportunity-search-input']")).sendKeys("Bootcamp");
    
    driver.findElement(By.xpath("//a[@title='Bootcamp']")).click();
    
    driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_icon-border-filled')]")).click();
    
    driver.findElement(By.xpath("//a[@name='Delete']")).click();
    
    WebElement delmsg = driver.findElement(By.xpath("//div[@class='detail slds-text-align--center']"));
    
    File sst = delmsg.getScreenshotAs(OutputType.FILE);
    
    FileUtils.copyFile(sst, new File("./target/screenshots/delmsg.png"));
    
    driver.quit();
    
}

}
