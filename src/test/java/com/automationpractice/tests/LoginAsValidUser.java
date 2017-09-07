package com.automationpractice.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.automationpractice.pageObjects.HomePage;
import com.automationpractice.pageObjects.LoginPage;
import com.automationpractice.pageObjects.MyAccountPage;
import com.automationpractice.resources.Base;

//import java.io.IOException;


public class LoginAsValidUser extends Base{
	
  @Test(dataProvider = "dp")
  public void login(String username, String passwd) {
	  //create object of home page class
	  HomePage hp = new HomePage(driver);
	  hp.clickOnLoginLink();
	  
	  //create object of login page
	  LoginPage lp = new LoginPage(driver);
	  //check if login page is opened
	  AssertJUnit.assertTrue(lp.isPageOpened());
	  
	  //enter userid and password
	  lp.setEmail(username);
	  lp.setPassword(passwd);
	  lp.clickOnSiginIn();
	  
	  //create object of myAccount page
	  MyAccountPage mya = new MyAccountPage(driver);
	  AssertJUnit.assertTrue(mya.isPageOpened());
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "dcunhaa@yahoo.com", "amanda23" }
     };
  }
  
}
