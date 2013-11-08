package com.epam.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.dataprovider.TestDataProvider;
import com.epam.helper.MicrowaveHelper;
import com.epam.pages.HomePage;
import com.epam.pages.SelectPage;

public class MicrowaveTest extends TestBase{

	private SelectPage selectPage;
	
	@BeforeMethod
	public void initElements() {
		selectPage = SelectPage.getSelectPage(driver);
	}
	
	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "baseDataProvider")
	public void microWave(String productName) {
	
		goToMainPage();
		HomePage.selectItems(driver, productName);
		
		MicrowaveHelper.getMicrowave(selectPage);

	}
	

}
