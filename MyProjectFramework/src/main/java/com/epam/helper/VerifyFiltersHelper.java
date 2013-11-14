package com.epam.helper;

import java.util.ArrayList;
import java.util.Collections;
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

		List<Integer> newListPrice = new ArrayList<>(listPrice);
		Collections.copy(newListPrice, listPrice);
		Collections.sort(newListPrice);
		System.out.println("Site's filter ->> "+listPrice);
		System.out.println("java's filer ->>> "+newListPrice);
		Reporter.log("[LOG]" + " " + "Assert prices on page of refrigirators <br>");
		Assert.assertTrue(listPrice.equals(newListPrice));

	}

	public static void checkNameFilter(SelectPage selectPage) {

		WebElement lastPageV = selectPage.getlastPage();
		WebElement next = selectPage.getNext();

		List<WebElement> rowsName = selectPage.getRowsName();
		List<String> listName = new ArrayList<>();
		Set<String> newListName = new TreeSet<>();

		int lastPage = Integer.parseInt(lastPageV.getText());
		Reporter.log("[LOG]" + " " + "Get value from field 'names'<br>");
		int i = 1;
		while (i <= lastPage) {
			
			for (WebElement rows : rowsName) {

				String price = rows.getText();
				listName.add(price);
				newListName.add(price);
			}
			if (i < lastPage) {

				next.click();
			}
			i++;
		}

		Iterator<String> s = newListName.iterator();
		int j = 0;
		long countTrue = 0;
		while (s.hasNext()) {

			if (listName.get(j).equalsIgnoreCase(s.next())) {
				countTrue++;
				System.out.println(listName.get(j));
				System.out.println("----");
				System.out.println(s.next());
			}
			j++;
		}
		Reporter.log("[LOG]" + " " + "Assert names on page of refrigirators <br>");
		Assert.assertTrue(countTrue == listName.size());
	}

}
