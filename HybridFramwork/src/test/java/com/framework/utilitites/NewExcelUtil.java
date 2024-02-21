package com.framework.utilitites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.framework.testCases.BaseClass;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewExcelUtil extends BaseClass {

	public static final String CURRENT_PATH = System.getProperty("user.dir");
	public static final String TEST_DATA_PATH = CURRENT_PATH + "src/test/java/com/framework/testData/COnfig_File.xlsx";
	public static final String FILE_EXTENSION = TEST_DATA_PATH.substring(TEST_DATA_PATH.lastIndexOf("."));

	private static Workbook book;
	private static Sheet sheet;

	public NewExcelUtil() {
		super();
	}

	// method to get test data from Excel
	// public static Object[][] getTestData(String Config_Data) {
//        try (FileInputStream file = new FileInputStream(TEST_DATA_PATH)) {
//            initializeWorkbook(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException | InvalidFormatException e) {
//            e.printStackTrace();
//        }
//
//        sheet = book.getSheet(Config_Data);
//
//        int rowCount = sheet.getLastRowNum();
//        int colCount = sheet.getRow(0).getLastCellNum();
//
//        Object[][] data = new Object[rowCount][colCount];
//
//        for (int i = 0; i < rowCount; i++) {
//            for (int k = 0; k < colCount; k++) {
//                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
//            }
//        }
//
//        return data;
//    }
//
//    private static void initializeWorkbook(FileInputStream file) throws IOException, InvalidFormatException {
//        if (FILE_EXTENSION.equals(".xls")) {
//            book = new HSSFWorkbook(file);
//        } else if (FILE_EXTENSION.equals(".xlsx")) {
//            book = new XSSFWorkbook(file);
//        }
//    }
//    public static String[][] getExcelData(String excelPath, String sheetName) {
//        String[][] arrayExcelData = null;
//        try (FileInputStream fis = new FileInputStream(excelPath);
//             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//            XSSFSheet sheet = workbook.getSheet(sheetName);
//            int totalNoOfCols = sheet.getRow(1).getLastCellNum();
//            int totalNoOfRows = sheet.getLastRowNum() + 1;
//            arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];
//            for (int i = 1; i < totalNoOfRows; i++) {
//                XSSFRow row = sheet.getRow(i);
//                for (int j = 0; j < totalNoOfCols; j++) {
//                    arrayExcelData[i - 1][j] = row.getCell(j).getStringCellValue();
//                }
//            }
//        } catch (FileNotFoundException fnException) {
//            fnException.printStackTrace();
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        } catch (NullPointerException exception) {
//            exception.printStackTrace();
//        }
//        return arrayExcelData;
//    }
	public String[][] getExcelData(String excelPath, String sheetName, WebDriver driver) {
		String[][] arrayExcelData = null;
		try (FileInputStream fis = new FileInputStream(excelPath); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int totalNoOfCols = sheet.getRow(1).getLastCellNum();
			int totalNoOfRows = sheet.getLastRowNum() + 1;
			arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];
			for (int i = 1; i < totalNoOfRows; i++) {
				XSSFRow row = sheet.getRow(i);
				for (int j = 0; j < totalNoOfCols; j++) {
					arrayExcelData[i - 1][j] = getCellValue(row.getCell(j), driver);
				}
			}
		} catch (FileNotFoundException fnException) {
			fnException.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} catch (NullPointerException exception) {
			exception.printStackTrace();
		}
		return arrayExcelData;
	}

	private String getCellValue(XSSFCell cell, WebDriver driver) {
		int attempts = 0;
		while (attempts < 5) {
			try {
				return cell.getStringCellValue();
			} catch (StaleElementReferenceException e) {
				System.out.println("StaleElementReferenceException occurred in getCellValue. Retrying...");
			}
			attempts++;
		}
		// If the attempts are exhausted and the element is still stale, handle the
		// failure.
		System.out.println("Failed to get cell value after multiple attempts.");
		return ""; // or throw an exception
	}
}
