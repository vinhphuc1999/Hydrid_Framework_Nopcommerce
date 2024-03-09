package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_3_Page_Object_1_Register {
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		// Initial (Khoi tao)
		// Encapsulation (Dong goi)
		firstName = "Devtest";
		lastName = "Phuc Phung";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		password = "Pvpgtvt2017!";

	}

	@Test
	public void Register_1_Register_Emty_Data() {
		System.out.println("Register_1 Step 1: Click to Register link");
		homePage.clickToRegisterLink();

		// Nguyen tac: Khi qua trang moi thi phai khoi tao trang len
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_1 Step 2: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_1 Step 3: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}

	@Test
	public void Register_2_Register_Invalid_Email() {
		System.out.println("Register_2 Step 1: Click to Register link");
		homePage.clickToRegisterLink();

		// Nguyen tac: Khi qua trang moi thi phai khoi tao trang len
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_2 Step 2: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox("phucpv999@");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_2 Step 3: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_2 Step 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Register_3_Register_Succes() {
		System.out.println("Register_3 Step 1: Click to Register link");
		homePage.clickToRegisterLink();

		// Nguyen tac: Khi qua trang moi thi phai khoi tao trang len
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_3 Step 2: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_3 Step 3: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_3 Step 4: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Password is required.");

		System.out.println("Register_3 Step 5: Click to Logout link");
		registerPage.clickToLogoutLink();
	}

	@Test
	public void Register_4_Register_Exiting_Email() {
		System.out.println("Register_4 Step 1: Click to Register link");
		homePage.clickToRegisterLink();

		// Nguyen tac: Khi qua trang moi thi phai khoi tao trang len
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_4 Step 2: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_4 Step 3: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_4 Step 4: Verify error existing email message displayed");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "Password is required.");
	}

	@Test
	public void Register_5_Register_Password_Less_Than_6_Chars() {
		System.out.println("Register_5 Step 1: Click to Register link");
		homePage.clickToRegisterLink();

		// Nguyen tac: Khi qua trang moi thi phai khoi tao trang len
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_5 Step 2: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("7979");
		registerPage.inputToConfirmPasswordTextbox("7979");

		System.out.println("Register_5 Step 3: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_5 Step 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_6_Register_Invalid_Confirm_Password() {
		System.out.println("Register_6 Step 1: Click to Register link");
		homePage.clickToRegisterLink();

		// Nguyen tac: Khi qua trang moi thi phai khoi tao trang len
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_6 Step 2: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(firstName);

		System.out.println("Register_6 Step 3: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_6 Step 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
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
