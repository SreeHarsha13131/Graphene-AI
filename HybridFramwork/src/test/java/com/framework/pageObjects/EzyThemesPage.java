package com.framework.pageObjects;

import java.awt.event.KeyEvent;
import java.io.FileInputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import com.framework.utilitites.NewExcelUtil;
import com.framework.utilitites.ReadConfig;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.testCases.BaseClass;

public class EzyThemesPage extends BaseClass {

	public EzyThemesPage(WebDriver driver) {
		driver = driver;
		PageFactory.initElements(driver, this);

	}

	WebDriver driver;

//	NewExcelUtil newExcelUtil = new NewExcelUtil();
	ReadConfig readConfig = new ReadConfig();
	NewExcelUtil newExcelUtil = new NewExcelUtil();

	@FindBy(xpath = "//span[@class='w-[315px] truncate ']")
	@CacheLookup
	WebElement validateUser;

	@FindBy(xpath = "//span[.='MR Transcripts Automation']")
	@CacheLookup
	WebElement mRTranscriptsAutomationHeading;

	@FindBy(xpath = "//span[.='Create New Project']")
	@CacheLookup
	WebElement createNewButton;

	@FindBy(id = "outlined-basic")
	@CacheLookup
	WebElement enterName;

	@FindBy(xpath = "//label[@for='file-upload']") //
	@CacheLookup
	WebElement upLoadBrowse;

	@FindBy(xpath = "(//div[contains(@class,'MuiInputBase')]//input)[2]")
	@CacheLookup
	WebElement categoryName;

	@FindBy(xpath = "(//button[@type='button'])[2]") //
	@CacheLookup
	WebElement createProjectBtn;// (//span[@class='MuiTouchRipple-root css-w0pj6f'])[2]

	@FindBy(xpath = "//input[@type='radio' and @value='audio']")
	@CacheLookup
	WebElement videoAudio;

	@FindBy(xpath = "//input[@type='radio' and @value='transcripts']")
	@CacheLookup
	WebElement researchTranscripts;

	@FindBy(xpath = "//span[text()='Lilan W.mp3']/..//span[text()='100']")
	@CacheLookup
	WebElement lilanW;

	@FindBy(xpath = "//span[text()='Jake G.mp3']/..//span[text()='100']")
	@CacheLookup
	WebElement jakeG;

	@FindBy(xpath = "//span[text()='Brian B.mp3']/..//span[text()='100']")
	@CacheLookup
	WebElement brianB;

	@FindBy(xpath = "//span[text()='Selenium_Notes.pdf']/..//span[text()='100']")
	@CacheLookup
	WebElement seleniumNotes;

	@FindBy(xpath = "//span[text()='Postman Cheatsheet.pdf']/..//span[text()='100']")
	@CacheLookup
	WebElement postmanCheatsheet;

	@FindBy(xpath = "//span[text()='Jenkins.pdf']/..//span[text()='100']")
	@CacheLookup
	WebElement jenkins;

	@FindBy(xpath = "//span[@class='text-lg flex items-center gap-2  font-semibold text-gray-500']")
	@CacheLookup
	WebElement enterAnalysisTopicshere;

	@FindBy(xpath = "//button[.='Close']")
	@CacheLookup
	WebElement closeBtn;

	@FindBy(xpath = "//input[@placeholder='Enter Analysis Topics here']")
	@CacheLookup
	WebElement addMorePlaceholder;

	@FindBy(xpath = "(//input[@placeholder='Enter City/Country'])[1]")
	@CacheLookup
	WebElement placeHolder1;

	@FindBy(xpath = "(//input[@placeholder='Enter City/Country'])[2]")
	@CacheLookup
	WebElement placeHolder2;

	@FindBy(xpath = "(//input[@placeholder='Enter City/Country'])[3]")
	@CacheLookup
	WebElement placeHolder3;

	@FindBy(xpath = "//button[.='Add Areas of Interest']")
	@CacheLookup
	WebElement AddAreaOfInterestBtn;

	@FindBy(xpath = "//input[@placeholder='Enter section name (e.g., Brand/Product/Services/Themes)']")
	@CacheLookup
	WebElement enterSegmentName;

	@FindBy(xpath = "//input[@placeholder='Specify at least 1 value']")
	@CacheLookup
	WebElement specifyAtLeast1valueTextFile;

	@FindBy(xpath = "//input[@placeholder='Add more']")
	@CacheLookup
	WebElement firstAddMorePlaceholde;

//	@FindBy(xpath = "(//span[@class='MuiTouchRipple-root css-w0pj6f']/preceding:: button[@type='button'])[3]")
//	@CacheLookup
//	WebElement secondAddAreaOfInterestBtn;

	@FindBy(xpath = "(//input[@placeholder='Add more'])[2]")
	@CacheLookup
	WebElement secondAddMorePlaceholde;

//	@FindBy(xpath = "(//span[@class='MuiTouchRipple-root css-w0pj6f']/preceding:: button[@type='button'])[7]")
//	@CacheLookup
//	WebElement thirdAddAreaOfInterestBtn;

	@FindBy(xpath = "//button[@class='w-full rounded-md']")
	@CacheLookup
	WebElement processOutputBtn;

	@FindBy(xpath = "(//div[.='Back to home'])[2]")
	@CacheLookup
	WebElement backToHome;

	@FindBy(xpath = "//input[@type='checkbox']")
	@CacheLookup
	WebElement checkBoxToggla;

	@FindBy(xpath = "(//input[@placeholder='Enter Male/Loyalist/White collar'])[1]")
	@CacheLookup
	WebElement checkBoxField;

	@FindBy(xpath = "(//input[@placeholder='Enter Male/Loyalist/White collar'])[2]")
	@CacheLookup
	WebElement checkBoxField1;

	public String getUserName() {
		return validateUser.getText();

	}

	public String getmRTranscriptsAutomationHeading() {
		return mRTranscriptsAutomationHeading.getText();

	}

	public String getcreateNewButtonGet() {
		return createNewButton.getText();

	}

	public void clickOnCreateNewButtonGet() {
		if (createNewButton != null) {
			createNewButton.click();
		}
	}

	public void enterName(String testingFlowName) throws InterruptedException {
		if (enterName != null) {
			enterName.click();
			enterName.sendKeys(testingFlowName);
		}
	}

	public void clickCategoryName() {
		if (categoryName != null) {
			categoryName.click();
			categoryName.sendKeys(categorName);
		}
	}

	public void clickOnResearchTranscriptButton() {
		if (researchTranscripts != null)
			researchTranscripts.click();
	}

	public void waitTillCreateProjectBtnEnabled() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[2]")));
	}

	public void upLoadBrowse() throws InterruptedException {
		if (upLoadBrowse != null) {
			upLoadBrowse.click();

		}
	}

//	 public void uploadAllFiles(String excelFilePathAudioPdf, String baseFile) throws
//	 InterruptedException {
//	 LinkedHashSet<String> set = new LinkedHashSet<>();
//	
//	 String [][] data = newExcelUtil.getExcelData(excelFilePathAudioPdf, "files", driver);
//	
//	 for (int i = 0; i < data.length; i++) {
//	 String path1 = data[i][0];
//	 String filePath = baseFile + path1;
//	 set.add(filePath);
//	 }
//	
//	 // Convert the set to an ArrayList
//	 ArrayList<String> arrayList = new ArrayList<>(set);
//	 System.out.println(arrayList);
//	 String result = arrayList.toString();
//	 // Call the method and pass the ArrayList
//	 uploadVideoAudioDocuments(result);
//	 }

//	public void uploadVideoAudioDocuments(String pathOfFile) {
//		try {
//		if (pathOfFile.contains("mp3")) {
//			upLoadBrowse.sendKeys(pathOfFile);
//		} else {
//			clickOnResearchTranscriptButton();
//			Thread.sleep(5000);
//
//			upLoadBrowse.sendKeys(pathOfFile);
//			Thread.sleep(5000);
//		}
//		}catch(Exception e) {
//			System.out.println(e);
//		}
//	}

	public void createProject() throws InterruptedException {

		if (createProjectBtn != null) {
			createProjectBtn.click();
			Thread.sleep(1000);

		}
	}

	public void enterAnalysisTopicshereText() {
		if (enterAnalysisTopicshere != null) {
			String enterAnalysisTopicshereText = enterAnalysisTopicshere.getText();
			System.out.println(enterAnalysisTopicshereText);
		}
	}

	public void closeButton() {
		if (closeBtn != null) {
			closeBtn.click();
		}
	}

	public void addMorePlaceholderField(String[] stringValue) throws InterruptedException {
		if (addMorePlaceholder != null) {

//			String[] result = stringValue.split(",");
			for (String value : stringValue) {
				addMorePlaceholder.sendKeys(value);
				addMorePlaceholder.sendKeys(Keys.ENTER);
//				Actions actions = new Actions(driver);
//				actions.sendKeys(addMorePlaceholder, Keys.ENTER).build().perform();

			}

		}
	}

	public void placeHolder1() throws InterruptedException {
		if (placeHolder1 != null) {

			placeHolder1.click();
			placeHolder1.sendKeys(countryNameValue);
			Thread.sleep(500);

		}
	}

	public void placeHolder2() throws InterruptedException {
		if (placeHolder2 != null) {

			placeHolder2.click();
			placeHolder2.sendKeys(countryNameValue);
			Thread.sleep(500);
		}
	}

//	public void placeHolder3() throws InterruptedException {
//
//		if (placeHolder3 != null) {
//			Thread.sleep(1000);
//			placeHolder3.click();
//			placeHolder3.sendKeys(countryNameValue);
//			Thread.sleep(3000);
//		}
//	}

	public void firstAddAreaOfInterest() {
		if (AddAreaOfInterestBtn != null) {
			AddAreaOfInterestBtn.click();
		}
	}

//	public void enterSegmentName(String[] stringValue) throws InterruptedException {
//		if (enterSegmentName != null) {
//			for (String value : stringValue) {
//				for (int i = 0; i <= 1; i++) {
//					enterSegmentName.sendKeys(value);
//					enterSegmentName.sendKeys(Keys.ENTER);
//					Thread.sleep(1000);
//					break;
//				}
//				for (int i = 0; i <= 1; i++) {
//					specifyAtLeast1valueTextFile.click();
//					specifyAtLeast1valueTextFile.sendKeys(value);
//					specifyAtLeast1valueTextFile.sendKeys(Keys.ENTER);
//					Thread.sleep(1000);
//					break;
//				}
//				firstAddMorePlaceholde.sendKeys(value);
//				firstAddMorePlaceholde.sendKeys(Keys.ENTER);
//				Thread.sleep(2000);
//			}
//		}
//	}

	public void enterSegmentName(String[] stringValue) throws InterruptedException {
		if (enterSegmentName != null && specifyAtLeast1valueTextFile != null && firstAddMorePlaceholde != null) {
			// Use the first cell value for enterSegmentName
			enterSegmentName.sendKeys(stringValue[0]);
			enterSegmentName.sendKeys(Keys.ENTER);
			Thread.sleep(100);

			// Use the second cell value for specifyAtLeast1valueTextFile
			specifyAtLeast1valueTextFile.click();
			specifyAtLeast1valueTextFile.sendKeys(stringValue[1]);
			specifyAtLeast1valueTextFile.sendKeys(Keys.ENTER);

			Thread.sleep(100);

			// Use the third cell value for firstAddMorePlaceholde
			firstAddMorePlaceholde.sendKeys(stringValue[2]);
			firstAddMorePlaceholde.sendKeys(Keys.ENTER);
			Thread.sleep(100);

			// Use the remaining cell values for firstAddMorePlaceholde
			for (int i = 3; i < stringValue.length; i++) {
				firstAddMorePlaceholde.sendKeys(stringValue[i]);
				firstAddMorePlaceholde.sendKeys(Keys.ENTER);
				Thread.sleep(100);

			}
		}
	}

	public void processOutput() {
		if (processOutputBtn != null) {
			processOutputBtn.click();
		}
	}

	public void backToHomeBtn() {
		if (backToHome != null) {
			backToHome.click();
		}
	}

	public void checkBoxTogglaBtn() {
		if (checkBoxToggla != null) {
			checkBoxToggla.click();

		}
	}

	public void checkBoxField(String fieldValue) {
		if (checkBoxField != null) {
			checkBoxField.click();
			checkBoxField.sendKeys(fieldValue);
		}
	}

	public void checkBoxField1(String fieldValue1) {
		if (checkBoxField1 != null) {
			checkBoxField1.click();
			checkBoxField1.sendKeys(fieldValue1);
		}
	}

//	public void specifyAtLeast1valueTextFile() {
//		if (specifyAtLeast1valueTextFile != null) {
//			specifyAtLeast1valueTextFile.click();
//			specifyAtLeast1valueTextFile.sendKeys(null);
//		}
//	}

//	public void firstAddMorePlaceholde() {
//		if (firstAddMorePlaceholde != null) {
//			firstAddMorePlaceholde.click();
//			firstAddMorePlaceholde.sendKeys(null);
//
//		}
//	}
//
//	public void secondAddAreaOfInterestBtn() {
//		if (secondAddAreaOfInterestBtn != null) {
//			secondAddAreaOfInterestBtn.click();
//		}
//	}
//
//	public void secondAddMorePlaceholde() {
//		if (secondAddMorePlaceholde != null)
//			secondAddMorePlaceholde.click();
//		secondAddMorePlaceholde.sendKeys(null);
//	}
//
//	public void thirdAddAreaOfInterestBtn() {
//		if (thirdAddAreaOfInterestBtn != null) {
//			thirdAddAreaOfInterestBtn.click();
//			thirdAddAreaOfInterestBtn.sendKeys(null);
//		}
//	}
}
