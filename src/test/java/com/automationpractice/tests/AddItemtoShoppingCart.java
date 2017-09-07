package com.automationpractice.tests;

//import java.util.Iterator;
//import java.util.List;
import java.util.Set;
//import java.io.FileInputStream;
//import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.automatoinpractice.resources.Base;

public class AddItemtoShoppingCart{
	WebDriver driver=null;
	
	@BeforeClass
	public void initializeDriver() {
		System.setProperty("webdriver.chrome.driver","/Users/admin/selenium/chromedriver");
		driver= new ChromeDriver();
		String url = "http://www.automationpractice.com";
		driver.get(url);
		driver.manage().window().maximize();
		//set implicit wait time to 10 secs
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	

	@Test
  public void canBuy() {
	  Actions a = new Actions(driver);
	  WebElement featuredItem = driver.findElement(By.cssSelector("ul#homefeatured > li:nth-of-type(1)"));
	  //featuredItem.click();
	  a.moveToElement(featuredItem).build().perform();
	  WebElement addToCartLink = driver.findElement(By.linkText("Add to cart"));
	 // addToCartLink.click();
	  String currentWindowHandle = driver.getWindowHandle();

	  // do stuff on the pop window
	  // close the popup window
	  try {
		  String popupWindowHandle = getPopupWindowHandle(driver, addToCartLink);
		  driver.switchTo().window(popupWindowHandle);
		  // driver.switchTo().defaultContent();
		 // driver.switchTo().frame(driver.findElement(By.id("layer_cart")));
		  WebElement continueBtn = driver.findElement(By.cssSelector(".continue.btn.btn-default.button.exclusive-medium>span"));
		  myJSClick(continueBtn);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  driver.switchTo().window(currentWindowHandle); 
	  
	  //String str="Product successfully added to your shopping cart";
	  //driver.findElement(By.cssSelector("#layer_cart>div>div.layer_cart_product>h2"))
	  //new Actions(driver).click(driver.findElement(By.cssSelector("div#layer_cart"))).build().perform();
	  //driver.switchTo().activeElement();
	 // driver.findElement(By.cssSelector(".continue.btn.btn-default.button.exclusive-medium")).click();
	  //driver.findElement(By.cssSelector("div.layer_cart_cart>div.button-container>span.continue")).click();
	  //driver.findElement(By.xpath("//*[contains(text(),'Continue shopping')]")).click();
	  //driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span > span")).click();
	  //WebElement prodMsg =driver.findElement(By.cssSelector("div#layer_cart>div>div.layer_cart_product>h2"));
	  //System.out.println(prodMsg.getText());
	  //Assert.assertTrue(prodMsg.getText().contains(str));
	    

  }
	
	public void myJSClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}
	
	String getPopupWindowHandle(WebDriver driver, WebElement link) {

	    // get all the window handles before the popup window appears
	    Set<String> beforePopup = driver.getWindowHandles();

	    // click the link which creates the popup window
	    link.click();

	    // get all the window handles after the popup window appears
	    Set<String> afterPopup = driver.getWindowHandles();

	    // remove all the handles from before the popup window appears
	    afterPopup.removeAll(beforePopup);

	    // there should be only one window handle left
	    if(afterPopup.size() == 1) {
	        return (String)afterPopup.toArray()[0];
	    }
	    return null;
	}
  
}
