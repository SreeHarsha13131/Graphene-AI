package com.framework.testCases;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.framework.pageObjects.Constants;
import com.framework.pageObjects.EzyThemesPage;
import com.framework.pageObjects.LoginPage;
import com.framework.utilitites.NewExcelUtil;
import com.framework.utilitites.XLUtils;

@Test(testName = "New Project")
public class TC_EzyThemes_02 extends BaseClass {

//	private final String filePath1= Constants.TARGET_DATA_PATH+"Brian B.mp3";

	@Test
	public void ezyThemes()
			throws InterruptedException, AWTException, EncryptedDocumentException, InvalidFormatException, IOException {
		driver.get(baseURL);

		String filePath = Constants.TARGET_DATA_PATH;
		String excelData = Constants.EXCEL_FILE_PATH;

		XLUtils xLUtils = new XLUtils();

		NewExcelUtil newExcelUtil = new NewExcelUtil();
		LoginPage lp = new LoginPage(driver);
		EzyThemesPage ezy = new EzyThemesPage(driver);
		SoftAssert softassert = new SoftAssert();
		lp.setUsrName(username);

		lp.setPassword(password);

		lp.clickSubmit();

		String userName = ezy.getUserName();
		softassert.assertEquals(userName, "Welcome,");

		String mrTransAuto = ezy.getmRTranscriptsAutomationHeading();
		softassert.assertEquals(mrTransAuto, "MR Transcripts Automation");

		String createNewBtn = ezy.getcreateNewButtonGet();
		softassert.assertEquals(createNewBtn, "Create New Project");

		ezy.clickOnCreateNewButtonGet();

		String enterNameconcatenatedString = concatenateWithChangingNumber();
		System.out.println(enterNameconcatenatedString);
		Thread.sleep(500);
		ezy.enterName(enterNameconcatenatedString);
		Thread.sleep(500);
		ezy.clickCategoryName();
//		String[][] data=newExcelUtil.getExcelData(excelData,"files", driver);

//		for(int i=0;i< data.length-1;i++){
//			System.out.println(data[i][0].toString());
//		}\
		ezy.clickOnResearchTranscriptButton();
//		ezy.upLoadBrowse();
//		ezy.roboClick(excelFilePathAudioPdf);
		WebElement elementfileUpload = driver.findElement(By.xpath("//input[@id='file-upload']"));
		uploadFilesMethod(driver, docFilePath, elementfileUpload);
		Thread.sleep(500);
		ezy.scrollToElementJavaScript("(//button[@type='button'])[2]");
//		WebElement  createProjectbtn1=driver.findElement(By.xpath("((//button[@type='button'])[2]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[2]")));

//		ezy.waitForUploadToCompletelilanW();
//		Thread.sleep(2000);
//		ezy.waitForUploadToCompleteBrianB();
//		Thread.sleep(2000);
//
//		ezy.waitForUploadToCompleteJakeG();
//		Thread.sleep(2000);

		// String[][] data=newExcelUtil.getExcelData(excelData,"file");
		// for(int i=0;i< data.length;i++){
		// System.out.println(data[i]);
		// }

//		 ezy.waitForUploadToCompleteSeleniumNotes();
//		 ezy.waitForUploadToCompletePostmanCheatsheet();
//		 ezy.waitForUploadToCompleteJenkins();

		Thread.sleep(500);
		ezy.createProject();
		ezy.closeButton();

		ezy.enterAnalysisTopicshereText();

		String[] firstColumnData = xLUtils.getDataFromColumn(excelDataSheet, "Config.Data", 0);

		ezy.addMorePlaceholderField(firstColumnData);

		ezy.placeHolder1();

		ezy.placeHolder2();

		ezy.checkBoxTogglaBtn();

		ezy.checkBoxField(checkBoxField);

		ezy.checkBoxField1(checkBoxField);

//		ezy.placeHolder3();
//		Thread.sleep(1000);

		ezy.firstAddAreaOfInterest();
		Thread.sleep(500);

		String[] secondColumnData = xLUtils.getDataFromColumn(excelDataSheet, "Config.Data", 1);

		ezy.enterSegmentName(secondColumnData);

		Thread.sleep(500);

		ezy.processOutput();

		ezy.backToHomeBtn();

//		ezy.specifyAtLeast1valueTextFile();
//		Thread.sleep(1000);
//
//		ezy.firstAddMorePlaceholde();
	}

}
