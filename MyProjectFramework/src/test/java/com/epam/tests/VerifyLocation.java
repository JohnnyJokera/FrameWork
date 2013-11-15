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
		HomePage.selectConditioner(driver, productName);
		VerifyLocationHelper.checkCommonDescription(selectPage);
		
	}

}
