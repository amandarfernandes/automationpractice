package com.automationpractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/h1") private WebElement heading;
	@FindBy(id="email") private WebElement loginEmail;
	@FindBy(id="passwd") private WebElement loginPasswd;
	@FindBy(id="SubmitLogin") private WebElement signin; 
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public boolean isPageOpened() {
		return heading.getText().equals("AUTHENTICATION");
		
	}
	
	public void setEmail(String email) {
		loginEmail.clear();
		loginEmail.sendKeys(email);
	}
	
	public void setPassword(String passwd) {
		loginPasswd.clear();
		loginPasswd.sendKeys(passwd);
	}
	
	public  void clickOnSiginIn() {
		signin.click();
	}
}
