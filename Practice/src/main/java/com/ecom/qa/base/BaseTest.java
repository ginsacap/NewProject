package com.ecom.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ecom.qa.util.TestUtil;

public class BaseTest {
	public static WebDriver driver;
	public static Properties pr;
	
	public BaseTest() throws IOException
	{
		try 
		{
			pr = new Properties();
			FileInputStream fr = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ecom\\qa\\config\\config.properties");
			pr.load(fr);
		} 
		
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	public static void initialize() throws InterruptedException
	{
		String browserName = pr.getProperty("browser");
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32_74\\chromedriver.exe");
			driver = (WebDriver) new ChromeDriver();
			
		}
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\geckodriver-v0.24.0-win32\\geckodriver.exe");
			driver = (WebDriver) new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoad_wait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);		
		driver.get(pr.getProperty("url"));
	}



}
