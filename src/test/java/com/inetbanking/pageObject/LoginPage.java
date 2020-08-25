package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(id="username")
    WebElement txtUserName;
    
    @FindBy(id="password")
    WebElement txtPassword;
    
    @FindBy(name="login")
    @CacheLookup
    WebElement btnLogin;
    
 
    public WebElement setUserName() {
    	return txtUserName;
    	
    }
    public WebElement setPassword() {
    	return txtPassword ;
    }
    public WebElement clickSubmit() {
    	return btnLogin;
    }












}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
