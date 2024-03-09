package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.BasePageUI;
import pageUIs.nopCommerce.CustomerInforPageUI;

public class CustomerInforPageObject extends BasePage {

	WebDriver driver;

	public CustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isCustomerInforPageDisplayed() {
		waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}

	public AddressPageObject openAddressPage() {
		waitForElementClickable(driver, BasePageUI.ADDRESS_LINK);
		clickToElement(driver, BasePageUI.ADDRESS_LINK);
		return PageGeneratorManager.getAddressPage(driver);
	}

}
