package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver local_driver;
	
	public LoginPage(WebDriver remote_driver) {
		
		local_driver = remote_driver;
		PageFactory.initElements(remote_driver, this);		
	}
	
	
	@FindBy(name="uid")
	WebElement txtUserName;
	
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(linkText ="Log out")
	WebElement linkLogout;
	
	
	public void loginApplication(String uname, String pwd) 
	{
		txtUserName.sendKeys(uname);
		txtPassword.sendKeys(pwd);
		btnLogin.click();
	}
	
	
	public void logoutApplication() 
	{
		linkLogout.click();
	}
	
	
	

}
