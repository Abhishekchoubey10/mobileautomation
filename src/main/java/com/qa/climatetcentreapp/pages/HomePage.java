package com.qa.climatetcentreapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.climatetcentreapp.utils.ElementUtil;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {

	private AndroidDriver driver;
	private ElementUtil eleutil;

	// 1. private by locators:
	private AppiumBy hamburger_menu = (AppiumBy) AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]");

	// 2. public page const....
	public HomePage(AndroidDriver driver) {
			this.driver = driver;
			eleutil = new ElementUtil(driver);
		}
	
	public boolean isProductListPageHeaderExist() {
		return eleutil.doIsDisplayed(hamburger_menu);
	}
}
