package pageFactory.nopCommerce.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {

	private WebDriver driver;

	// Ham khoi tao: La ham cung ten voi ten Class nhung khong co kieu tra ve
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Page UI
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;

	@FindBy(how = How.XPATH, using = "//a[@class='ico-login']")
	private WebElement loginLink;

	@FindBy(how = How.XPATH, using = "//a[@class='ico-login']")
	private WebElement myAccountLink;

	// Page Object/ Action
	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, myAccountLink);
		return isElementDisplayed(driver, myAccountLink);
	}

}
