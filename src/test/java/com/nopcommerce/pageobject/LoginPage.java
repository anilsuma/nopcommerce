package com.nopcommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
public class LoginPage {
    WebDriver ldriver;
	public LoginPage( WebDriver rdriver){
		ldriver= rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath="//*[@class='button-1 login-button']")
	@CacheLookup
	WebElement btnlogin;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement lnklogout;
	
	public void Setusername(String Uname) {
		txtEmail.clear();
		txtEmail.sendKeys(Uname);
	}
	
	public void Setpassword(String pwd) {
		txtpassword.clear();
		txtpassword.sendKeys(pwd);
	}
	
	public void clicklogin() {
		btnlogin.click();
	}
	
	public void clicklogout() {
		lnklogout.click();
	}
	
}
