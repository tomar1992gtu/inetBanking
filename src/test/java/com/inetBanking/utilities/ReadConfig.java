package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	
	public ReadConfig()
	{
		File storepropfile = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(storepropfile);
			prop = new Properties();
			prop.load(fis);
	
			
		} catch (Exception e) {
			
			System.out.println("Exception s"+ e.getMessage());
			
		}
		
	}
	
	
	public String getApplicationURL() 
	{
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getUserName() 
	{
		String username = prop.getProperty("username");
		return username;
	}
	
	public String getPassword() 
	{
		String password = prop.getProperty("password");
		return password;
	}
	
	public String getChromePath() 
	{
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxPath() 
	{
		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getIEPath() 
	{
		String iepath = prop.getProperty("iepath");
		return iepath;
	}
		
		
}
	
	
	

