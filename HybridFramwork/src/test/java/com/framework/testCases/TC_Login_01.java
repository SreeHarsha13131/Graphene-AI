package com.framework.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.pageObjects.LoginPage;

import freemarker.log.Logger;

public class TC_Login_01 extends BaseClass {

	@Test
	public void loginTest() throws IOException, InterruptedException {

		driver.get(baseURL);

		Thread.sleep(500);
		LoginPage lp = new LoginPage(driver);
		lp.setUsrName(username);

		lp.setPassword(password);

		lp.clickSubmit();

		String ti = driver.getTitle();

		Thread.sleep(500);
		System.out.println(ti);

		lp.getTitle();

		if (driver.getTitle().equals(ti)) {
			Assert.assertTrue(true);

		} else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);

		}
	}
}
