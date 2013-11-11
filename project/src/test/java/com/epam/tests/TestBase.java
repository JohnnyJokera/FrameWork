package com.epam.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.epam.config.Configuration;
import com.epam.factories.WebDriverFactory;

public class TestBase extends Configuration {

	protected static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		Reporter.log("[LOG]" + " " + "Starting test "
				+ this.getClass().getSimpleName() + "<br>");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName(System.getProperty("webdriver.browser", "firefox"));
		
		driver = WebDriverFactory.getDriver(caps);
		Reporter.log("[LOG]" + " " + "Run base url<br>");
		baseUrl = "http://pn.com.ua/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void goToMainPage() {

		Reporter.log("[LOG]" + " " + "Opening main page <br>");
		driver.get(baseUrl + "/");
	
	}

	

}
