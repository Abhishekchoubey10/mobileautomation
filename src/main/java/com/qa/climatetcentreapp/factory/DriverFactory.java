package com.qa.climatetcentreapp.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

	public Properties prop;
	public AndroidDriver driver;
	

	public AndroidDriver insit_driver(Properties prop) {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
		options.setDeviceName("Android Emulator");
		options.setApp(prop.getProperty("APP"));
		// options.setAppActivity("com.example.new_climat.MainActivity");
		// options.setAppPackage("com.example.new_climat");

		try {
			URL url = new URL(prop.getProperty("url"));
			driver = new AndroidDriver(url, options);
			Thread.sleep(6000);
		} catch (Exception exe) {
			System.out.println("Cause is :" + exe.getCause());
			System.out.println("Message is :" + exe.getMessage());
			exe.printStackTrace();
		}
	
	
	
	return driver;
}

public Properties insit_prop() {
	prop = new Properties();
	FileInputStream ip = null;

	try {
		ip = new FileInputStream("./src/test/resources/config/config.properties");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}

	try {
		prop.load(ip);
	} catch (IOException e) {
		e.printStackTrace();

	}

	return prop;
}
}
