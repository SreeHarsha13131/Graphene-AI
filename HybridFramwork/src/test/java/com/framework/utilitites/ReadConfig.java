package com.framework.utilitites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exceptio is" + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getUserName() {
		String username = pro.getProperty("username");
		return username;
	}

	public String getPassword() {
		String pswrd = pro.getProperty("password");
		return pswrd;
	}

	public String fileUploadVidAudio() {
		String videoAudio = pro.getProperty("videoAudio");
		return videoAudio;
	}

	public String fileUploadDoc() {
		String researchTranscripts = pro.getProperty("researchTranscripts");
		return researchTranscripts;
	}

	public String categorName() {
		String categoryname = pro.getProperty("category");
		return categoryname;
	}

	public String beautyPerception() {
		String beautyPerceptionKey = pro.getProperty("beautyPerception");
		return beautyPerceptionKey;
	}

	public String cosmeticsGeneral() {
		String cosmeticsGeneralKey = pro.getProperty("cosmeticsGeneral");
		return cosmeticsGeneralKey;
	}

	public String cosmeticsConsupmtion() {
		String cosmeticsConsupmtionKey = pro.getProperty("cosmeticsConsupmtion");
		return cosmeticsConsupmtionKey;
	}

	public String locationSingapore() {
		String locationSingaporeKey = pro.getProperty("locationSingapore");
		return locationSingaporeKey;
	}

	public String ageGroup() {
		String ageGroupKey = pro.getProperty("ageGroup");
		return ageGroupKey;
	}

	public String countryName() {
		String countryNameKay = pro.getProperty("countryName");
		return countryNameKay;
	}

	public String excelPath() {
		String excelPath = pro.getProperty("filePath");
		return excelPath;
	}

	public String excelDataSheet() {
		String excelDataSheetPath = pro.getProperty("excelDataSheetPath");
		return excelDataSheetPath;
	}

	public String checkBoxFieldEnter() {
		String checkBoxField = pro.getProperty("checkBoxField");
		return checkBoxField;
	}

	public String docFilePath() {
		String docFilePath = pro.getProperty("docFilePath");
		return docFilePath;
	}

	public String videoFilePath() {
		String videoFilePath = pro.getProperty("videoFilePath");
		return videoFilePath;
	}

}
