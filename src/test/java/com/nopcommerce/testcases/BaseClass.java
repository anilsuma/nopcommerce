package com.nopcommerce.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.utils.Readconfig;




public class BaseClass  {
    
	 Readconfig  Readconfig=new  Readconfig();
	 
	public String baseURL = Readconfig.getURL() ;
	public String useremail= Readconfig.getUserEmail();
    public String password= Readconfig.getpassword();
    public String chromepath= Readconfig.getChromepath();
    public String Iepath= Readconfig.getIepath();
    public String Firefoxpath= Readconfig.getfirefoxpath();
	public static WebDriver driver;
	public static Logger logger;
	public static String browserName;
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
		logger =  Logger.getLogger("hi");
		PropertyConfigurator.configure("log4j.properties");
		
		
		if(br.toLowerCase().equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",chromepath );
		driver =new ChromeDriver();
		}
		else if(br.toLowerCase().equals("ie")) {
			System.setProperty("webdriver.ie.driver",Iepath );
			driver =new InternetExplorerDriver();
		}
		else if(br.toLowerCase().equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",Firefoxpath );
			driver =new FirefoxDriver();
		}
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	public void  capturescreenshot(WebDriver driver ,String tname) throws IOException {
		 Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		    String browserName = cap.getBrowserName().toLowerCase();
		    System.out.println(browserName);
		    TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
		    System.out.println("screenshot taken");   
		    if(browserName.equals("chrome")) {
		    	File target =new File (System.getProperty("user.dir")+"//screenshots//chrome//"+tname+".png");
			    FileUtils.copyFile(source, target);
		    }
		 
		    else if(browserName.equals("ie")) {
		    	File target =new File (System.getProperty("user.dir")+"//screenshots//ie//"+tname+".png");
			    FileUtils.copyFile(source, target);
		    }
		    else if(browserName.equals("firefox")) {
		    	File target =new File (System.getProperty("user.dir")+"//screenshots//firefox//"+tname+".png");
			    FileUtils.copyFile(source, target);
		    }
		 
		
	}
	public String browser(WebDriver driver) {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    browserName = cap.getBrowserName().toLowerCase();
	    return browserName;
	}

	
}
