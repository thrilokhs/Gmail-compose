package pageObjects;

import org.openqa.selenium.By;
import helper.Generic;

import helper.Base;

public class GmailDashboard extends Base {

	Generic gen = new Generic();
	
	public void clickOnCompose() throws Exception {
		By compose = By.xpath("//div[text()='Compose']");
		gen.clickElement(compose);
	}
	
	//This verifies the delivery of the email with the subject name provided
	public boolean verifyinbox(String subject)
	{
		By msginbox = By.xpath("//span/span[text()='"+ subject + "']");
		boolean result = driver.findElement(msginbox).isDisplayed();
		return result;
	}
}