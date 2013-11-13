package com.epam.config;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Configuration {

	private static DesiredCapabilities driver = new DesiredCapabilities();
	protected String baseUrl = "http://pn.com.ua/";

	public static Capabilities getDriver(){
		driver.setBrowserName(System.getProperty("webdriver.browser","firefox"));
		return driver;
	}

}
