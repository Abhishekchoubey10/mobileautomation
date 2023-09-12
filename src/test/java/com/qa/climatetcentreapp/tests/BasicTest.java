package com.qa.climatetcentreapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.climatetcentreapp.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class BasicTest extends BaseTest{

	@Description("check open menu link Test.....")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority =1)
	public void openMenuPageLinkTest() {
		Assert.assertTrue(loginPage.isOpenMenuLinkExist());
	}
	
	@Description("Open hamburger menu Test...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority =2)
	public void openmenuPageTest() {
		Assert.assertTrue(loginPage.openMenuLink());
	}
	
	@Description("check login link Test.....")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority =3)
	public void loginPageLinkTest() {
		Assert.assertTrue(loginPage.isLoginLinkExist());
	}
	
	@Description("Open login page Test...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority =4)
	public void openloginPageTest() {
		Assert.assertTrue(loginPage.openLoginPage());
	}
	
	
	@Description("login Title Test with correct username and correct password.....")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority =5)
	public void loginTest() {
		prolistpage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(prolistpage.isProductListPageHeaderExist());
	}
	
	
}
