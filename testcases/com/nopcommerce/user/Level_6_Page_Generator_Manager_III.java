package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_6_Page_Generator_Manager_III extends BaseTest {
	// Multiple browser
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		// Goi den khoi tao driver tuong ung voi browser name

		driver = getBrowserDriver(browserName);

		System.out.print(projectPath);

		homePage = PageGeneratorManager.getUserHomePage(driver);
		// Initial (Khoi tao)
		// Encapsulation (Dong goi)
		firstName = "Devtest";
		lastName = "Phuc Phung";
		invalidEmail = "devtest@gmail.com@.net";
		existingEmail = "afc" + generateFakeNumber() + "@gmail.com";
		notFoundEmail = "afc" + generateFakeNumber() + "@gmail.vn";
		validPassword = "Pvpgtvt2017!";
		invalidPassword = "79797979";
		System.out.println("Pre-Condition Step 1: Click to Register link");
		registerPage = homePage.clickToRegisterLink();

		System.out.println("Pre-Condition Step 2: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(notFoundEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		System.out.println("Pre-Condition Step 3: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-Condition Step 4: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Password is required.");

		System.out.println("Pre-Condition Step 5: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void Login_1_Login_Emty_Data() {
		loginPage = homePage.clickToLoginLink();
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_2_Login_Invalid_Email() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_3_Login_Email_Not_Found() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_4_Existing_Email_Empty_Password() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPassTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_5_Existing_Email_Incorrect_Password() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPassTextbox(invalidPassword);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_6_Emty_Data() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPassTextbox(validPassword);

		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

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

	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, invalidPassword;
	// Declare (Khai bao)
	// BasePage: class
	// basePage: object
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
}
