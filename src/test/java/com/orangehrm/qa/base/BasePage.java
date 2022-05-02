package com.orangehrm.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends BaseClass {
	
	//protected WebDriver driver;

	public BasePage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

}
