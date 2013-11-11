package com.epam.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public class Properti {

	private static Properties prop = new Properties();

	static {
		try {

			prop.load(new FileInputStream("prop.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public static String getInputDataDir() {

		return prop.getProperty("input.data.dir");

	}
	
	

}
