package com.mascamo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mascamo.qa.TestBase.TestBase;

public class LoginPage extends TestBase {

	// pagefactory OR

	@FindBy(how = How.NAME, using = "username")
	WebElement username;

	@FindBy(how = How.NAME, using = "password")
	WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@value='Login']")
	WebElement loginbtn;

	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement Pagelogo;

	@FindBy(xpath = "//div[@class='intercom-borderless-dismiss-button']")
	WebElement chatbotdiss;

	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	public String validateloginpagetitle() {
		return driver.getTitle();
	}

	public boolean CRMlogodisplayed() {
		return Pagelogo.isDisplayed();
	}

	public HomePage validatelogin(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		driver.switchTo().frame("intercom-borderless-frame");
		chatbotdiss.click();
        driver.switchTo().defaultContent();
		loginbtn.click();
		return new HomePage();
	}
}
