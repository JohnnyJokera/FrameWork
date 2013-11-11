package com.epam.tests;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.dataprovider.TestDataProvider;
import com.epam.helper.BreadMakerHelper;
import com.epam.pages.HomePage;
import com.epam.pages.SelectPage;

public class BreadMakerTest extends TestBase {
	
	SelectPage selectPage;
	
	@BeforeMethod
	public void initElements() {
		selectPage = SelectPage.getSelectPage(driver);
	}
	
	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "baseDataProvider")
	public void breadmaker(String productName, String filterName) {
		goToMainPage();
		Reporter.log("[LOG]" + " " + "Select page 'Bread Maker' and filter 'weight adjustment'<br>");
		HomePage.selectItemBreadMaker(driver, productName, filterName);
		Reporter.log("[LOG]" + " " + "Result of products with filter 'weight adjustment'<br>");
		BreadMakerHelper.checkDescriptionFilter(selectPage, filterName);
	}
	
	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "baseDataProvider")
	public void breadmaker2(String productName) {
		
		goToMainPage();
		Reporter.log("[LOG]" + " " + "Select page 'Bread Maker'<br>");
		HomePage.selectItemBreadMaker2(driver, productName);
		Reporter.log("[LOG]" + " " + "Result of products's producers<br>");
		BreadMakerHelper.countProducers(selectPage);

	}
}
