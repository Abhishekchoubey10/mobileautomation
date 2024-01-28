package com.qa.climatetcentreapp.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.qa.climatetcentreapp.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginPageTest extends BaseTest{

	@Description("login Test with correct username and correct password.....")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority =1)
	public void loginTest() {
		homepage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homepage.isProductListPageHeaderExist());
	}
	
	
}
