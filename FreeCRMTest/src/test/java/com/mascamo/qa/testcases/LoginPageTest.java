package com.mascamo.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mascamo.qa.TestBase.TestBase;
import com.mascamo.qa.Util.LoggerTest;
import com.mascamo.qa.pages.HomePage;
import com.mascamo.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeClass
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}

	
	//Services
	
	@Test(priority = 0)
	public void loginpagetitletest() {
		String loginpagetitle = loginPage.validateloginpagetitle();
		Assert.assertEquals(loginpagetitle, "#1 Free CRM software in the cloud for sales and service");
		LoggerTest.log.info("checking the login page title");
	}

	@Test(priority = 1)
	public void loginpageCRMimage() {
		boolean flag = loginPage.CRMlogodisplayed();
		Assert.assertTrue(flag);
		

	}

	@Test(priority = 2)
	public void loginTest() {
		homepage = loginPage.validatelogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterClass
	public void teardown() {
		driver.quit();

	}

}
