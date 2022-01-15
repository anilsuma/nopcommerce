package com.nopcommerce.testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerce.pageobject.LoginPage;

public class TC_LoginTest_001 extends  BaseClass{
	  
	
	

	
	@Test
	public void LoginTest() throws Exception {
		
		driver.get(baseURL);
		Thread.sleep(5000);
		LoginPage lp=new LoginPage(driver);
		lp.Setusername(useremail);
		logger.info("User is sent");
		lp.Setpassword(password);
		logger.info("password is sent");
		lp.clicklogin();
		logger.info("loginclicked");
		Thread.sleep(5000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration")) {
		
			lp.clicklogout();
			logger.info("Test passed");
			System.out.print(driver.getTitle());
			Assert.assertTrue(true);
			
		}
		else {
			
			capturescreenshot(driver, "LoginTest");
			browser(driver);
			logger.info("Test fail");
			Assert.assertTrue(false);
		}
		
	}

}
