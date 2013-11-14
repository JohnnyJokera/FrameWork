package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricePage {

	private static final String goToPrice = "/html/body/div[2]/div[3]/div/div[3]/div/div/div/div/div/a";
	private static final String descriptionLink = "/html/body/div[2]/div[3]/div/div/div[4]/div/table/tbody/tr/td/a";

	@FindBy(xpath = goToPrice)
	public WebElement pricePage;
	
	@FindBy(xpath = descriptionLink)
	public WebElement description;
	
	public void verifyPricePage(){
		pricePage.click();
		
	}
	
	public static PricePage getSelectPage(WebDriver driver) {
		PricePage pricePage = PageFactory.initElements(driver, PricePage.class);
		return pricePage;
				
	}
}
