package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class User_1_RegisterLogin {
	WebDriver driver;
	String emailAddress;
	String projectPath = System.getProperty("user.dir");
	Random generator = new Random();

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void Testcase_1_Register_Emty_Data() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(),
				"First name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(),
				"Last name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(),
				"Password is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),
				"Password is required.");
	}

	@Test
	public void Testcase_2_Register_Invalid_Email() {
		driver.findElement(By.cssSelector("input#gender-male")).click();
		driver.findElement(By.cssSelector("input#FirstName")).clear();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Phung");
		driver.findElement(By.cssSelector("input#LastName")).clear();
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Phuc");
		Select selectDay = new Select(driver.findElement(By.cssSelector("[name=\"DateOfBirthDay\"]")));
		selectDay.selectByValue("9");
		Select selectMonth = new Select(driver.findElement(By.cssSelector("[name=\"DateOfBirthMonth\"]")));
		selectMonth.selectByValue("10");
		Select selectYear = new Select(driver.findElement(By.cssSelector("[name=\"DateOfBirthYear\"]")));
		selectYear.selectByValue("1999");
		driver.findElement(By.cssSelector("input#Email")).clear();
		driver.findElement(By.cssSelector("input#Company")).clear();
		driver.findElement(By.cssSelector("input#Password")).clear();
		driver.findElement(By.cssSelector("input#ConfirmPassword")).clear();
		driver.findElement(By.cssSelector("input#Email")).sendKeys("phucpv999@");
		driver.findElement(By.cssSelector("input#Company")).sendKeys("Nam Long Software");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("Pvpgtvt2017!");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("Pvpgtvt2017!");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");
	}

	@Test
	public void Testcase_3_Register_Succes() {
//		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("input#gender-male")).click();
		driver.findElement(By.cssSelector("input#FirstName")).clear();
		driver.findElement(By.cssSelector("input#LastName")).clear();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Phung");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Phuc");
		Select selectDay = new Select(driver.findElement(By.cssSelector("[name=\"DateOfBirthDay\"]")));
		selectDay.selectByValue("9");
		Select selectMonth = new Select(driver.findElement(By.cssSelector("[name=\"DateOfBirthMonth\"]")));
		selectMonth.selectByValue("10");
		Select selectYear = new Select(driver.findElement(By.cssSelector("[name=\"DateOfBirthYear\"]")));
		selectYear.selectByValue("1999");
		driver.findElement(By.cssSelector("input#Email")).clear();
		driver.findElement(By.cssSelector("input#Company")).clear();
		driver.findElement(By.cssSelector("input#Password")).clear();
		driver.findElement(By.cssSelector("input#ConfirmPassword")).clear();
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("input#Company")).sendKeys("Nam Long Software");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("Pvpgtvt2017!");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("Pvpgtvt2017!");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
	}

	@Test
	public void Testcase_4_Register_Exiting_Email() {
		driver.findElement(By.cssSelector("a.button-1")).click();
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("input#gender-male")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Phung");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Phuc");
		Select selectDay = new Select(driver.findElement(By.cssSelector("[name=\"DateOfBirthDay\"]")));
		selectDay.selectByValue("9");
		Select selectMonth = new Select(driver.findElement(By.cssSelector("[name=\"DateOfBirthMonth\"]")));
		selectMonth.selectByValue("10");
		Select selectYear = new Select(driver.findElement(By.cssSelector("[name=\"DateOfBirthYear\"]")));
		selectYear.selectByValue("1999");
		driver.findElement(By.cssSelector("input#Email")).sendKeys("phucpv999@gmail.com");
		driver.findElement(By.cssSelector("input#Company")).sendKeys("Nam Long Software");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("Pvpgtvt2017!");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("Pvpgtvt2017!");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//li[text()='The specified email already exists']")).getText(),
				"The specified email already exists");
	}

	@Test
	public void Testcase_5_Register_Password_Less_Than_6_Chars() {
		/* driver.findElement(By.cssSelector("a.ico-register")).click(); */
		driver.findElement(By.cssSelector("input#gender-male")).click();
		driver.findElement(By.cssSelector("input#FirstName")).clear();
		driver.findElement(By.cssSelector("input#LastName")).clear();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Phung");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Phuc");
		Select selectDay = new Select(driver.findElement(By.cssSelector("[name=\"DateOfBirthDay\"]")));
		selectDay.selectByValue("9");
		Select selectMonth = new Select(driver.findElement(By.cssSelector("[name=\"DateOfBirthMonth\"]")));
		selectMonth.selectByValue("10");
		Select selectYear = new Select(driver.findElement(By.cssSelector("[name=\"DateOfBirthYear\"]")));
		selectYear.selectByValue("1999");
		driver.findElement(By.cssSelector("input#Email")).clear();
		driver.findElement(By.cssSelector("input#Company")).clear();
		driver.findElement(By.cssSelector("input#Password")).clear();
		driver.findElement(By.cssSelector("input#ConfirmPassword")).clear();
		driver.findElement(By.cssSelector("input#Email")).sendKeys("phucpv1@gmail.com");
		driver.findElement(By.cssSelector("input#Company")).sendKeys("Nam Long Software");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("12345");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("12345");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(
				driver.findElement(By.xpath("//p[text()='Password must meet the following rules: ']")).getText(),
				"Password must meet the following rules:");
	}

	@Test
	public void Testcase_6_Register_Invalid_Confirm_Password() {
		driver.findElement(By.cssSelector("input#gender-male")).click();
		driver.findElement(By.cssSelector("input#FirstName")).clear();
		driver.findElement(By.cssSelector("input#LastName")).clear();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Phung");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Phuc");
		Select selectDay = new Select(driver.findElement(By.cssSelector("[name=\"DateOfBirthDay\"]")));
		selectDay.selectByValue("9");
		Select selectMonth = new Select(driver.findElement(By.cssSelector("[name=\"DateOfBirthMonth\"]")));
		selectMonth.selectByValue("10");
		Select selectYear = new Select(driver.findElement(By.cssSelector("[name=\"DateOfBirthYear\"]")));
		selectYear.selectByValue("1999");
		driver.findElement(By.cssSelector("input#Email")).clear();
		driver.findElement(By.cssSelector("input#Company")).clear();
		driver.findElement(By.cssSelector("input#Password")).clear();
		driver.findElement(By.cssSelector("input#ConfirmPassword")).clear();
		driver.findElement(By.cssSelector("input#Email")).sendKeys("phucpv1@gmail.com");
		driver.findElement(By.cssSelector("input#Company")).sendKeys("Nam Long Software");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("12345");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),
				"The password and confirmation password do not match.");
	}
	
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
