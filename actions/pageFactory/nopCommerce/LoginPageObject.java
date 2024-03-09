package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Page UI
	@FindBy(how = How.XPATH, using = "//input[@id='Email']")
	private WebElement emailTextbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='Password']")
	private WebElement paswordTextbox;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class, 'login-button')]")
	private WebElement loginButton;
	
	@FindBy(how = How.XPATH, using = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'validation-summary-errors')]")
	private WebElement unsuccessErrorMessage;

	// Page Object/ Action
	
	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, invalidEmail);
	}

	public String getErrorMessageUnsuccessfull() {
		waitForElementVisible(driver, unsuccessErrorMessage);
		return getElementText(driver, unsuccessErrorMessage);
	}

	public void inputToPassTextbox(String password) {
		waitForElementVisible(driver, paswordTextbox);
		sendkeyToElement(driver, paswordTextbox, password);
	}

}
