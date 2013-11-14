package com.epam.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage{
//--------------------------------Common block----------------------------------------------------------
	private final static String commonBlock = "//body/div[2]/div[3]/div[1]/div/div[1]";
	private static final String commonFilter = "/html/body/div[2]/div[3]/div/div[3]/div[1]/div[2]/div/div[1]";
//--------------------------------For microwave----------------------------------------------------------
	private static final String nameOfFirstItem = "//div[@id='page-content-wrap']/div[3]/div/div[2]/div/div[3]/div[3]/div[4]/span";
	private static final String nameOfSecondItem = "//div[@id='page-content-wrap']/div[3]/div/div[2]/div/div[3]/div[4]/div[4]/span";
	private static final String linkCompare = "/html/body/div[2]/div[3]/div/div[3]/div/div[2]/div/div[3]/div[3]/div[4]/span[3]/a";
	
//--------------------------------For Washing Machine---------------------------------------------------- 
	
	private static final String nameOfMinFilter = "html/body/div[2]/div[3]/div/div[3]/div[1]/div[1]/div/div[2]/div[3]/div[2]";
	private static final String nameOfMaxFilter = "html/body/div[2]/div[3]/div/div[3]/div[1]/div[1]/div/div[2]/div[4]/div[2]";
	
//-------------------------------------------------------------------------------------------------------
//--------------------------------For Bread Maker-------------------------------------------------------- 
	private static final String filterOfWidth = "/html/body/div[2]/div[3]/div/div[3]/div/div/div/div[2]/div[10]/div[2]";
	private static final String commonProducer = "show_common_producer";	
	
//-------------------------------------------------------------------------------------------------------
//--------------------------------For Conditioner-------------------------------------------------------- 
	
	
//-------------------------------------------------------------------------------------------------------

	@FindBy(xpath = commonBlock)
	public static WebElement category;

	@FindBy(xpath = commonFilter)
	public static WebElement filterPrice;
	
	//------------------------------------Microwave------------------------------------------------------
	
	@FindBy(xpath = nameOfFirstItem)
	public static WebElement firstItem;

	@FindBy(xpath = nameOfSecondItem)
	public static WebElement secondItem;

	@FindBy(xpath = linkCompare)
	public static WebElement compare;

//----------------------------------------Washing Machine------------------------------------------------
	
	@FindBy(xpath = nameOfMinFilter)
	public static WebElement minFil;
	
	@FindBy(xpath = nameOfMaxFilter)
	public static WebElement maxFil;
	
	public static WebElement getMinFil() {
		return minFil;
	}


	public static WebElement getMaxFil() {
		return maxFil;
	}
	
//------------------------------------------Bread Maker----------------------------------------------------
	@FindBy(xpath = filterOfWidth)
	public WebElement fil;
	
	@FindBy(className = commonProducer)
	public static WebElement showMore;	
	
//------------------------------------------Conditioner----------------------------------------------------
	
	
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div[3]/div/div[2]/div/div[3]")
	public List<WebElement> linksNames;
	
//-----------------------------------------Refrigerator---------------------------------------------------
	
	public static void selectitems(WebDriver driver, String a, String b) {
		
		driver.findElement(By.linkText(a)).click();
		driver.findElement(By.linkText(b)).click();

	}
	
	
	//-------------------------------------Microwave-------------------------------------------------------
	public static void selectItems(WebDriver driver, String name){
		driver.findElement(By.linkText(name)).click();
		driver.findElement(By.xpath("//div[@id='page-content-wrap']/div[3]/div/div[2]/div/div[3]/div[3]/div[4]/span")).click();
		driver.findElement(By.xpath("//div[@id='page-content-wrap']/div[3]/div/div[2]/div/div[3]/div[4]/div[4]/span")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[3]/div/div[2]/div/div[3]/div[3]/div[4]/span[3]/a")).click();
	}
	
	public static WebElement getLinkWave() {
		return category;
	}

	public static WebElement getFirstItem() {
		return firstItem;
	}

	public static WebElement getSecondItem() {
		return secondItem;
	}

	public static WebElement getCompare() {
		return compare;
	}
	
	//----------------------------------------Washing Machine---------------------------------------------------
	public static void selectItemWash(WebDriver driver, String name, String minPrice, String maxPrice) {
		driver.findElement(By.linkText(name)).click();
		driver.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[1]/div[1]/div/div[2]/div[3]/div[2]")).findElement(By.linkText(minPrice)).click();
		driver.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[1]/div[1]/div/div[2]/div[4]/div[2]")).findElement(By.linkText(maxPrice)).click();
		
	}
	
//----------------------------------------------Bread Maker------------------------------------------------------
	
	public static void selectItemBreadMaker(WebDriver driver, String name, String filter){
			
		driver.findElement(By.linkText(name)).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[3]/div/div/div/div[2]/div[10]/div[2]")).findElement(By.linkText(filter)).click();

		}	
	public static void selectItemBreadMaker2(WebDriver driver, String name) {
			driver.findElement(By.linkText(name)).click();
			driver.findElement(By.className("show_common_producer")).click();

		}


	public WebElement getFil() {
		return fil;
	}


	public WebElement getShowMore() {
		return showMore;
	}

//-----------------------------------------------Conditioner------------------------------------------------------
		
	public static void selectConditioner(WebDriver driver, String product) {
		
		driver.findElement(By.xpath(commonBlock)).findElement(By.linkText(product)).click();
	
	}
}

