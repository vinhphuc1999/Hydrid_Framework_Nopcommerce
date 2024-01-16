package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class User_2_LogIn {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Random generator = new Random();

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void Testcase_1_LogIn_Emty_Data() {
		driver.findElement(By.cssSelector("a.ico-login")).click();
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(),
				"Please enter your email");
	}

	@Test
	public void Testcase_2_LogIn_Invalid_Email() {
//		driver.findElement(By.cssSelector("a.ico-login")).click();
		driver.findElement(By.cssSelector("input#Email")).sendKeys("phucpv@");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");
	}

	@Test
	public void Testcase_3_LogIn_Email_Not_Yet_Register() {
		driver.findElement(By.cssSelector("input#Email")).clear();
		driver.findElement(By.cssSelector("input#Email")).sendKeys("phucpv@gmail.com");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("797979");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.validation-summary-errors li")).getText(),
				"No customer account found");
	}

	@Test
	public void Testcase_4_LogIn_Not_InPut_PassWord() {
		driver.findElement(By.cssSelector("input#Email")).clear();
		driver.findElement(By.cssSelector("input#Email")).sendKeys("phucpv79@gmail.com");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.validation-summary-errors li")).getText(),
				"The credentials provided are incorrect");
	}

	@Test
	public void Testcase_5_LogIn_Wrong_Password() {
		driver.findElement(By.cssSelector("input#Email")).clear();
		driver.findElement(By.cssSelector("input#Email")).sendKeys("phucpv79@gmail.com");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("79797979");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.validation-summary-errors li")).getText(),
				"The credentials provided are incorrect");
	}

	@Test
	public void Testcase_6_LogIn_Success() {
		driver.findElement(By.cssSelector("input#Email")).clear();
		driver.findElement(By.cssSelector("input#Email")).sendKeys("phucpv79@gmail.com");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("797979");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
