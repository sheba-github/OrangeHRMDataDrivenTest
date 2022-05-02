package datadriven;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.BaseClass;
import com.orangehrm.qa.page.HomePage;
import com.orangehrm.qa.page.Login;

import util.ExcelReader;

public class OrangeHRMDataDrivenTest extends BaseClass {
	
    public OrangeHRMDataDrivenTest() {
	
	super();
    }
	
	@BeforeMethod
	public void SetUp() throws IOException
	{
		
		BaseClass.init();
	}
	

	@Test(dataProvider = "OrangeHRMlogindata")
	
	public void OrangeHRMLoginTest(String Username,String Password)
	{
		Login lg = new Login(driver);
		lg.validateLogin(Username, Password);
		HomePage hp =new HomePage(driver);
		String validUsername ="Admin";
		String validPassword="admin123";
		
		
		if((Username.equals(validUsername))&&(Password.equals(validPassword)))
		{  String text =hp.getWelcomeText();
		System.out.println("WelcomeText: "+text);
		   if(text.contains("Welcome")) {System.out.println("Valid Username and valid Password");}
		   hp.doClickLogout();
		   Assert.assertTrue(true);
		}
		else if((Username.equals(validUsername))&&(!(Password.equals(validPassword))))
		{  
			//String errMsg =lg.validateLoginErrorMessage();
			//if(errMsg.equals("Invalid Credentials"))
			System.out.println("Valid Username and Invalid Password");
			Assert.assertTrue(false);
		}
		else if(!(Username.equals(validUsername))&&(Password.equals(validPassword))) {
			
			//String errMsg =lg.validateLoginErrorMessage();
			//if(errMsg.equals("Invalid Credentials"))
			System.out.println("InValid Username and Valid Password");
			Assert.assertTrue(false);
			
		}
		else
		{
			//String errMsg =lg.validateLoginErrorMessage();
			//if(errMsg.equals("Invalid Credentials"))
			System.out.println("InValid Username and InValid Password");
			Assert.assertTrue(false);
			
		}
		
	}	
	@DataProvider(name ="OrangeHRMlogindata")
	public String[][] getLoginData() throws IOException
	{   String path ="C:\\Users\\Saravanan\\eclipse-workspacenewQA\\Week6\\exceldata\\testDataOrangeHRMLogin.xlsx";
		ExcelReader xlreader = new ExcelReader();
		String logindata[][] =xlreader.passData(path, "Sheet1");
		 
		return logindata;
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
}
