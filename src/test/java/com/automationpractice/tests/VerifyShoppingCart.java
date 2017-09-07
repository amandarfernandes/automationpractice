package com.automationpractice.tests;



import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.automatoinpractice.resources.Base;

public class VerifyShoppingCart{
	WebDriver driver=null;
	String url = "http://www.automationpractice.com";
	
	@BeforeClass
	public void initializeDriver() {
		System.setProperty("webdriver.chrome.driver","/Users/admin/selenium/chromedriver");
		driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		//set implicit wait time to 10 secs
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	

	@Test
  public void canBuy() {
	  Actions a = new Actions(driver);
	  WebElement featuredItem = driver.findElement(By.cssSelector("ul#homefeatured > li:nth-of-type(1)"));
	  a.moveToElement(featuredItem).build().perform();
	  driver.findElement(By.linkText("Add to cart")).click();
	  WebDriverWait wait = new WebDriverWait(driver, 15);
	  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Proceed to checkout")));
	  //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className("continue")));
	  element.click();
	  }
	 
}