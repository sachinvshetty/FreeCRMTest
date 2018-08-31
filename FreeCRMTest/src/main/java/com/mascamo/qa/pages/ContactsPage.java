package com.mascamo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mascamo.qa.TestBase.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement Contactslabel;

	@FindBy(id = "first_name")
	WebElement first_name;

	@FindBy(id = "surname")
	WebElement last_name;

	@FindBy(name = "client_lookup")
	WebElement company_name;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement savebtn;
	
	

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactLabel() {

		return Contactslabel.isDisplayed();

	}

	public void SelectcontactByname(String name) {
		driver.findElement(By.xpath("//a[text()='" + name + "']/../..//input[@type='checkbox']")).click();

	}

	public void CreatenewContact(String title,String frstname,String lastname,String companyname ) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		first_name.sendKeys(frstname);
		last_name.sendKeys(lastname);
		company_name.sendKeys(companyname);
		savebtn.click();
		
	}

}
