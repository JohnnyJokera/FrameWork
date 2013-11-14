package com.epam.tests;

import static com.epam.helper.TestBaseHelper.log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.epam.dataprovider.TestDataProvider;
import com.epam.helper.VerifyLocationHelper;
import com.epam.pages.HomePage;
import com.epam.pages.SelectPage;

public class VerifyLocation extends TestBase {
	
	private SelectPage selectPage;
	
	@BeforeMethod
	public void initElements() {
		selectPage = SelectPage.getSelectPage(driver);
	}

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "baseDataProvider")
	public void conditioner(String productName) {
		goToMainPage();
		log("[LOG]" + " " + "Select the category 'Conditioner'<br>");
		HomePage.selectConditioner(driver, productName);
		log("[LOG]" + " " + "Check result of searching in 3 different places<br>");
		VerifyLocationHelper.checkCommonDescription(selectPage);
		
	}

}
