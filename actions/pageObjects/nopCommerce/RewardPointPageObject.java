package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.RewardPointPageUI;

public class RewardPointPageObject extends BasePage {

	WebDriver driver;

	public RewardPointPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AddressPageObject openAddressPage() {
		waitForElementClickable(driver, RewardPointPageUI.ADDRESS_LINK);
		clickToElement(driver, RewardPointPageUI.ADDRESS_LINK);
		return PageGeneratorManager.getAddressPage(driver);
	}

	public MyProductReviewPageObject openMyProductReviewPage() {
		// TODO Auto-generated method stub
		return null;
	}

}
