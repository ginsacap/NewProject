package com.ecom.qa.tests;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom.qa.base.BaseTest;
import com.ecom.qa.pages.HomePage;
import com.ecom.qa.pages.LoginPage;
import com.sun.istack.internal.logging.Logger;

public class LoginPageTest extends BaseTest{
	LoginPage loginPage;
	HomePage homepage;
	//Logger log = Logger.getLogger(LoginPageTest.class);
	public LoginPageTest() throws IOException 
	{
		super();
		
	}

	@BeforeMethod()
	public void setup() throws IOException, InterruptedException
	{
		//log.info("Launching the browser");
		initialize();
		//log.info("Initialization is completed");
		loginPage = new LoginPage(); 
	}
	
	@Test(priority = 0)
	public void loginTest()
	{
		loginPage.login(pr.getProperty("username"), pr.getProperty("password"));		
		 
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "GCR Shop");

	}	
	
	@Test(priority = 2)
	public void logoLoginPageTest()
	{
		loginPage.logoLoginPage();
		System.out.println("Logo of the login page is displayed");
	}
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}

	
}
