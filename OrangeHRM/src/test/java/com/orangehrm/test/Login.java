package com.orangehrm.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangehrm.page.LoginPage;
import com.orangehrm.util.Util;

public class Login {
	
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeClass
	public void setUp() {
		driver = Util.getDriver("chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage = new LoginPage(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test
	public void login() {
		loginPage.setUsername("Admin");
		loginPage.setPassword("admin123");
		loginPage.submit();
		Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());
		Util.closeDriver(driver);
	}

}
