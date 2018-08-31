package com.mascamo.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.mascamo.qa.Util.LoggerTest;
import com.mascamo.qa.Util.TestUtil;
import com.mascamo.qa.Util.WebEventListner;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public  static Actions action;
	public static EventFiringWebDriver e_driver;
	public static WebEventListner listner;
	
	public static LoggerTest logg;

	public TestBase() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\s.nagaraja.setty\\Desktop\\Maven Actitime\\FreeCRMTest\\src\\main"
							+ "\\java\\com\\mascamo\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void initialization() {
		String Browsername = prop.getProperty("browser");
		if (Browsername.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\s.nagaraja.setty\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
			driver = new FirefoxDriver();
		} 
		else if (Browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\s.nagaraja.setty\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if (Browsername.equals("ie")) {
			driver = new InternetExplorerDriver();
		}
		
		e_driver= new EventFiringWebDriver(driver);
		//create object for the  webdriverlistner
		
		listner=new WebEventListner();
		e_driver.register(listner);
		driver=e_driver;
		LoggerTest.log.info("maximizing the browser");
		driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		action =new Actions(driver);
		
		
	}

}
