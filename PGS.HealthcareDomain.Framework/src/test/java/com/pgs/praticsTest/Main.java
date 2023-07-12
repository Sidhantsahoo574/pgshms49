package com.pgs.praticsTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Main {
	
	public Workbook book;
	public Sheet sheet;
	public Row row;
	public Cell cell;

	@Test(dataProvider = "storeData")
	public void test(String from,String to,String price) {
		System.out.println(from+" "+to+" "+price);
	}
	
	@DataProvider
	public Object [][] storeData() throws EncryptedDocumentException, InvalidFormatException, IOException{
		//System.out.println(sheet.getLastRowNum());
		//System.out.println(row.getLastCellNum());
		
		String [][] obj = new String[4][3];
		Main m1 = new Main();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				obj[i][j] = m1.fetchDataFromExcel(i, j);
			}
		}
		return obj;
		
	}

	
	public String fetchDataFromExcel(int r,int c) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/dataproviderSample.xlsx");
		book = WorkbookFactory.create(fis);
		sheet = book.getSheet("Sheet1");
//		lastRowNumber = sheet.getLastRowNum();
//		System.out.println(lastRowNumber);
		row = sheet.getRow(r);
//		lastCellNumber = row.getLastCellNum();
//		System.out.println(lastCellNumber);
		cell = row.getCell(c);
		String value = cell.toString();

		return value;
	}
	
//	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
//		FileInputStream fis = new FileInputStream("./src/test/resources/dataproviderSample.xlsx");
//		Workbook book = WorkbookFactory.create(fis);
//		Sheet sheet = book.getSheet("Sheet1");
//		int lastRowNumber = sheet.getLastRowNum();
//		System.out.println(lastRowNumber);
//		Row row = sheet.getRow(2);
//		int lastCellNumber = row.getLastCellNum();
//		System.out.println(lastCellNumber);
//		Cell cell = row.getCell(2);
//		String value = cell.toString();
//		System.out.println(value);
//	}


}
