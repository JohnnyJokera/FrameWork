package com.epam.helper;

import static com.epam.helper.TestBaseHelper.log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.bouncycastle.crypto.tls.AlertDescription;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.epam.pages.SelectPage;

public class VerifyFiltersHelper {

	public static void checkPriceFilter(SelectPage selectPage) {
		log("[LOG]" + " " + "Checking filter 'price' <br>");
		WebElement lastPageV = selectPage.getlastPage();
		WebElement next = selectPage.getNext();

		List<WebElement> rowsPrice = selectPage.getrowsPrice();
		List<Integer> listPrice = new ArrayList<>();

		int t = 1;
		int lastPage = Integer.parseInt(lastPageV.getText());
Reporter.log("[LOG]" + " " + "Get value from field 'prices'<br>");
		while (t <=lastPage) {

			for (WebElement rows : rowsPrice) {
				
				String price = rows.findElement(By.tagName("strong")).getText();
				price = price.substring(0, price.length() - 3).trim()
						.replaceAll(" ", "");
				listPrice.add(Integer.parseInt(price));
			}
			if (t < lastPage) {
				next.click();

			}
			t++;
		}
		log("[LOG]" + " " + "Creating new list of product <br>");
		List<Integer> newListPrice = new ArrayList<>(listPrice);
		Collections.copy(newListPrice, listPrice);
		log("[LOG]" + " " + "Sort by using Java <br>");
		Collections.sort(newListPrice);
		Reporter.log("[LOG]" + " " + "Assert prices on page of refrigirators <br>");
		Assert.assertTrue(listPrice.equals(newListPrice));

	}

	public static void checkNameFilter(SelectPage selectPage) {
		log("[LOG]" + " " + "Checking filter 'name' <br>");
		WebElement lastPageV = selectPage.getlastPage();
		WebElement next = selectPage.getNext();

		List<WebElement> rowsName = selectPage.getRowsName();
		List<String> listName = new ArrayList<>();
		List<String> newListName = new ArrayList<>();

		int lastPage = Integer.parseInt(lastPageV.getText());
		Reporter.log("[LOG]" + " " + "Get value from field 'names'<br>");
		int i = 1;
		int count = 0;
		while (i <= lastPage) {
			
			for (WebElement rows : rowsName) {

				String name = rows.getText();
				listName.add(name.toLowerCase());
			
			}
			if (i < lastPage) {

				next.click();
			}
			i++;
		}
		log("[LOG]" + " " + "Creating new list of product <br>");
		newListName.addAll(listName);
		log("[LOG]" + " " + "Sort by using Java <br>");
		Collections.sort(newListName);
		Reporter.log("[LOG]" + " " + "Assert names on page of refrigirators <br>");
		Assert.assertTrue(listName.equals(newListName));
		
	}

}
