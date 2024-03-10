package pageFactory.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {

	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Page UI
	@FindBy(how = How.XPATH, using = "//input[@id='FirstName']")
	private WebElement firstNameTextbox;

	@FindBy(how = How.XPATH, using = "//input[@id='LastName']")
	private WebElement lastNameTextbox;

	@FindBy(how = How.XPATH, using = "//input[@id='Email']")
	private WebElement emailTextbox;

	@FindBy(how = How.XPATH, using = "//input[@id='Password']")
	private WebElement passwordTextbox;

	@FindBy(how = How.XPATH, using = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;

	@FindBy(how = How.XPATH, using = "//button[@id='register-button']")
	private WebElement registerButton;

	@FindBy(how = How.XPATH, using = "//span[@id='FirstName-error']")
	private WebElement firstNameErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[@id='LastName-error']")
	private WebElement lastNameErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[@id='ConfirmPassword-error']")
	private WebElement registerSuccesMessage;

	@FindBy(how = How.XPATH, using = "//span[@id='ConfirmPassword-error']")
	private WebElement logoutLink;

	@FindBy(how = How.XPATH, using = "//span[@id='ConfirmPassword-error']")
	private WebElement existingEmailErrorMessage;

	// Page Object/ Action
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}

	public void inputToFirstnameTextbox(String firstName) {
		waitForElementClickable(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);
	}

	public void inputToLastnameTextbox(String lastName) {
		waitForElementClickable(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementClickable(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementClickable(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementClickable(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementInVisible(driver, existingEmailErrorMessage);
		return getElementText(driver, existingEmailErrorMessage);
	}

	public String getRegisterSuccessMessage() {
		waitForElementInVisible(driver, registerSuccesMessage);
		return getElementText(driver, registerSuccesMessage);
	}

}
