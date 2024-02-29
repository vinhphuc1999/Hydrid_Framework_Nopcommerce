package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {

	private WebDriver driver;

	// Ham khoi tao: La ham cung ten voi ten Class nhung khong co kieu tra ve
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void clickToRegisterLink() {
		System.out.println(HomePageUI.EMAIL_TEXTBOX);
		waitForElementClickable(driver, HomePageUI.EMAIL_TEXTBOX);
		clickToElement(driver, HomePageUI.EMAIL_TEXTBOX);
	}

}
