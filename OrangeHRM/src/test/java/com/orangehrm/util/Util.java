package com.orangehrm.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Util {
	
	public static WebDriver getDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
		//	ChromeOptions option = new ChromeOptions();
		//	option.addArguments("--headless=new");
		//	return new ChromeDriver(option);
			return new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			return new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			return new FirefoxDriver();
		}
		else return null;
	}
	
	public static void closeDriver(WebDriver driver) {
		driver.quit();
	}

}
