package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_8_Switch_Role extends BaseTest {
	// Multiple browser
	@Parameters({"browser", "enviroment"})
	@BeforeClass
	public void beforeClass(String browserName, String enviromentName) {
		// Goi den khoi tao driver tuong ung voi browser name
		driver = getBrowserDriver(browserName, enviromentName);
		System.out.print(projectPath);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		// Initial (Khoi tao)
		// Encapsulation (Dong goi)
		firstName = "Devtest";
		lastName = "Phuc Phung";
		userEmailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		userPassword = "Pvpgtvt2017!";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
	}

	@Test
	public void Role_1_User() {
		System.out.println("Pre-Condition Step 1: Click to Register link");
		userRegisterPage = userHomePage.clickToRegisterLink();
		System.out.println("Pre-Condition Step 2: Input to required fields");
		userRegisterPage.inputToFirstnameTextbox(firstName);
		userRegisterPage.inputToLastnameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(userEmailAddress);
		userRegisterPage.inputToPasswordTextbox(userPassword);
		userRegisterPage.inputToConfirmPasswordTextbox(userPassword);
		System.out.println("Pre-Condition Step 3: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		System.out.println("Pre-Condition Step 4: Verify success message displayed");
		System.out.println("Pre-Condition Step 5: Click to Logout link");
		userHomePage = userRegisterPage.clickToLogoutLink();
		userLoginPage = userHomePage.clickToLoginLink();
		// Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

		// Home page -> Customer information
		userCustomerInforPage = userHomePage.openCustomerInforPage(driver);

		// Customer information -> Click Logout -> Home Page
		userHomePage = userCustomerInforPage.clickToLogoutLinkAtUserPage(driver);

		// User Home Page -> Open Admin Page -> Login Page (Admin)
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_DEV_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		// Login as Admin role
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());

		// Dashboard Page -> Click Logout -> Login Page (Admin)
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdminPage(driver);

	}

	@Test
	public void Role_2_Admin() {
		// Login Page (Admin) -> Open User url -> Home Page (User)
		adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_DEV_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		// Home page -> Login page
		userLoginPage = userHomePage.clickToLoginLink();

		// Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
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
	private String firstName, lastName, userEmailAddress, userPassword, adminEmailAddress, adminPassword;
	// Declare (Khai bao)
	// BasePage: class
	// basePage: object
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject userCustomerInforPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
}
