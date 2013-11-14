package com.epam.config;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Configuration {

	private static DesiredCapabilities driver = new DesiredCapabilities();

	public static Capabilities getDriver(){
		driver.setBrowserName(System.getProperty("webdriver.browser","chrome"));
		return driver;
	}
	

}
