package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.BaseClass;
import com.orangehrm.qa.page.HomePage;
import com.orangehrm.qa.page.Login;

public class LoginTest extends BaseClass{
	Login lg;
	HomePage hp;
	
	
	@BeforeMethod
	public void SetUp() {
	lg= new Login(driver);
	}
		
	@Test(priority =2)
		public void LoginPageTitleTest() {
		String act_title =lg.ValidateLoginPageTitle();
		Assert.assertEquals(act_title,"OrangeHRM");
	}
	
	@Test(priority =2)
	public void LoginPageLogoTest() {
		boolean flag =lg.validateOrangeHRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority =3)
	public void LoginPageTest() {
	// hp=
	lg.validateLogin("Admin", "admin123");
		
	}
	
	

}
