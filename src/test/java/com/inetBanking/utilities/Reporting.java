package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlReoporter;
	public ExtentReports extent;	
	public ExtentTest logger;	
	
	
	public void onStart(ITestContext testContext)
	{
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report"+timestamp+".html";
		
		htmlReoporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output\\"+repName);	//Specify location of report
		htmlReoporter.loadConfig(System.getProperty("user.dir") + "/extent-config.xml");
		
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReoporter);
		extent.setSystemInfo("Host Name", "local host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "JTR4");
		
		
		htmlReoporter.config().setDocumentTitle("InetBanking Test Project");		//Title of Report
		htmlReoporter.config().setReportName("Functional Test Automatio Report");	//Name of Report
		htmlReoporter.config().setTestViewChartLocation(ChartLocation.TOP);			//Location of Chart
		htmlReoporter.config().setTheme(Theme.DARK);
	
	}
	
	
	public void onTestSuccess(ITestResult tr) 
	{
		logger = extent.createTest(tr.getName());	//Create a New entry in report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	
	public void onTestFailure(ITestResult tr) 
	{
		logger = extent.createTest(tr.getName());	//Create a New entry in report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		//String screenshotPath = System.getProperty("user.dir") + "/Screenshots"+tr.getName()+".png";
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\"+tr.getName()+".png";
		
		File f = new File(screenshotPath);
		
		if(f.exists())
		{
			try {
				logger.fail("Screenshot is below :" + logger.addScreenCaptureFromPath(screenshotPath));
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void onTestSkipped(ITestResult tr) 
	{
		logger = extent.createTest(tr.getName());	//Create a New entry in report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	

}
