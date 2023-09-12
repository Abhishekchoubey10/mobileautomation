package com.qa.climatetcentreapp.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.climatetcentreapp.factory.DriverFactory;
import com.qa.climatetcentreapp.pages.LoginPage;
import com.qa.climatetcentreapp.pages.ProductListPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import java.net.URL;

public class BaseTest {
	public AndroidDriver driver;
	public DriverFactory df;
	public Properties prop;
	public LoginPage loginPage;
	public ProductListPage prolistpage;

	public SoftAssert softAssert;

	@BeforeTest
	public void setup() {

		df = new DriverFactory();
		prop = df.insit_prop();
		driver = df.insit_driver(prop);

		softAssert = new SoftAssert();
		loginPage = new LoginPage(driver);

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
