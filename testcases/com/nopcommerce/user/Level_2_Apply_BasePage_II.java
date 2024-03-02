//package com.nopcommerce.user;
//
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import commons.BasePage;
//
//public class Level_2_Apply_BasePage_II {
//	WebDriver driver;
//	String emailAddress;
//	// Declare (Khai bao)
//	BasePage basePage;
//	// BasePage: class
//	// basePage: object
//	String projectPath = System.getProperty("user.dir");
//
//	// Multiple browser
//	@BeforeClass
//	public void beforeClass() {
//		System.out.print(projectPath);
//		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
//		driver = new EdgeDriver();
//		// Initial (Khoi tao)
//		// Encapsulation (Dong goi)
//		basePage = BasePage.getBasePage();
//		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get("https://demo.nopcommerce.com/");
//	}
//
//	@Test
//	public void Testcase_1_Register_Emty_Data() {
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"),
//				"First name is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),
//				"Password is required.");
//	}
//
//	@Test
//	public void Testcase_2_Register_Invalid_Email() {
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		basePage.checkToDefaultCheckboxRadio(driver, "//input[@id='gender-male']");
//		basePage.clickToElement(driver, "//input[@id='gender-male']");
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Phung");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Phuc");
//		basePage.selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "9");
//		basePage.selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "10");
//		basePage.selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", "phucpv999@");
//		basePage.sendkeyToElement(driver, "//input[@id='Company']", "Nam Long Software");
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "Pvpgtvt2017!");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "Pvpgtvt2017!");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
//	}
//
//	@Test
//	public void Testcase_3_Register_Succes() {
////		driver.findElement(By.cssSelector("a.ico-register")).click();
//		basePage.clickToElement(driver, "//input[@id='gender-male']");
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Phung");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Phuc");
//		basePage.selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "9");
//		basePage.selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "10");
//		basePage.selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
//		basePage.sendkeyToElement(driver, "//input[@id='Company']", "Nam Long Software");
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "Pvpgtvt2017!");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "Pvpgtvt2017!");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
//	}
//
//	@Test
//	public void Testcase_4_Register_Exiting_Email() {
//		basePage.clickToElement(driver, "//a[@class='button-1 register-continue-button']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//input[@id='gender-male']");
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Phung");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Phuc");
//		basePage.selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "9");
//		basePage.selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "10");
//		basePage.selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", "phucpv999@gmail.com");
//		basePage.sendkeyToElement(driver, "//input[@id='Company']", "Nam Long Software");
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "Pvpgtvt2017!");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "Pvpgtvt2017!");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		Assert.assertEquals(basePage.getElementText(driver, "//li[text()='The specified email already exists']"),
//				"The specified email already exists");
//	}
//
//	@Test
//	public void Testcase_5_Register_Password_Less_Than_6_Chars() {
//		/* driver.findElement(By.cssSelector("a.ico-register")).click(); */
//		basePage.clickToElement(driver, "//input[@id='gender-male']");
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Phung");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Phuc");
//		basePage.selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "9");
//		basePage.selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "10");
//		basePage.selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", "phucpv1@gmail.com");
//		basePage.sendkeyToElement(driver, "//input[@id='Company']", "Nam Long Software");
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "12345");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		Assert.assertEquals(basePage.getElementText(driver, "//p[text()='Password must meet the following rules: ']"),
//				"Password must meet the following rules:");
//	}
//
//	@Test
//	public void Testcase_6_Register_Invalid_Confirm_Password() {
//		basePage.clickToElement(driver, "//input[@id='gender-male']");
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Phung");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Phuc");
//		basePage.selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "9");
//		basePage.selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "10");
//		basePage.selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", "phucpv1@gmail.com");
//		basePage.sendkeyToElement(driver, "//input[@id='Company']", "Nam Long Software");
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "1234579");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123457");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),
//				"The password and confirmation password do not match.");
//	}
//
//	// Customer close browser/ driver
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
//
//	public int generateFakeNumber() {
//		Random rand = new Random();
//		return rand.nextInt(9999);
//	}
//
//}
