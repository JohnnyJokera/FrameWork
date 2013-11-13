package com.epam.tests;


import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.dataprovider.TestDataProvider;
import com.epam.helper.RefregeratorHelper;
import com.epam.pages.HomePage;
import com.epam.pages.SelectPage;


public class VerifyFilters extends TestBase{
	
	private SelectPage selectPage;
	
	@BeforeMethod
	public void initElements() {
		selectPage = SelectPage.getSelectPage(driver);
	}

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "baseDataProvider")
	public void orderPrice(String name, String filter) throws IOException{
			
		goToMainPage();
		HomePage.selectitems(driver,name, filter);
		RefregeratorHelper.checkPriceFilter(selectPage);
		
	}
	
	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "baseDataProvider")
	public void orderName(String name, String filter) throws IOException{
			
		goToMainPage();
		HomePage.selectitems(driver,name, filter);
		RefregeratorHelper.checkNameFilter(selectPage);
		
	}
}
