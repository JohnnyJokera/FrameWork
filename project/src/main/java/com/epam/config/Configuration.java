package com.epam.config;


public class Configuration {

	private static String browser;

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

	public static void setBrowser() {
		Configuration.browser = Properti.getBrowserName();
	}
	
	public static String getBrowser() {
		return browser;
	}

	

}
