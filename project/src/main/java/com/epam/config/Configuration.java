package com.epam.config;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Configuration {

	private static Capabilities driver = DesiredCapabilities.firefox();
	protected String baseUrl = "http://pn.com.ua/";

	
	public static Capabilities getdriver(){
		return driver;
	}

}
