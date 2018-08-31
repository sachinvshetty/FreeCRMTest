package com.mascamo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mascamo.qa.TestBase.TestBase;
import com.mascamo.qa.Util.TestUtil;
import com.mascamo.qa.pages.ContactsPage;
import com.mascamo.qa.pages.HomePage;
import com.mascamo.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactpage;
	String sheet = "contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		testutil = new TestUtil();
		loginPage = new LoginPage();
		contactpage = new ContactsPage();
		homePage = loginPage.validatelogin(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchtoframe();
		contactpage = homePage.clickoncontactslink();
	}

	@Test(priority = 1, enabled = false)
	public void verifyContactslabel() {
		Assert.assertTrue(contactpage.verifyContactLabel(), "contact lable is missing in the page");
	}

	@Test(priority = 2, enabled = false)
	public void selectcontactsTest() {
		contactpage.SelectcontactByname("pavan chandra");

	}

	@Test(priority = 3, enabled = false)
	public void selectMultiplecontactsTest() {
		contactpage.SelectcontactByname("pavan chandra");
		contactpage.SelectcontactByname("nare mamu");
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheet);
		return data;
	}
	
	@Test(priority = 4,dataProvider="getCRMTestData")
	public void CreateNewcontactTest(String title,String first_name,String Last_name,String company) {
		homePage.clickonnewContactlink();
		contactpage.CreatenewContact(title, first_name, Last_name, company);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
