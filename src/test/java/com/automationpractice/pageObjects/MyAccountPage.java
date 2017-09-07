package com.automationpractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	private WebDriver driver;
	
	@FindBy(css="#center_column > h1") private WebElement heading;
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(this.driver, this);
	}
	
	public boolean isPageOpened() {
		return heading.getText().equals("MY ACCOUNT");
	}
}
