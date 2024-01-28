package com.qa.climatetcentreapp.pages;

import com.qa.climatetcentreapp.utils.Constants;
import com.qa.climatetcentreapp.utils.ElementUtil;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

public class LoginPage {

	private AndroidDriver driver;
	private ElementUtil eleutil;
	String identifier = "myTextField";

	// 1. private by locators:
	//private AppiumBy email = (AppiumBy) AppiumBy.xpath(
		//	"//android.view.View[@content-desc=\"Login Email address* Password* Remember me\"]/android.widget.EditText[1]");
	private AppiumBy email = (AppiumBy) AppiumBy.accessibilityId(identifier);
	private AppiumBy password = (AppiumBy) AppiumBy.xpath(
			"//android.view.View[@content-desc=\"Login Email address* Password* Remember me\"]/android.widget.EditText[2]");
	private AppiumBy loginBtn = (AppiumBy) AppiumBy.accessibilityId("Log In");
	 
	// private Object component =
	// AppiumBy.xpath("//android.view.View[@content-desc=\"Login Email address*
	// Password* Remember me\"]/android.widget.EditText[1]");

	// 2. public page const....
	public LoginPage(AndroidDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}

	@Step("login to application with correct email {0} and password {1}")
	public HomePage doLogin(String un, String pwd) {
		// eleutil.doClick(Login);
		// component.getClass().toString();
		eleutil.waitForElementToBeVisible(email, Constants.DEFAULT_TIME_OUT).sendKeys(un);
		eleutil.doSendKeys(password, pwd);
		eleutil.doClick(loginBtn);
		return new HomePage(driver);
	}

}
