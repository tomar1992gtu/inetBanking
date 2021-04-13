package com.inetBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginTest")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		logger.info("loginTest Started....");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginApplication(user,pwd);
		
		Thread.sleep(3000);
			
		logger.info("LoginPage Successfully.");
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();		//close invalid login alert
			driver.switchTo().defaultContent();
			logger.warn("Login Failed");
			Assert.assertTrue(false);
			//logger.warn("Login Failed");
		}
		
		else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.logoutApplication();
			driver.switchTo().alert().accept();		//close logout alert
			driver.switchTo().defaultContent();		
			
			
		}
		
	}
	
	
	@DataProvider(name="LoginTest")
	String [][] getData() throws IOException
	{
		String filepath = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/TestData.xlsx";
		int rownum = XLUtils.getRowCount(filepath, "Login_Data");
		int colcount = XLUtils.getCellCount(filepath, "Login_Data", 1);
		
		String logindata[][] = new String [rownum][colcount];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colcount; j++) 
			{
				logindata[i-1][j]=XLUtils.getCellData(filepath, "Login_Data", i, j);
			}
		}
		return logindata;
	}
}
