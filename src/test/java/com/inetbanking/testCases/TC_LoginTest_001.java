package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	private static Logger log = LogManager.getLogger(TC_LoginTest_001.class);
	@BeforeTest
	public static void initalize() throws IOException {
		driver=setup();
		
	}

	@Test(dataProvider = "getData")
	public static void LoginTest(String uname, String psw) throws Exception {
		driver.get(prop.getProperty("url"));
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName().sendKeys(uname);
		log.info("entered username");
		lp.setPassword().sendKeys(psw);
		log.info("entered password");
	   lp.clickSubmit().click();
		log.info("clicked on submit btn");
		Assert.assertEquals(driver.getTitle(), "Login | Salesforce3623");
		log.fatal("title verifiation");
		
	}
	@Test
	public static void closing() {
		driver.close();
		log.debug("close the windows");
	}

	}
