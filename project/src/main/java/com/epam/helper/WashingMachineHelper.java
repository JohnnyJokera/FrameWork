package com.epam.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.epam.pages.SelectPage;

public class WashingMachineHelper {

	private static List<Integer> listPrice;

	public static void verifyMinMaxFilters(SelectPage selectPage,
			String minTarget, String maxTarget) {

		WebElement lastPageV = selectPage.getlastPage();
		WebElement next = selectPage.getNext();
		List<WebElement> minimum = selectPage.getminFilter();
		int i = 1;
		int lastPage = Integer.parseInt(lastPageV.getText());

		listPrice = new ArrayList<>();

		while (i <= lastPage) {
			for (WebElement rows : minimum) {
				String price = rows.findElement(By.tagName("strong")).getText();
				price = price.substring(0, price.length() - 3).trim()
						.replaceAll(" ", "");
				listPrice.add(Integer.parseInt(price));
			}
			if (i != lastPage) {
				next.click();
			}
			i++;
		}

		for (int j = 0; j < listPrice.size(); j++) {

			System.out.println(listPrice.get(j));

		}

		Collections.sort(listPrice);
		System.out.println(listPrice);
		int min = Integer.parseInt(minTarget);
		int max = Integer.parseInt(maxTarget);
		Assert.assertTrue(listPrice.get(0) >= min);
		Assert.assertTrue(listPrice.get(listPrice.size()-1) <= max);
		if (listPrice.get(0) >= min && listPrice.get(listPrice.size()-1) <= max) {
			System.out.println("true");
		}

	}

}
