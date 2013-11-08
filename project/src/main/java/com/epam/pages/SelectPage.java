package com.epam.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPage{
	//----------------------Filters-----------------------
	private static final String lastPageLink = "pager-last";
	private static final String fieldsOfPrices = ".item .price";
	private static final String nextPageLink = "//html/body/div[2]/div[3]/div/div[3]/div/div[2]/div/div[3]/div[2]/div/div/ul/li[2]/a";
	private static final String fieldsOfNames = "name";
//--------------------------Microwave----------------------
	private static final String itemName = "different";

	@FindBy(className = itemName)
	private List<WebElement> propertiesRows;
//--------------------------Washing Machine-----------------
	
	private static final String nameOfItem = "price";

	@FindBy(className = nameOfItem)
	private List<WebElement> minFilter;
	
//--------------------------Bread Maker---------------------
	private static final String description = "description";
	private static final String producers = "/html/body/div[2]/div[3]/div/div[3]/div/div/div/div[2]/div[5]/div[2]";
	private static final String producersHide = "//html/body/div[2]/div[3]/div/div[3]/div/div/div/div[2]/div[5]/div[2]/div[3]";
	private static final String name = "name";
	
	@FindBy(className = description)
	private List<WebElement> descript;

	@FindBy(xpath = producers)
	private WebElement prod;

	@FindBy(xpath = producersHide)
	private WebElement prodHide;

	@FindBy(className = name)
	private List<WebElement> prodName;
	
	public List<WebElement> getDescript() {
		return descript;
	}

	public WebElement getProd() {
		return prod;
	}

	public WebElement getProdHide() {
		return prodHide;
	}

	public List<WebElement> getProdName() {
		return prodName;
	}
	
//---------------------------Conditioner----------------------
	
	private static final String nameOfItemC = "name";
	private static final String linkToGoToPrises = "/html/body/div[2]/div[3]/div/div[3]/div/div/div/div/div/a";
	private static final String goBack = "/html/body/div[2]/div[3]/div/div/a[3]";
	private static final String linkOfDescription = "/html/body/div[2]/div[3]/div/div/div[4]/div/table/tbody/tr/td/a";
	private static final String descriptConditioner = "description";
	private static final String descriptionPrice = "n";
	private static final String allDescript ="/html/body/div[2]/div[3]/div/div[4]/div/div";
	private static final String catalog = "/html/body/div[2]/div[3]/div/div/div[3]/div/div/div/a";
	private static final String URL = "http://pn.com.ua/md/405796/";
		
	@FindBy(className = descriptionPrice)
	public List<WebElement> commonPriceBlock;

	@FindBy(className = descriptConditioner)
	public List<WebElement> descriptionConditioner;

	@FindBy(xpath = nameOfItem)
	public WebElement firstItemConditioner;

	@FindBy(className = "row")
	public List<WebElement> descriptionTable;

	@FindBy(xpath = linkToGoToPrises)
	public WebElement priceLink;

	@FindBy(id = "edit-name-1")
	public WebElement inputField;

	@FindBy(id = "edit-submit-1")
	public WebElement buttonSearch;

	@FindBy(xpath = goBack)
	public WebElement goBackToConditioner;

	@FindBy(xpath = linkOfDescription)
	public WebElement descriptionLink;

	@FindBy(xpath = catalog)
	public WebElement goBackToCatalog;
	
	@FindBy(className = nameOfItemC)
	private List<WebElement> conditionerName;
	
	public WebElement getPriceLink() {
		return priceLink;
	}
	
	public List<WebElement> getDescriptionTable() {
		return descriptionTable;
	}
	public List<WebElement> getDescriptionConditioner() {
		return descriptionConditioner;
	}
	
	public WebElement getGoBackToConditioner() {
		return goBackToConditioner;
	}

	public WebElement getGoBackToCatalog() {
		return goBackToCatalog;
	}
	
	public String getURL(){
		return URL;
	}
	public List<WebElement> getConditionerName(){
		return conditionerName;
	}
	
	public WebElement getinputField(){
		return inputField;
	}
	
	public WebElement getbuttonSearch(){
		return buttonSearch;
	}
	public List<WebElement> getcommonPriceBlock(){
		return commonPriceBlock;
	}
//---------------------------Common fields--------------------

	@FindBy(className = lastPageLink)
	private WebElement lastPage;

	@FindBy(css = fieldsOfPrices)
	private List<WebElement> rowsPrice;

	@FindBy(xpath = nextPageLink)
	private WebElement next;

	@FindBy(className = fieldsOfNames)
	private List<WebElement> rowsName;

	public WebElement getlastPage(){
		return lastPage;
	}
	
	public List<WebElement> getrowsPrice(){
		
		return rowsPrice;
	}
	
	public  WebElement getNext(){
		return next;
	}
	
	public List<WebElement> getRowsName(){
		return rowsName;
	}
	
	public List<WebElement> getpropertiesRows(){
		return propertiesRows;
	}
	
	public List<WebElement> getminFilter(){
		return minFilter;
	}

	public static SelectPage getSelectPage(WebDriver driver) {
		System.out.println("Before");
		SelectPage selectPage = PageFactory.initElements(driver, SelectPage.class);
		return selectPage;
				
	}

}