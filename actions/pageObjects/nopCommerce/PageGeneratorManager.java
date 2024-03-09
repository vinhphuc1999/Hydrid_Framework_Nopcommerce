package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static HomePageObject getHomePage (WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPage (WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage (WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static CustomerInforPageObject getCustomerInforPage (WebDriver driver) {
		return new CustomerInforPageObject(driver);
	}

	public static MyProductReviewPageObject getMyProductReviewPage (WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}

	public static RewardPointPageObject getRewardPointPage (WebDriver driver) {
		return new RewardPointPageObject(driver);
	}
	
	public static AddressPageObject getAddressPage (WebDriver driver) {
		return new AddressPageObject(driver);
	}
}
