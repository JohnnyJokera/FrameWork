package com.epam.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.epam.config.Properti;

public class ExcelHelper {

	public static String[][] getDataArray(String fileName, String sheetName) {
		
		String[][] list;
		
			Sheet sheet1 = getSheet(fileName,sheetName);
			int columns = sheet1.getColumns();
			int rows = sheet1.getRows();
			System.out.println(columns+" "+rows);
			
			list = new String[rows][columns];
			for (int j = 0; j <columns ; j++) {
				for (int i = 0; i < rows; i++) {
					Cell cell = sheet1.getCell(j, i);
					list[i][j] = cell.getContents();
				}
			}
		return list;
	}
	

	private static Sheet getSheet(String fileName, String sheetName) {
		Workbook w = null;
		try {
			FileInputStream fileReader = new FileInputStream(new File(fileName));
			
			w = Workbook.getWorkbook(fileReader);
		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return w.getSheet(sheetName);
	}

	
}
