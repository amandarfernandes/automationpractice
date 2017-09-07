package com.automationpractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private  WebDriver driver;

	
	//Locators
	@FindBy(className="login") private WebElement loginLink;
	@FindBy(css="#search_query_top") private WebElement searchBox;
	
	@FindBy(linkText="WOMEN") private WebElement womenLink;
	@FindBy(css="ul#homefeatured > li:nth-of-type(1)") WebElement featuredItem;

	
	//constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
		//Initialize the page elements
		PageFactory.initElements(this.driver, this);
	
	}

	public void clickOnLoginLink() {
		loginLink.click();
	}
	
	public boolean isPageOpened() {
		return driver.getTitle().equals("My Store");
	}
	
	public void clickonWomenLink() {
		womenLink.click();
	}
	
}