package com.orangehrm.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initializes all @FindBy elements
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitBTN;
	
	public void setUsername(String name) {
		username.sendKeys(name);
	}
	
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void submit() {
		submitBTN.click();
	}
}
