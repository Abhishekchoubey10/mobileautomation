package com.qa.climatetcentreapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.climatetcentreapp.utils.ElementUtil;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ProductListPage {

	private AndroidDriver driver;
	private ElementUtil eleutil;

	// 1. private by locators:
	private AppiumBy header = (AppiumBy) AppiumBy.accessibilityId("container header");

	// 2. public page const....
	public ProductListPage(AndroidDriver driver) {
			this.driver = driver;
			eleutil = new ElementUtil(driver);
		}
	
	public boolean isProductListPageHeaderExist() {
		return eleutil.doIsDisplayed(header);
	}
}
