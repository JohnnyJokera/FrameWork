package com.epam.tests;

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
		HomePage.selectItemBreadMaker(driver, productName, filterName);
		BreadMakerHelper.checkDescriptionFilter(selectPage, filterName);
	}
	
	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "baseDataProvider")
	public void breadmaker2(String productName) {
		
		goToMainPage();
		HomePage.selectItemBreadMaker2(driver, productName);
		BreadMakerHelper.countProducers(selectPage);

	}
}
