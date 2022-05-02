package com.orangehrm.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orangehrm.qa.base.BasePage;

public class Login extends BasePage {

	
	//Initializing the Page Factory by using the BasePage 
	public Login(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="divLogo")
	public WebElement img_Orangehrmlogo;
	
	@FindBy(id="txtUsername")
	public WebElement txtField_Username;
	
	@FindBy(id="txtPassword")
	public WebElement txtField_Password;
	
	@FindBy(id="btnLogin")
	public WebElement btn_Login;
	
	@FindBy(id="spanMessage")
	public WebElement txt_LoginErrMessage;
	
	//Page Actions
	
	public void setUserName(String uname) {
		txtField_Username.sendKeys(uname);
				
	}
	
	public void setPassword(String pwd) {
		txtField_Password.sendKeys(pwd);
				
	}
		
	public String ValidateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateOrangeHRMImage()
	{
		return  img_Orangehrmlogo.isDisplayed();
		
	}
	public String validateLoginErrorMessage(){
		
       return txt_LoginErrMessage.getText();
	}

	//Change void to HomePage below
	public void validateLogin(String uname,String pwd)
	{
		txtField_Username.sendKeys(uname);
		txtField_Password.sendKeys(pwd);
		btn_Login.click();
		
	//	return new HomePage(driver);
	}
}
