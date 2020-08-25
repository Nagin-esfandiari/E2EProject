package com.inetbanking.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class BaseClass {
	public static  WebDriver driver;
	public static Properties prop;

	
	@BeforeClass
	public static WebDriver setup() throws IOException {
	
		File src = new File(System.getProperty("user.dir") + "\\Configuration\\config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);

		String brows=prop.getProperty("browser");
		if ( brows.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (brows.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (brows.equals("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		return driver;
		}


	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];

		data[0][0] = "sarah@email.com";
		data[0][1] = "seleniumjava321";

		data[1][0] = "alex@email.com";
		data[1][1] = "seleniumpython321";

		data[2][0] = "ali@email.com";
		data[2][1] = "seleniumc##423";

		return data;
	}

	public String getScreenshot(WebDriver driver, String path) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String picPath = System.getProperty("user.dir") + "\\reports\\" + path + ".png";
		FileUtils.copyFile(source, new File(picPath));
	   return picPath;
	}

}
