package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.HomePageObject;
import pageFactory.LoginPageObject;
import pageFactory.RegisterPageObject;


public class Level_5_Page_Factory extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, invalidPassword;
	// Declare (Khai bao)
	// BasePage: class
	// basePage: object
	private String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	// Multiple browser
		@Parameters("browser")
		@BeforeClass
		public void beforeClass(String browserName) {
			// Goi den khoi tao driver tuong ung voi browser name

			driver = getBrowserDriver(browserName);

			System.out.print(projectPath);

			homePage = new HomePageObject(driver);
			// Initial (Khoi tao)
			// Encapsulation (Dong goi)
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
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

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
		registerPage.clickToLogoutLink();

		homePage = new HomePageObject(driver);
	}

	@Test
	public void Login_1_Login_Emty_Data() {
		homePage.clickToLoginLink();

		// Tu trang Home sang trang Login
		loginPage = new LoginPageObject(driver);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_2_Login_Invalid_Email() {
		homePage.clickToLoginLink();

		// Tu trang Home sang trang Login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_3_Login_Email_Not_Found() {
		homePage.clickToLoginLink();

		// Tu trang Home sang trang Login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_4_Existing_Email_Empty_Password() {
		homePage.clickToLoginLink();

		// Tu trang Home sang trang Login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPassTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_5_Existing_Email_Incorrect_Password() {
		homePage.clickToLoginLink();

		// Tu trang Home sang trang Login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPassTextbox(invalidPassword);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_6_Emty_Data() {
		homePage.clickToLoginLink();

		// Tu trang Home sang trang Login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPassTextbox(validPassword);

		loginPage.clickToLoginButton();

		// Login thanh cong quay ve trang Home
		homePage = new HomePageObject(driver);
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

}
