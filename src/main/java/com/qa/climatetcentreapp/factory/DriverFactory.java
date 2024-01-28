package com.qa.climatetcentreapp.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.climatetcentreapp.utils.Constants;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

	private static final Duration[] P = null;
	public Properties prop;
	public static AndroidDriver driver;
	

	@SuppressWarnings("null")
	public AndroidDriver insit_driver(Properties prop) {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
		options.setDeviceName("Android Emulator");
		options.setApp(prop.getProperty("APP"));
		options.setAppWaitForLaunch(false);
		options.setAutoWebviewTimeout(Constants.DURATION_TIME_OUT);
		options.setAppActivity("com.cybrain.climateApp.MainActivity");
		options.setAppPackage("com.cybrain.climateApp");

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

public static String getScreenshot() {
File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";

File Destination = new File(path);
try {
		FileUtil.copyFile(srcFile, Destination);//
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return path;
}
}
