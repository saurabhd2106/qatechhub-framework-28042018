package test;

import commonLibs.utils.ExcelDriver;

public class TestExcelDriver {

	public static void main(String[] args) {
		try {
			String sFilename = System.getProperty("user.dir") + "/outputFile/TestData.xlsx";
			String sSheetName = "TestData";
			
			ExcelDriver excelDriver = new ExcelDriver();

			excelDriver.createExcelWorkbook(sFilename);
			
			excelDriver.openExcelWorkbook(sFilename);
			
			excelDriver.createSheet(sSheetName);
			
			excelDriver.setCellData(sSheetName, 1, 1, "Saurabh");
			excelDriver.setCellData(sSheetName, 1, 2, "Dhingra");
			
			excelDriver.setCellData(sSheetName, 2, 1, "Abha");
			excelDriver.setCellData(sSheetName, 2, 2, "Pandey");
			
			excelDriver.setCellData(sSheetName, 3, 1, "Renu");
			excelDriver.setCellData(sSheetName, 3, 2, "John");
			
			excelDriver.save();
			
			excelDriver.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
