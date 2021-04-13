package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	 private SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void loginTest() throws IOException {
		
		
		logger.info("loginTest Started....");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginApplication(username,password);
		
		logger.info("LoginPage Successfully.");
		

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("TC Passed : Title matched.");
		}
		
		else 
		{
			//softAssert.assertTrue(false);		//Will Mark TC as Pass on Failure & will continue execution.
			logger.info("TC Failed : Title didn't match.");
			Assert.assertTrue(false);
			System.out.println("1");
		}
		
	}

}
