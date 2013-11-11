package com.epam.config;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Configuration {

	private static String browser;
	private static Capabilities driver = DesiredCapabilities.firefox();

	protected String baseUrl = "http://pn.com.ua/";
	private static String screenShotsDestinationFolder = "./test-output/Test Grid/";
	private static String screenShotsFileExtension = ".png";

	public static String getScreenShotsDestinationFolder() {
		return screenShotsDestinationFolder;
	}

	public static void setScreenShotsDestinationFolder(
			String screenShotsDestinationFolder) {
		Configuration.screenShotsDestinationFolder = screenShotsDestinationFolder;
	}

	public static String getScreenShotsFileExtension() {
		return screenShotsFileExtension;
	}

	public static void setScreenShotsFileExtension(
			String screenShotsFileExtension) {
		Configuration.screenShotsFileExtension = screenShotsFileExtension;
	}


	public static Capabilities getDriver() {
		return driver;
	}

}
