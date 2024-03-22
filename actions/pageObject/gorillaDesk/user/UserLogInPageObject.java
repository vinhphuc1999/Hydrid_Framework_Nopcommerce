package pageObject.gorillaDesk.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.gorillaDesk.UserLogInPageUI;

public class UserLogInPageObject extends BasePage {
	
	WebDriver driver;

	public UserLogInPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLogInButton() {
		waitForElementClickable(driver, UserLogInPageUI.LOG_IN_BUTTON);
		clickToElement(driver, UserLogInPageUI.LOG_IN_BUTTON);
	}

	public String getErrorUser() {
		return getElementText(driver, UserLogInPageUI.ERROR_USER_NAME_TEXT_BOX);
	}

	public String getErrorPassword() {
		return getElementText(driver, UserLogInPageUI.ERROR_PASS_WORD_TEXT_BOX);
	}

	public void inputEmailTextbox(String emailnvalid) {
		waitForElementClickable(driver, UserLogInPageUI.EMAIL_TEXT_BOX);
		sendkeyToElement(driver, UserLogInPageUI.EMAIL_TEXT_BOX, emailnvalid);
	}

	public void inputPasswordTextbox(String password) {
		waitForElementClickable(driver, UserLogInPageUI.PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, UserLogInPageUI.PASSWORD_TEXT_BOX, password);
	}

	public String getErrorEmailInvaild() {
		return getElementText(driver, UserLogInPageUI.ERROR_EMAIL_WRONG_FORMAT);
	}

	public String getErrorEmailNotRegister() {
		return getElementText(driver, UserLogInPageUI.ERROR_EMAIL_NOT_REGISTER);
	}

	public void clearPasswordTextbox() {
		clearToElemet(driver, UserLogInPageUI.PASSWORD_TEXT_BOX);
	}
}
