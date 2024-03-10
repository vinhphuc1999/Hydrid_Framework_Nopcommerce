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
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_7_Switch_Page extends BaseTest {
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
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		validPassword = "Pvpgtvt2017!";
	}

	@Test
	public void User_1_Register() {
		System.out.println("Pre-Condition Step 1: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		System.out.println("Pre-Condition Step 2: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		System.out.println("Pre-Condition Step 3: Click to Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Pre-Condition Step 4: Verify success message displayed");
		System.out.println("Pre-Condition Step 5: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.clickToLoginLink();
	}

	@Test
	public void User_2_Login() {
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPassTextbox(validPassword);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_3_Customer_Infor() {
		customerInforPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void User_4_Switch_Page() {
		addressPage = customerInforPage.openAddressPage(driver);
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		rewardPointPage = myProductReviewPage.openRewardPoint(driver);
		addressPage = rewardPointPage.openAddressPage(driver);
		rewardPointPage = addressPage.openRewardPoint(driver);
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
		addressPage = myProductReviewPage.openAddressPage(driver);
		customerInforPage = addressPage.openCustomerInforPage(driver);
		myProductReviewPage = customerInforPage.openMyProductReviewPage(driver);
	}

	@Test
	public void User_5_Switch_Role() {

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
	private String firstName, lastName, emailAddress, validPassword;
	// Declare (Khai bao)
	// BasePage: class
	// basePage: object
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserAddressPageObject addressPage;
}
