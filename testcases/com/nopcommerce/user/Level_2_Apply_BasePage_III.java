package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_2_Apply_BasePage_III extends BasePage {
	WebDriver driver;
	String emailAddress;
	// Declare (Khai bao)
	// BasePage: class
	// basePage: object
	String projectPath = System.getProperty("user.dir");

	// Multiple browser
	@BeforeClass
	public void beforeClass() {
		System.out.print(projectPath);
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		// Initial (Khoi tao)
		// Encapsulation (Dong goi)
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void Testcase_1_Register_Emty_Data() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
	}

	@Test
	public void Testcase_2_Register_Invalid_Email() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
		checkToDefaultCheckboxRadio(driver, "//input[@id='gender-male']");
		clickToElement(driver, "//input[@id='gender-male']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Phung");
		sendkeyToElement(driver, "//input[@id='LastName']", "Phuc");
		selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "9");
		selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "10");
		selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
		sendkeyToElement(driver, "//input[@id='Email']", "phucpv999@");
		sendkeyToElement(driver, "//input[@id='Company']", "Nam Long Software");
		sendkeyToElement(driver, "//input[@id='Password']", "Pvpgtvt2017!");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "Pvpgtvt2017!");
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}

	@Test
	public void Testcase_3_Register_Succes() {
//		driver.findElement(By.cssSelector("a.ico-register")).click();
		clickToElement(driver, "//input[@id='gender-male']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Phung");
		sendkeyToElement(driver, "//input[@id='LastName']", "Phuc");
		selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "9");
		selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "10");
		selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Company']", "Nam Long Software");
		sendkeyToElement(driver, "//input[@id='Password']", "Pvpgtvt2017!");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "Pvpgtvt2017!");
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
	}

	@Test
	public void Testcase_4_Register_Exiting_Email() {
		clickToElement(driver, "//a[@class='button-1 register-continue-button']");
		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//input[@id='gender-male']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Phung");
		sendkeyToElement(driver, "//input[@id='LastName']", "Phuc");
		selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "9");
		selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "10");
		selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
		sendkeyToElement(driver, "//input[@id='Email']", "phucpv999@gmail.com");
		sendkeyToElement(driver, "//input[@id='Company']", "Nam Long Software");
		sendkeyToElement(driver, "//input[@id='Password']", "Pvpgtvt2017!");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "Pvpgtvt2017!");
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//li[text()='The specified email already exists']"),
				"The specified email already exists");
	}

	@Test
	public void Testcase_5_Register_Password_Less_Than_6_Chars() {
		/* driver.findElement(By.cssSelector("a.ico-register")).click(); */
		clickToElement(driver, "//input[@id='gender-male']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Phung");
		sendkeyToElement(driver, "//input[@id='LastName']", "Phuc");
		selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "9");
		selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "10");
		selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
		sendkeyToElement(driver, "//input[@id='Email']", "phucpv1@gmail.com");
		sendkeyToElement(driver, "//input[@id='Company']", "Nam Long Software");
		sendkeyToElement(driver, "//input[@id='Password']", "12345");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//p[text()='Password must meet the following rules: ']"),
				"Password must meet the following rules:");
	}

	@Test
	public void Testcase_6_Register_Invalid_Confirm_Password() {
		clickToElement(driver, "//input[@id='gender-male']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Phung");
		sendkeyToElement(driver, "//input[@id='LastName']", "Phuc");
		selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "9");
		selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "10");
		selecItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
		sendkeyToElement(driver, "//input[@id='Email']", "phucpv1@gmail.com");
		sendkeyToElement(driver, "//input[@id='Company']", "Nam Long Software");
		sendkeyToElement(driver, "//input[@id='Password']", "1234579");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123457");
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"The password and confirmation password do not match.");
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
