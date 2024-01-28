package com.qa.climatetcentreapp.pages;

import com.qa.climatetcentreapp.utils.Constants;
import com.qa.climatetcentreapp.utils.ElementUtil;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

public class LoginPageAndriod {

	private AndroidDriver driver;
	private ElementUtil eleutil;

	// 1. private by locators:
	private AppiumBy openMenu = (AppiumBy) AppiumBy.accessibilityId("open menu");
	private AppiumBy login = (AppiumBy) AppiumBy.accessibilityId("menu item log in");
	private AppiumBy username = (AppiumBy) AppiumBy.accessibilityId("Username input field");
	private AppiumBy password = (AppiumBy) AppiumBy.accessibilityId("Password input field");
	private AppiumBy loginBtn = (AppiumBy) AppiumBy.accessibilityId("Login button");

	// 2. public page const....
	public LoginPageAndriod(AndroidDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}

	// 3. Open Menu link
	@Step("Check the open menu link in header")
	public boolean isOpenMenuLinkExist() {
		return eleutil.doIsDisplayed(openMenu);
	}

	// 4. Open Login page
	@Step("Open login page")
	public boolean openMenuLink() {
		if (isOpenMenuLinkExist()) {
			eleutil.doClick(openMenu);
			return true;
		}
		return false;
	}

	// 5. login page link
	@Step("Check the login page link in hamburger")
	public boolean isLoginLinkExist() {
		return eleutil.doIsDisplayed(login);
	}

	// 6. Open Login page
	@Step("Open login page link")
	public boolean openLoginPage() {
		if (isLoginLinkExist()) {
			eleutil.doClick(login);
			return true;
		}
		return false;
	}
	
	
	@Step("login to application with correct username {0} and password {1}")
	public HomePage doLogin(String un, String pwd) {
		if(isLoginLinkExist()){
			//eleutil.doClick(Login);
			eleutil.waitForElementToBeVisible(login, Constants.DEFAULT_TIME_OUT, 2000).click();;
		}
		eleutil.waitForElementToBeVisible(username, Constants.DEFAULT_TIME_OUT).sendKeys(un);
		eleutil.doSendKeys(password, pwd);
		eleutil.doClick(loginBtn);
		return new HomePage(driver);
	}

}
