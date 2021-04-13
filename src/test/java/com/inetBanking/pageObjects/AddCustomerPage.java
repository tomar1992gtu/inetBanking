package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver local_driver;
	
	public AddCustomerPage(WebDriver remote_driver) {
		
		local_driver = remote_driver;
		PageFactory.initElements(remote_driver, this);		
	}
	
	
	
	@FindBy(linkText="New Customer")
	WebElement linkAddNewCustomer;

	@FindBy(name ="name")
	WebElement txtName;
	
	@FindBy(xpath ="//td[text()='Gender']//following-sibling::td/input[@value='m']")
	WebElement rdGender;
	
	@FindBy(name="dob")
	WebElement txtdob;
	
	@FindBy(name="addr")
	WebElement txtaddress;
	
	@FindBy(name="city")
	WebElement txtcity;
	
	@FindBy(name="state")
	WebElement txtstate;
	
	@FindBy(name="pinno")
	WebElement txtpinno;
	
	@FindBy(name="telephoneno")
	WebElement txttelephoneno;
	
	@FindBy(name="emailid")
	WebElement txtemailid;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(how=How.NAME, using="sub")
	WebElement btnSubmit;
		
	
	public void clickAddNewCustomer()
	{
		linkAddNewCustomer.click();
	}
	
	public void customerName(String cusname)
	{
		txtName.sendKeys(cusname);
	}
	
	public void customerGender(String cusgender)
	{
		rdGender.click();
	}
	
	public void customerDOB(String mm, String dd, String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void customerAddress(String cusaddress)
	{
		txtaddress.sendKeys(cusaddress);
	}
	
	public void customerCity(String cuscity)
	{
		txtcity.sendKeys(cuscity);
	}
	
	public void customerState(String cusstate)
	{
		txtstate.sendKeys(cusstate);
	}	
	
	//public void customerPinno(int cuspinno)
	public void customerPinno(String cuspinno)
	{
		txtpinno.sendKeys(String.valueOf(cuspinno));
	}	
	
	public void customerTelephone(String custelephone)
	{
		txttelephoneno.sendKeys(custelephone);
	}
	
	public void customerEmail(String cusemail)
	{
		txtemailid.sendKeys(cusemail);
	}
	
	public void customerPassword(String cuspassword)
	{
		txtpassword.sendKeys(cuspassword);
	}
	
	public void customerSubmit()
	{
		btnSubmit.click();
	}
	
	
	
	

}
