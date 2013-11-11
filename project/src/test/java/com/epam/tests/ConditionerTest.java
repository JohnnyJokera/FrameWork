package com.epam.tests;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.epam.dataprovider.TestDataProvider;
import com.epam.helper.ConditionerHelper;
import com.epam.pages.HomePage;
import com.epam.pages.SelectPage;

public class ConditionerTest extends TestBase {
	
	private SelectPage selectPage;
	
	@BeforeMethod
	public void initElements() {
		selectPage = SelectPage.getSelectPage(driver);
	}

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "baseDataProvider")
	public void conditioner(String productName) {
		goToMainPage();
		Reporter.log("[LOG]" + " " + "Select the category 'Conditioner'<br>");
		HomePage.selectConditioner(driver, productName);
		Reporter.log("[LOG]" + " " + "Check result of searching in 3 different places<br>");
		ConditionerHelper.checkCommonDescription(selectPage);
		
	}

}
