package com.framework.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Desktop.Action;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.framework.utilitites.ReadConfig;

import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForField.Read;

public class BaseClass {

	public static WebDriver driver;

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	// public String videoFileUpload =
	// readconfig.fileUploadVidAudio();//fileUploadVidAudio
	// public String docUpload=readconfig.fileUploadDoc();
	public String categorName = readconfig.categorName();
	public String beautyPerceptionValue = readconfig.beautyPerception();
	public String countryNameValue = readconfig.countryName();
	public String excelFilePathAudioPdf = readconfig.excelPath();
	public String excelDataSheet = readconfig.excelDataSheet();

	public String checkBoxField = readconfig.checkBoxFieldEnter();// docFilePath
	public String docFilePath = readconfig.docFilePath();// videoFilePath
	public String videoFilePath = readconfig.videoFilePath();

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		// System.setProperty("webdriver.chrome.driver","//C:/Users/HP/workspace/frameWork/Driver/chromedriver.exe");//"//C:/Users/HP/workspace/frameWork/Driver/chromedriver.exe"
		// System.setProperty("webdriver.chrome.driver",
		// System.getProperty("user.dir"+"//Driver//chromedriver.exe"));

		if (br.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./Driver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless"); 
			options.setBinary("C:\\Users\\DELL\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
			driver = new ChromeDriver(options);
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "./Driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", "./Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(baseURL);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public String randomestring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

	// Define a constant part of the string
	public String concatenateWithChangingNumber() {
		final String CONSTANT_PART = "[TestingFlow].v_";
		// Generate a random number
		Random random = new Random();
		int randomNumber = random.nextInt(100) + 1; // Generates a random number between 1 and 100

		// Concatenate the constant part with the random number
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = currentDate.format(formatter);

		String result = CONSTANT_PART + randomNumber + "-" + formattedDate;
		return result;
	}

	public void roboClick(String stringValue) throws AWTException {
		Robot robot = new Robot();
		robot.delay(1000);
		StringSelection ss = new StringSelection(stringValue);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_A);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void moveToElement(WebDriver driver, WebElement ele) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele);
	}

	protected void scrollDown() {
		JavascriptExecutor javascript = (JavascriptExecutor) this.driver;
		javascript.executeScript("window.scrollTo(0, document.body.scrollHeight)", new Object[] { "" });
	}

	protected void scrollToElementJavaScript(String propKey) {
		By by = (By.xpath(propKey));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(arguments[1]);",
				new Object[] { this.driver.findElement(by), false });
	}

	public void clickEnter(WebElement elementToclick) {
		Actions actions = new Actions(driver);
		actions.click(elementToclick).build().perform();
	}

	public static void uploadFilesMethod(WebDriver driver, String folderPath, WebElement fileInputElement) {
		// Find the file input element
		// WebElement fileInputElement =
		// driver.findElement(By.xpath("//input[@type='file']"));

		// Specify the directory containing the files
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(fileInputElement));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileInputElement);
		File folder = new File(folderPath);

		// Get the list of files from the directory
		File[] files = folder.listFiles();

		// Upload each file
		String filePath = "";
		for (int i = 0; i < files.length; i++) {
			filePath += (i != 0 ? "\n" : "") + files[i].getAbsolutePath();
		}
		System.out.println(filePath);
		fileInputElement.sendKeys(filePath);

	}

	// Optionally, perform actions after file upload (e.g., submitting a form)
	// For example, if the file input is within a form:
	// fileInputElement.findElement(By.xpath("./ancestor::form")).submit();
}
