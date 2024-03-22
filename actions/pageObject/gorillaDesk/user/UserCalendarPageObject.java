package pageObject.gorillaDesk.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.gorillaDesk.UserCalendarPageUI;

public class UserCalendarPageObject extends BasePage {

	WebDriver driver;

	public UserCalendarPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitleCalendarPage() {
		waitForElementClickable(driver, UserCalendarPageUI.TITLE_CALENDAR);
		return getElementText(driver, UserCalendarPageUI.TITLE_CALENDAR);
	}

}
