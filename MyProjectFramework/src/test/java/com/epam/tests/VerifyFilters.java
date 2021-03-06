package com.epam.tests;


import java.io.IOException;
import static com.epam.helper.TestBaseHelper.log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.epam.dataprovider.TestDataProvider;
import com.epam.helper.VerifyFiltersHelper;
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
		VerifyFiltersHelper.checkPriceFilter(selectPage);
		
	}
	
	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "baseDataProvider")
	public void orderName(String name, String filter) throws IOException{
			
		goToMainPage();
		HomePage.selectitems(driver,name, filter);
		VerifyFiltersHelper.checkNameFilter(selectPage);
		
	}
}
