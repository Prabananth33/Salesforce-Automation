package com.base.salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;


public class Baseclass {

	public static WebDriver driver;	

@BeforeTest
	@Parameters("browser")
	public static void driverInit(String browser) {	

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); 
			ChromeOptions opt = new ChromeOptions(); 	  
			opt.addArguments("--disable-notifications"); 
			driver = new ChromeDriver(opt); 

		} else if (browser.equalsIgnoreCase("FF")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions optf = new FirefoxOptions();
			optf.addArguments("--disable-notifications"); 
			driver = new FirefoxDriver(optf);
		
		}
	}
	public void launchBrowser() {

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterTest
	public void quitBrowser() {		
		driver.quit();
	}

}
