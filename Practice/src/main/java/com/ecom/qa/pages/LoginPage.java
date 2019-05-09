package com.ecom.qa.pages;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.base.BaseTest;
import com.ecom.qa.base.BaseTest;;

public class LoginPage extends BaseTest{
	
	
	@FindBy(name="username")
	WebElement txtUsername;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(id="tdb1")
	WebElement btnSubmit;
	
	@FindBy(xpath="/html/body/table[1]/tbody/tr[1]/td/a/img")
	WebElement imgLoginPage;
	
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}

	public String validateLoginPageTitle()
	{
		String title = driver.getTitle();
		System.out.println(title);
		return driver.getTitle();
	}
	
	
	public HomePage login(String username, String password)
	{
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnSubmit.click();
		return new HomePage();
	}
	public boolean logoLoginPage()
	{
		System.out.println("Login page logo is displayed");
		return imgLoginPage.isDisplayed();
				
	}
	
}
