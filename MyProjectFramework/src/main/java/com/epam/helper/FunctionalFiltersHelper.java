package com.epam.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.epam.pages.SelectPage;

public class FunctionalFiltersHelper {

	public static List<String> listDescription;
	public static Set<String> listProdusers;
	public static Set<String> setOfProducers;

	public static void checkDescriptionFilter(SelectPage selectPage, String str) {
		listDescription = new ArrayList<>();

		WebElement lastPageV = selectPage.getlastPage();
		WebElement next = selectPage.getNext();
		List<WebElement> description = selectPage.getDescript();

		int t = 1;
		int lastPage = Integer.parseInt(lastPageV.getText());

		while (t <= lastPage) {
			for (WebElement rows : description) {
				String strDescription = rows.getText();
				if (!strDescription.equals("")) {
					listDescription.add(strDescription);
				}

			}

			if (t != lastPage) {
				next.click();
			}
			t++;

		}
		for (int i = 0; i < listDescription.size(); i++) {
			Assert.assertTrue(listDescription.get(i).contains(str));
		}
	}

	public static void countProducers(SelectPage selectPage) {

		listProdusers = new TreeSet<>();
		WebElement lastPageV = selectPage.getlastPage();
		WebElement next = selectPage.getNext();
		List<WebElement> producersName = selectPage.getProdName();
		WebElement produserWall = selectPage.getProd();

		String[] show;
		show = ((WebElement) produserWall).getText().split(" ");

		for (String s : show) {

			if (s.matches("\\([0-9]+\\)") || s.equals("")
					|| s.equalsIgnoreCase("\n") || s.equalsIgnoreCase("скрыть")) {
				continue;
			} else {
				s = s.replace("остальные", "");
				s = s.replace("\n", "");
				listProdusers.add(s.toLowerCase());
			}

		}

		int t = 1;
		int lastPage = Integer.parseInt(lastPageV.getText());

		setOfProducers = new TreeSet<String>();
		while (t <= lastPage) {

			for (WebElement rows : producersName) {

				String strDescription = rows.getText();
				strDescription = strDescription.substring(0,
						strDescription.indexOf(" "));
				setOfProducers.add(strDescription.toLowerCase());
			}

			if (t != lastPage) {
				next.click();
			}
			t++;

		}
		Assert.assertTrue(listProdusers.containsAll(setOfProducers));
	}

}
