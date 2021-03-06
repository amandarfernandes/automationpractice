package com.automationpractice.resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
	public static WebDriver driver;
	public Properties prop = new Properties();
	
	public void getScreenshot(String failedTest) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/admin/eclipse-workspace/automatoinpractice"+failedTest+".png"));
	}

	@BeforeClass
	public WebDriver initializeDriver() throws IOException {
		FileInputStream fis = new FileInputStream("/Users/admin/eclipse-workspace/automatoinpractice/src/test/java/com/automatoinpractice/resources/data.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		String dp = prop.getProperty("driverPath");
		
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",dp+"chromedriver");
			driver= new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver",dp+"geckodriver");
			driver= new FirefoxDriver();
					
		}
		
		driver.manage().window().maximize();
		
		//set implicit wait time to 10 secs
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		  String url = prop.getProperty("url");
		  driver.get(url);
		  return driver;
	}
	
	@AfterClass
	  public void afterTest() {
		  driver.close();
		  driver=null;
	  }
}
