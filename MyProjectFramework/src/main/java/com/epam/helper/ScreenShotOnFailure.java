package com.epam.helper;

import java.io.File;
import static com.epam.helper.TestBaseHelper.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeMethod;

import com.epam.config.Configuration;
import com.epam.factories.WebDriverFactory;
import com.epam.pages.SelectPage;

public class ScreenShotOnFailure extends TestListenerAdapter {
	 private static final String NAME = "<a href=\"%s\"><img src=\"%<s\" width=200 height=150></a><br>";
	@Override
	public void onTestFailure(ITestResult tr) {
	
		WebDriver driver = WebDriverFactory.getDriver(Configuration.getDriver());
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy__hh_mm_ssaa");
		String destDir = "target/surefire-reports/html/screenshots";
		new File(destDir).mkdirs();
		String destFile = dateFormat.format(new Date()) + ".png";
		try {
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {

			e.printStackTrace();
		}
		Reporter.setEscapeHtml(false);
		log(String.format(NAME, "screenshots/" + destFile));
	}
}
