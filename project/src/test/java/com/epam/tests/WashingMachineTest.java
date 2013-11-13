package com.epam.tests;

import static com.epam.helper.TestBaseHelper.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.dataprovider.TestDataProvider;
import com.epam.helper.WashingMachineHelper;
import com.epam.pages.HomePage;
import com.epam.pages.SelectPage;

public class WashingMachineTest extends TestBase {
	
	private SelectPage selectPage;
	
	@BeforeMethod
	public void initElements() {
		selectPage = SelectPage.getSelectPage(driver);
	}

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "baseDataProvider")
	public void washmachine(String productName, String min, String max) {

		goToMainPage();
		log("[LOG]" + " " + "Choose category, min & max price <br>");
		HomePage.selectItemWash(driver, productName, min, max);
		log("[LOG]" + " " + "Checking sorted product <br>");
		WashingMachineHelper.verifyMinMaxFilters(selectPage, min, max);

	}

}
