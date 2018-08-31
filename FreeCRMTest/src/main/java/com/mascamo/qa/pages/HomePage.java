package com.mascamo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.mascamo.qa.TestBase.TestBase;

public class HomePage extends TestBase {

	@FindBy(how = How.XPATH, using = "//td[contains(text(),'User: Sachin Shetty')]")
	WebElement Usernamelabel;

	@FindBy(xpath = "//a[text()='Contacts']")
	WebElement contactslink;
	
	@FindBy(xpath = "//a[text()='New Contact']")
	WebElement Newcontactslink;

	
	
	@FindBy(xpath = "//a[text()='Deals']")
	WebElement Dealslink;

	@FindBy(xpath = "//a[text()='Deals']")
	WebElement Tasklink;

	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public String validatehomepagetitle() {
		return driver.getTitle();
	}
	
	public boolean verifyusername() {
		 return Usernamelabel.isDisplayed();
		 
	}

	public ContactsPage clickoncontactslink() {
		contactslink.click();
		return new ContactsPage();
	}

	public DealsPage clickondealslink() {
		Dealslink.click();
		return new DealsPage();
	}
	
	public TaskPage clickontasklink() {
		Tasklink.click();
		return new TaskPage();
	}
	
	public ContactsPage clickonnewContactlink() {
		action.moveToElement(contactslink).build().perform();
		Newcontactslink.click();
		return new ContactsPage();
	}
	

	

}
