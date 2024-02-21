package com.framework.utilitites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.devtools.v109.layertree.model.StickyPositionConstraint;

public class XLUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String excelPath, String xlsheet) throws IOException {
		fi = new FileInputStream(excelPath);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;

	}

	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}

	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			data = "";
		}
		wb.close();
		fi.close();
		return data;
	}

	public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data)
			throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	public static String[][] getData(String excelSheetName)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		File file = new File(System.getProperty("user.dir") + "\\TestData\\ExcelData\\COnfig_File.xlsx");
		FileInputStream fileInput = new FileInputStream(file);
		Workbook workBook = WorkbookFactory.create(fileInput);
		Sheet SheetName = workBook.getSheet(excelSheetName);

		int totalRow = SheetName.getLastRowNum();
		System.out.println(totalRow);
		Row rowCells = SheetName.getRow(0);
		int totalCells = rowCells.getLastCellNum();
		System.out.println(totalCells);

		DataFormatter formatter = new DataFormatter();
		String testData[][] = new String[totalRow][totalCells];
		for (int i = 1; i <= totalRow; i++) {
			for (int j = 0; j < totalCells; j++) {
				testData[i - 1][j] = formatter.formatCellValue(SheetName.getRow(i).getCell(j));
				System.out.println(Arrays.deepToString(testData));

			}
		}
		return testData;

	}

//	   public static String[] getDataFromFirstColumn(String excelPath,String excelSheet )
//	            throws EncryptedDocumentException, InvalidFormatException, IOException {
//	        File file = new File(excelPath);
//	        FileInputStream fileInput = new FileInputStream(file);
//	        Workbook workBook = WorkbookFactory.create(fileInput);
//	        Sheet sheet = workBook.getSheet(excelSheet	);
//
//	        int totalRows = sheet.getLastRowNum();
//	        System.out.println(totalRows);
//
//	        DataFormatter formatter = new DataFormatter();
//	        String[] firstColumnData = new String[totalRows];
//	        for (int i = 1; i <= totalRows; i++) {
//	            // Assuming the data is in the first column (column index 0)
//	            firstColumnData[i - 1] = formatter.formatCellValue(sheet.getRow(i).getCell(0));
//	        }
//
//	        System.out.println(Arrays.toString(firstColumnData));
//
//	        return firstColumnData;
//	    }
//	   
//	   public static String[] getDataFromSecondColumn(String excelPath, String excelSheet)
//		        throws EncryptedDocumentException, InvalidFormatException, IOException {
//		    File file = new File(excelPath);
//		    FileInputStream fileInput = new FileInputStream(file);
//		    Workbook workBook = WorkbookFactory.create(fileInput);
//		    Sheet sheet = workBook.getSheet(excelSheet);
//
//		    int totalRows = sheet.getLastRowNum();
//		    System.out.println(totalRows);
//
//		    DataFormatter formatter = new DataFormatter();
//		    String[] secondColumnData = new String[totalRows];
//		    for (int i = 1; i <= totalRows; i++) {
//		        // Fetching data from the second column (column index 1)
//		        secondColumnData[i - 1] = formatter.formatCellValue(sheet.getRow(i).getCell(1));
//		    }
//
//		    System.out.println(Arrays.toString(secondColumnData));
//
//		    return secondColumnData;
//		}
	public static String[] getDataFromColumn(String excelPath, String excelSheet, int columnIndex)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		File file = new File(excelPath);
		FileInputStream fileInput = new FileInputStream(file);
		Workbook workBook = WorkbookFactory.create(fileInput);
		Sheet sheet = workBook.getSheet(excelSheet);

		int totalRows = sheet.getLastRowNum();
		System.out.println(totalRows);

		DataFormatter formatter = new DataFormatter();
		String[] columnData = new String[totalRows];
		for (int i = 1; i <= totalRows; i++) {
			// Fetching data from the specified column
			columnData[i - 1] = formatter.formatCellValue(sheet.getRow(i).getCell(columnIndex));
		}

		System.out.println("Data from column " + columnIndex + ": " + Arrays.toString(columnData));

		return columnData;
	}

	public static String[][] getDataFromAllColumns(String excelPath, String excelSheet)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		File file = new File(excelPath);
		FileInputStream fileInput = new FileInputStream(file);
		Workbook workBook = WorkbookFactory.create(fileInput);
		Sheet sheet = workBook.getSheet(excelSheet);

		int totalRows = sheet.getLastRowNum();
		int totalColumns = sheet.getRow(0).getLastCellNum();

		String[][] allColumnData = new String[totalColumns][totalRows];
		DataFormatter formatter = new DataFormatter();

		for (int colIndex = 0; colIndex < totalColumns; colIndex++) {
			for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
				// Fetching data from the current column
				allColumnData[colIndex][rowIndex - 1] = formatter
						.formatCellValue(sheet.getRow(rowIndex).getCell(colIndex));
			}
			System.out.println(
					"Data from column " + colIndex + ": " + java.util.Arrays.toString(allColumnData[colIndex]));
		}

		return allColumnData;
	}
}
