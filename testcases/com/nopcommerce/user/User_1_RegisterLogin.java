package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class User_1_RegisterLogin {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void Testcase_1_Register_Emty_Data() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
	}

	@Test
	public void Testcase_2_Register_Invalid_Email() {
	}
	
	@Test
	public void Testcase_3_Register_Succes() {
	}
	
	@Test
	public void Testcase_4_Register_Exiting_Email() {
	}
	
	@Test
	public void Testcase_5_Register_Password_Less_Than_6_Chars() {
	}
	
	@Test
	public void Testcase_6_Register_Invalid_Confirm_Password() {
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
