package com.gorilladesk.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.gorillaDesk.user.UserCalendarPageObject;
import pageObject.gorillaDesk.user.UserLogInPageObject;

public class Login extends BaseTest {
	
	private WebDriver driver;
	private String userEmailAddress, userEmailAddressWrongFormat, userEmailAddressNotRegister, Password, WrongPassword;
	// Declare (Khai bao)
	// BasePage: class
	// basePage: object
	private String projectPath = System.getProperty("user.dir");
	private UserLogInPageObject userLogInPage;
	private UserCalendarPageObject userCalendarPage;
	
	// Multiple browser
	@Parameters({ "browser", "enviroment" })
	@BeforeClass
	public void beforeClass(String browserName, String enviromentName) {
		// Goi den khoi tao driver tuong ung voi browser name
		driver = getBrowserDriver(browserName, enviromentName);
		System.out.print(projectPath);
		userLogInPage = PageGeneratorManager.getUserLogInPage(driver);
		userCalendarPage = PageGeneratorManager.getUserCalenderPage(driver); 
		// Initial (Khoi tao)
		// Encapsulation (Dong goi)
		userEmailAddressNotRegister = "afc" + generateFakeNumber() + "@gmail.com";
		userEmailAddressWrongFormat = "admin@";
		userEmailAddress = "nlsoft";
		WrongPassword = "123456";
		Password = "gdesk.2022";
	}

	@Test
	public void TC_1_Login_With_Emty_Data() {
		userLogInPage.clickToLogInButton();
		Assert.assertEquals(userLogInPage.getErrorUser(), "Username can't be blank");
		Assert.assertEquals(userLogInPage.getErrorPassword(), "Password can't be blank");
	}

	@Test
	public void TC_2_Login_With_Invalid_Email() {
		userLogInPage.inputEmailTextbox(userEmailAddressWrongFormat);
		userLogInPage.inputPasswordTextbox(Password);
		userLogInPage.clickToLogInButton();
		Assert.assertEquals(userLogInPage.getErrorEmailInvaild(), "Wrong format email");
	}

	@Test
	public void TC_3_Login_With_Email_Not_Register() {
		userLogInPage.inputEmailTextbox(userEmailAddressNotRegister);
		userLogInPage.inputPasswordTextbox(Password);
		userLogInPage.clickToLogInButton();
		Assert.assertEquals(userLogInPage.getErrorEmailNotRegister(), "Oops! Incorrect username or password.");
	}

	@Test
	public void TC_4_Login_With_Invalid_Password() {
		userLogInPage.clearPasswordTextbox();
		userLogInPage.inputEmailTextbox(userEmailAddress);
		userLogInPage.clickToLogInButton();
		Assert.assertEquals(userLogInPage.getErrorPassword(), "Password can't be blank");
	}

	@Test
	public void TC_5_Login_With_Wrong_Password() {
		userLogInPage.inputEmailTextbox(userEmailAddress);
		userLogInPage.inputPasswordTextbox(WrongPassword);
		userLogInPage.clickToLogInButton();
		Assert.assertEquals(userLogInPage.getErrorEmailInvaild(), "Password must have 7 characters");
	}

	@Test
	public void TC_6_Login_Success() {
		userLogInPage.inputEmailTextbox(userEmailAddress);
		userLogInPage.inputPasswordTextbox(Password);
		userCalendarPage = userLogInPage.clickToLogInButton();
		Assert.assertEquals(userCalendarPage.getTitleCalendarPage(), "Calendar");
	}

	// Customer close browser/ driver
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
