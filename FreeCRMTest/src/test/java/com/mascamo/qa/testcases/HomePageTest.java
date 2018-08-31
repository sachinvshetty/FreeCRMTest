package com.mascamo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mascamo.qa.TestBase.TestBase;
import com.mascamo.qa.Util.TestUtil;
import com.mascamo.qa.pages.ContactsPage;
import com.mascamo.qa.pages.HomePage;
import com.mascamo.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactpage;

	public HomePageTest() {
		super();
	}

	//using  Method as the  test cases should be  independent sue to crash ,cookies,blank page error
	//test cases should be independent
	//before each test case launch and login
	//execute the test case 
	//close the  browser
	
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		testutil =new TestUtil();
		loginPage = new LoginPage();
		contactpage= new ContactsPage();
		homePage = loginPage.validatelogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1,enabled=false)
	public void VerifyHomepageTitletest() {
		String actualhomepagetitle = homePage.validatehomepagetitle();
		Assert.assertEquals(actualhomepagetitle, "CRMPRO", "home page title not matched");

	}

	@Test(priority = 2,enabled=false)
	public void Verifyusernamehometest() 
	{
		testutil.switchtoframe();
		Boolean Uname = homePage.verifyusername();
		Assert.assertTrue(Uname);
	}


		@Test(priority = 3,enabled=false)
		public void VerifyContactLinkTest() {
			testutil.switchtoframe();
			contactpage =homePage.clickoncontactslink();
	}

		@Test(priority = 4)
		public void VerifyNewContactLinkTest() {
			testutil.switchtoframe();
			contactpage =homePage.clickonnewContactlink();
	}

	@AfterMethod
	public void teardown() {
		driver.quit(); 	
	}

}
