package com.epam.config;

public class Configuration {

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

}
