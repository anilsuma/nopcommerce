package com.nopcommerce.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Readconfig {
	Properties pro;
	public Readconfig(){
		 File src = new File("./config.property//config.properties");
		 
		 try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}
		 
		 
	 }
	public String getURL() {
	String url=	 pro.getProperty("baseURL");
	return url;
	
	 }
	public String getUserEmail() {
		String UserEmail=	 pro.getProperty("useremail");
		return UserEmail;
		
		 }
	public String getpassword() {
		String password=pro.getProperty("password");
		return password;
		
		 }
	public String getChromepath() {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
		
		 }
	public String getIepath() {
		String iepath=pro.getProperty("iepath");
		return iepath;
		
		 }
	public String getfirefoxpath() {
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
		
		 }	

}
