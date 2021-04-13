package com.inetBanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		logger.info("loginTest Started....");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginApplication(username,password);
		
		logger.info("LoginPage Successfully.");
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		
		logger.info("Providing Customer Details...");
		
		addcust.customerName("JTR");
		addcust.customerGender("male");
		addcust.customerDOB("02", "19", "1992");
		addcust.customerAddress("PUNE");
		addcust.customerCity("PUNE");
		addcust.customerState("MH");
		addcust.customerPinno("477001");
		addcust.customerTelephone("8600989448");
		addcust.customerEmail(randomstring() +"@gmail.com");
		addcust.customerPassword("Tester");
		addcust.customerSubmit();	
		captureScreenshot(driver,"AddNewCustomer");
		Thread.sleep(3000);
		logger.info("Validation Starting.");
		
		
		boolean msg = driver.getPageSource().contains("Customer Registered Successfully!!");
		
		if(msg==true)
		{
			Assert.assertTrue(true);
			logger.info("Test Passed");
			
		}
		else {
			logger.info("Test Failed");
			captureScreenshot(driver,"AddNewCustomer");
			Assert.assertTrue(false);
		}
	}

}
