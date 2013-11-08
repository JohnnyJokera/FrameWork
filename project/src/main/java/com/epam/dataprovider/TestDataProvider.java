package com.epam.dataprovider;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.epam.config.Properti;
import com.epam.helper.ExcelHelper;

public class TestDataProvider {

	@DataProvider(name = "baseDataProvider")
	public static Object[][] baseDataProvider(Method method) {

		String fileName = getDataFileName(method);
		String sheetName = method.getName();

		return ExcelHelper.getDataArray(fileName, sheetName);
	}

	private static String getDataFileName(Method method) {
		return Properti.getInputDataDir()+ method.getDeclaringClass().getSimpleName() + ".xls";
	}
}
