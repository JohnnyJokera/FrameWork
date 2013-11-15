package com.epam.helper;

import static com.epam.helper.TestBaseHelper.log;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.pages.SelectPage;

public class VerifyLocationHelper {

	List<String> li = new ArrayList<>();
	static List<String> listForDescription;
	static List<String> listForDescription2;
	static List<String> listForFive;
	static List<String> listForLinks;
	public static List<String> list;

	public static void checkCommonDescription(SelectPage selectPage) {
		
		log("[LOG]" + " " + "Checking result of searching in 3 different places<br>");

		List<WebElement> descript = selectPage.getDescriptionConditioner();

		WebElement goBack = selectPage.getGoBackToConditioner();

		String url;

		WebElement goBackToCatalog = selectPage.getGoBackToCatalog();

		WebElement goToPrice = selectPage.getPriceLink();

		List<WebElement> listName = selectPage.getConditionerName();

		List<String> firstFiveElementDescript = new ArrayList<>();
		List<String> firstFiveElementName = new ArrayList<>();
		List<String[]> firstFiveElementDescriptionMas = new ArrayList<>();

		list = new ArrayList<>();

		for (int i = 0; i < 5; i++) {

			firstFiveElementDescript.add(descript.get(i).getText());
			firstFiveElementName.add(listName.get(i).getText());
			firstFiveElementDescriptionMas.add(descript.get(i).getText()
					.split(";"));
		}

		for (int i = 0; i < 5; i++) {

			WebElement name = listName.get(i);
			url = name.findElement(By.linkText(name.getText())).getAttribute("href");
			name.findElement(By.linkText(name.getText())).click();

			System.out.println(url);
			checkFullDescription(selectPage, firstFiveElementName.get(i));
			String[] des = firstFiveElementDescriptionMas.get(i);
			Assert.assertTrue(listForDescription.contains(des[2].trim()
					.toLowerCase()));

			goBack.click();

			goToPrice
					.findElement(
							By.xpath("/html/body/div[2]/div[3]/div/div[3]/div/div/div/div/div/a"))
					.click();
			checkPricePage(selectPage, firstFiveElementName.get(i));

			Assert.assertTrue(listForDescription2.contains(url));

			goBackToCatalog.click();
		}

	}

	private static void checkFullDescription(SelectPage selectPage, String name) {
		log("[LOG]" + " " + "Checking full description <br>");
		listForDescription = new ArrayList<>();

		List<WebElement> descriptionTable = selectPage.getDescriptionTable();

		for (WebElement rows : descriptionTable) {

			String feature = rows.findElement(By.className("pr")).getText()
					.concat(" ")
					.concat(rows.findElement(By.className("val")).getText())
					.toLowerCase();
			listForDescription.add(feature);
		}
	}

	private static void checkPricePage(SelectPage selectPage, String name) {
		log("[LOG]" + " " + "Checking description on price page<br>");
		List<WebElement> price = selectPage.getcommonPriceBlock();
		selectPage.getinputField().sendKeys(name);
		selectPage.getbuttonSearch().click();
		listForDescription2 = new ArrayList<>();

		for (WebElement rows : price) {

			String feature = rows
					.findElement(
							By.xpath("/html/body/div[2]/div[3]/div/div/div[4]/div/table/tbody/tr/td/a"))
					.getAttribute("href");
			listForDescription2.add(feature);

		}
	}
}
