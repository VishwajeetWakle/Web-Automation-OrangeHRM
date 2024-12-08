package com.orangehrm.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.page.LoginPage;
import com.orangehrm.util.Util;

public class Login {
	
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		driver = Util.getDriver("chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage = new LoginPage(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test
	public void loginWithCorrectCreds() {
		loginPage.setUsername("Admin");
		loginPage.setPassword("admin123");
		loginPage.submit();
		Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());
	}
	
	@Test
	public void loginWithInvalidUsername() {
		loginPage.setUsername("Asdfghk");
		loginPage.setPassword("admin123");
		loginPage.submit();
		Assert.assertTrue(loginPage.isInvalidCredErrorMsgDisplayed());
	}
	
	@Test
	public void loginWithInvalidPassword() {
		loginPage.setUsername("Admin");
		loginPage.setPassword("admin12");
		loginPage.submit();
		Assert.assertTrue(loginPage.isInvalidCredErrorMsgDisplayed());
	}
	
	@Test
	public void loginWithInvalidCreds() {
		loginPage.setUsername("Admin123");
		loginPage.setPassword("admin");
		loginPage.submit();
		Assert.assertTrue(loginPage.isInvalidCredErrorMsgDisplayed());
	}
	
	@AfterMethod
	public void tearDown() {
		Util.closeDriver(driver);
	}

}
