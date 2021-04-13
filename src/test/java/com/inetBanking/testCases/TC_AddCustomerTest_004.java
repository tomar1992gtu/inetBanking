package com.inetBanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_AddCustomerTest_004 extends BaseClass{
	
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
		
		String filepath = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/TestData.xlsx";
		
		addcust.customerName(XLUtils.getCellData(filepath, "Add_New_Customer", 1, 1));
		addcust.customerGender(XLUtils.getCellData(filepath, "Add_New_Customer", 2, 2));		
		addcust.customerDOB(XLUtils.getCellData(filepath, "Add_New_Customer", 3, 3), XLUtils.getCellData(filepath, "Add_New_Customer", 4, 4), XLUtils.getCellData(filepath, "Add_New_Customer", 5, 5));
		addcust.customerAddress(XLUtils.getCellData(filepath, "Add_New_Customer", 6, 6));
		addcust.customerCity(XLUtils.getCellData(filepath, "Add_New_Customer", 7, 7));
		addcust.customerState(XLUtils.getCellData(filepath, "Add_New_Customer", 8, 8));
		addcust.customerPinno(XLUtils.getCellData(filepath, "Add_New_Customer", 9, 9));
		addcust.customerTelephone(XLUtils.getCellData(filepath, "Add_New_Customer", 10, 10));
		addcust.customerEmail(XLUtils.getCellData(filepath, "Add_New_Customer", 11, 11));
		addcust.customerPassword(XLUtils.getCellData(filepath, "Add_New_Customer", 12, 12));
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
