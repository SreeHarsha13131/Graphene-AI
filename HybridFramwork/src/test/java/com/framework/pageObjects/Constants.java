package com.framework.pageObjects;

import java.io.File;

import com.framework.testCases.BaseClass;

public class Constants extends BaseClass{
	
	 public static final String USER_DIRECTORY = System.getProperty("user.dir");
	 
	 public static final String TARGET_DATA_PATH = USER_DIRECTORY + File.separator + "TestData" + File.separator + "AudioVideoPdf" +File.separator;
	 public static final String EXCEL_FILE_PATH = USER_DIRECTORY + File.separator + "TestData" + File.separator + "ExcelData" +File.separator+ "COnfig_File.xlsx" +File.separator;



}
