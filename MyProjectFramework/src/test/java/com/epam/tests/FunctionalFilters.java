package com.epam.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.epam.dataprovider.TestDataProvider;
import com.epam.helper.FunctionalFiltersHelper;
import com.epam.pages.HomePage;
import com.epam.pages.SelectPage;
import static com.epam.helper.TestBaseHelper.log;

public class FunctionalFilters extends TestBase {
	
	SelectPage selectPage;
	
	@BeforeMethod
	public void initElements() {
		selectPage = SelectPage.getSelectPage(driver);
	}
	
	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "baseDataProvider")
	public void breadmaker(String productName, String filterName) {
		goToMainPage();
		HomePage.goToProductPage(driver, productName);
		HomePage.selectItemBreadMaker(driver, filterName);
		FunctionalFiltersHelper.checkDescriptionFilter(selectPage, filterName);
	}
	
	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "baseDataProvider")
	public void breadmaker2(String productName) {
		
		goToMainPage();
		HomePage.selectItemBreadMaker2(driver, productName);
		FunctionalFiltersHelper.countProducers(selectPage);

	}
}
