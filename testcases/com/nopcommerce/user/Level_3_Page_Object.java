package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Level_3_Page_Object {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	// Declare (Khai bao)
	// BasePage: class
	// basePage: object
	private String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	// Multiple browser
	@BeforeClass
	public void beforeClass() {
		System.out.print(projectPath);
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		// Initial (Khoi tao)
		// Encapsulation (Dong goi)
		firstName = "Devtest";
		lastName = "Phuc Phung";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		password = "Pvpgtvt2017!";

	}

	@Test
	public void Testcase_1_Register_Emty_Data() {
		System.out.println("Home Page - Step 1: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("Register Page - Step 2: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 3: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}

	@Test
	public void Testcase_2_Register_Invalid_Email() {
		System.out.println("Home Page - Step 1: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("Home Page - Step 2: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox("phucpv999@");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register Page - Step 3: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Testcase_3_Register_Succes() {
		System.out.println("Home Page - Step 1: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("Home Page - Step 2: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register Page - Step 3: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 4: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Register Page - Step 5: Click to Logout link");
		registerPage.clickToLogoutLink();
	}

	@Test
	public void Testcase_4_Register_Exiting_Email() {
		System.out.println("Home Page - Step 1: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("Home Page - Step 2: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register Page - Step 3: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 4: Verify error existing email message displayed");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}

	@Test
	public void Testcase_5_Register_Password_Less_Than_6_Chars() {
		System.out.println("Home Page - Step 1: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("Home Page - Step 2: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("7979");
		registerPage.inputToConfirmPasswordTextbox("7979");

		System.out.println("Register Page - Step 3: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),
				"Password must meet the following rules:\nmust have at least 6 character");
	}

	@Test
	public void Testcase_6_Register_Invalid_Confirm_Password() {
		System.out.println("Home Page - Step 1: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("Home Page - Step 2: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(firstName);

		System.out.println("Register Page - Step 3: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),
				"The password and confirmation password do not match");
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
