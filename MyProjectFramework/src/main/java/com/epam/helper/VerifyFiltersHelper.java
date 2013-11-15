package com.epam.helper;

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
		List<String> newListName = new ArrayList<>();

		int lastPage = Integer.parseInt(lastPageV.getText());
		Reporter.log("[LOG]" + " " + "Get value from field 'names'<br>");
		int i = 1;
		int count = 0;
		while (i <= lastPage) {
			
			for (WebElement rows : rowsName) {

				String name = rows.getText();
				listName.add(name);
			
			}
			if (i < lastPage) {

				next.click();
			}
			i++;
		}
		for(int k = 1,j=0; k<listName.size()-1;k++,j++){
			
			if(listName.get(j).compareTo(listName.get(k))<0){
			count++;}
			}
			
	/*	Iterator<String> s = newListName.iterator();
		int j = 0;
		long countTrue = 0;
		while (s.hasNext()) {

			if (listName.get(j).equalsIgnoreCase(s.next())) {
				countTrue++;
			
			}
			j++;
		}
		System.out.println(countTrue);*/
	/*	newListName.addAll(listName);
		Collections.sort(newListName);*/
		System.out.println("old "+listName.size() + " new " + newListName.size());
		Reporter.log("[LOG]" + " " + "Assert names on page of refrigirators <br>");
	/*	System.out.println(listName);
		System.out.println(newListName);*/
		Assert.assertTrue(count==listName.size());
		
	}

}
