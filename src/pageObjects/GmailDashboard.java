package pageObjects;

import org.openqa.selenium.By;
import helper.Generic;
import helper.Base;

public class GmailDashboard extends Base {

	Generic gen = new Generic();

	// This clicks on the Compose button from the Gmail landing page/Dashboard
	public void clickOnCompose() throws Exception {
		By compose = By.xpath("//div[text()='Compose']");
		gen.clickElement(compose);
	}

	// This verifies the delivery of the email with the subject name provided
	public boolean verifyinbox(String subject) {
		By msgInbox = By.xpath("//span/span[text()='" + subject + "']");
		boolean result = driver.findElement(msgInbox).isDisplayed();
		return result;
	}
}