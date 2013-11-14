package com.epam.tests;

import static com.epam.helper.TestBaseHelper.log;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import com.epam.config.Configuration;
import com.epam.factories.WebDriverFactory;

public class TestBase extends Configuration {

	protected static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		log("[LOG]" + " " + "Starting test "
				+ this.getClass().getSimpleName() + "<br>");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(System.getProperty("webdriver.browser","chrome"));
				
		driver = WebDriverFactory.getDriver(cap);
		log("[LOG]" + " " + "Run base url<br>");
		baseUrl = "http://pn.com.ua/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public void goToMainPage() {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		log("[LOG]" + " " + "Opening main page <br>");
		driver.get(baseUrl + "/");
	
	}

	

}
