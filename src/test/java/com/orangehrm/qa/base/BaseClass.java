package com.orangehrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;

import com.orangehrm.qa.util.TestUtil;

public class BaseClass {

	/*
	 * Initialise Webdriver, properties, xls ,creating db connection, generating
	 * logs
	 */

	public static Properties config;
	public static WebDriver driver;

	
	//@BeforeSuite()
	
	public BaseClass() {
	
		try {
			config = new Properties();
			// load config property file
			FileInputStream fis = new FileInputStream("C:\\Users\\Saravanan\\eclipse-workspacenewQA\\Week6\\src\\test\\java\\com\\orangehrm\\qa\\config\\properties\\config.properties");
			config.load(fis);
	       }
		catch(FileNotFoundException e) {
		e.printStackTrace();}
		catch(IOException e) {		
		e.printStackTrace();}}
			// load excel file
		//	excel = new Xls_Reader(
		//	System.getProperty("user.dir") + "\\src\\test\\java\\busyqa\\properties\\testdata.xlsx");
		//	app_logs.debug("loading the excel file");
	
	public static void init() throws IOException {
		
	
			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("edge")) {
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +"\\src\\test\\resources\\executables\\MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
			}

			driver.get(config.getProperty("testsiteURL"));
			driver.manage().window().maximize();

			// Global implicit Wait
				
			
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAIT, TimeUnit.SECONDS);
				}
		
	
	}
