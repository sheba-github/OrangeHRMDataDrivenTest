package com.orangehrm.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orangehrm.qa.base.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver d) {
		super(d);
	}

	@FindBy(id="welcome")
	public WebElement link_welcome;
	
	@FindBy(xpath ="//a[contains(text(),'Logout')]")
	public WebElement link_Logout;
	
	
	
	public String getWelcomeText() {		
		return link_welcome.getText();
	}
	public void doClickLogout() {
		
		link_welcome.click();
		link_Logout.click();		
	}
	
}
