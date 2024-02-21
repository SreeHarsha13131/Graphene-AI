package com.framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.testCases.BaseClass;

public class LoginPage extends BaseClass {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Email Address']")
	@CacheLookup
	WebElement txtUsrname;

	@FindBy(xpath = "//input[@placeholder='Password']")
	@CacheLookup
	WebElement txtPaswrd;

	@FindBy(xpath = "//span[.='Login']")
	@CacheLookup
	WebElement loginBtn;

	@FindBy(xpath = "//span[@class='font-semibold']")
	@CacheLookup
	WebElement lnkLogout;

	@FindBy(xpath = "//span[.='MR Transcripts Automation']")
	@CacheLookup
	WebElement MRTranscriptsAutomation;

	public void setUsrName(String uname) {
		txtUsrname.sendKeys(uname);
	}

	public void setPassword(String passwrd) {
		txtPaswrd.sendKeys(passwrd);
	}

	public void clickSubmit() {
		loginBtn.click();
	}

	public void getTitle() {
		String MRTranscriptsAutomationTest = MRTranscriptsAutomation.getText();
		System.out.println(MRTranscriptsAutomationTest);

	}

	public void clickLogout() {
		lnkLogout.click();
	}

}
