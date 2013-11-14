package com.epam.helper;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.epam.pages.MicroWave;
import com.epam.pages.SelectPage;

public class CompareFilterHelper extends TestBaseHelper{

	private static List<MicroWave> wave = new ArrayList<>();
	private static List<MicroWave> wave2 = new ArrayList<>();

	public static void getMicrowave(SelectPage selectPage) {

		List<WebElement> microwavesRows = selectPage.getpropertiesRows();

		for (WebElement row : microwavesRows) {
			wave.add(covertrowToWave(row));
			System.out.println(row.getText());
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (WebElement row : microwavesRows) {
			wave2.add(converFirstRow(row));
		}

		System.out.println(wave.equals(wave2));
		Assert.assertFalse(wave.equals(wave2));
		
	}

	private static MicroWave covertrowToWave(WebElement row) {
		List<WebElement> cells = row.findElements(By.tagName("td"));
		return new MicroWave().withFirstName(cells.get(2).getText());
	}

	private static MicroWave converFirstRow(WebElement row) {
		List<WebElement> cells = row.findElements(By.tagName("td"));
		return new MicroWave().withFirstName(cells.get(1).getText());
	}

}
