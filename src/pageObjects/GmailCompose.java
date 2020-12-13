package pageObjects;

import org.openqa.selenium.By;
import helper.Base;
import helper.Generic;

public class GmailCompose extends Base {
	Generic gen = new Generic();

	// This clicks on the Compose button on the Gmail Home page
	public void clickCompose(String deviceName) throws Exception {
		By linkCompose = By.xpath("//li[@class='chapternav-item chapternav-item-" + deviceName + "']");
		gen.clickElement(linkCompose);
	}

	// This enters the email addresses in the "To" textbox
	public void enterToEmail(String emails) throws Exception {
		By textboxTo = By.xpath("//textarea[@name='to']");
		gen.inputText(textboxTo, emails);
	}

	// This clicks on the Cc link beside the address textbox
	public void clickOnCc() throws Exception {
		By linkCc = By.xpath("//span[text()='Cc']");
		gen.clickElement(linkCc);
	}

	// This enters the email addresses in the "Cc" textbos
	public void enterCcEmails(String emails) throws Exception {
		By textboxCc = By.xpath("//textarea[@name='cc']");
		gen.inputText(textboxCc, emails);
	}

	// This clicks on the Bcc link beside the address textbox
	public void clickOnBcc() throws Exception {
		By linkBcc = By.xpath("//span[text()='Bcc']");
		gen.clickElement(linkBcc);
	}

	// This enters the email addresses in the "Bcc" textbox
	public void enterBccEmails(String emails) throws Exception {
		By textboxBcc = By.xpath("//textarea[@name='bcc']");
		gen.inputText(textboxBcc, emails);
	}

	// This identifies and selects the email id from the dynamically auto suggested
	// emails
	public void enterPartialEmail(String partialEmail, String Name) throws Exception {
		By textboxTo = By.xpath("//textarea[@name='to']");
		gen.inputText(textboxTo, partialEmail);
		Thread.sleep(4000);
		By textSuggested = By.xpath("//div[text()='" + Name + "']");
		gen.clickElement(textSuggested);
	}

	// This adds the text in the Subject textbox
	public void addSubject(String subject) throws Exception {
		By textboxSubject = By.xpath("//input[@name='subjectbox']");
		gen.inputText(textboxSubject, subject);
	}

	public void addEmailText(String emailBody) throws Exception {
		By textBoxEmail = By.xpath("//div[@role='textbox']");
		gen.inputText(textBoxEmail, emailBody);
	}

	// This adds the text in the email body
	public void addAttachment(String path) throws Exception {
		By linkAttach = By.xpath("//input[@name='Filedata']");
		gen.inputText(linkAttach, path);
	}

	// This clicks the Signature link
	public void clickOnSignature() throws Exception {
		By linkSignature = By.xpath("//div[@class='BP aaA aMZ']");
		gen.clickElement(linkSignature);
	}

	// This selects and inserts the signature label that is provided as an argument
	public void addSignature(String SignatureName) throws Exception {
		By linkAddSign = By.xpath("//div[text()='" + SignatureName + "']");
		gen.clickElement(linkAddSign);
	}

	// This provides a boolean result if there is an error when trying to send an
	// email without enterging email addresses
	public boolean Noemailerror() {
		By errmsg = By.xpath("//div[text()='Please specify at least one recipient.']");
		boolean result = driver.findElement(errmsg).isDisplayed();
		return result;
	}

	// This clicks the Send button
	public void clickOnSend() throws Exception {
		By sendLink = By.xpath("//div[text()='Send']");
		gen.clickElement(sendLink);
	}

	// This closes the Compose email window
	public void ClickOnCloseComposeBox() throws Exception {
		By btnClose = By.xpath("//img[@alt='Close']");
		gen.clickElement(btnClose);
	}

	// This closes the error pop up that appears when trying to send an email
	// without adding an email id
	public void ClickOkOnErrMsgBox() throws Exception {
		By btnOk = By.xpath("//button[text()='OK']");
		gen.clickElement(btnOk);
	}

	// This schedules Sendemail at the date and time provided in the parameters
	public void scheduleSend(String DDBMMMBYYYY, String HHBMMBAMPM) throws Exception {
		By dropdn = By.xpath("//div[@class='G-asx']");
		gen.clickElement(dropdn);

		By linkSS = By.xpath("//div[@selector='scheduledSend']");
		gen.clickElement(linkSS);

		By linkPickDate = By.xpath("//div[text()='Pick date & time']");
		gen.clickElement(linkPickDate);

		Thread.sleep(2000);

		// By TextDate = By.xpath("//input[@class='hu jA']");
//		WebElement web = driver.findElement(By.xpath("//input[@class='hu jA']"));
//		web.sendKeys(Keys.chord(Keys.CONTROL,"a"));
//		web.sendKeys(Keys.BACK_SPACE);

//		//gen.inputText(TextDate, "Keys.chord(Keys.CONTROL,\"a\", Keys.DELETE)");
//		gen.inputText(TextDate, "Keys.chord(Keys.CONTROL,\"a\")");
//		gen.inputText(TextDate, "Keys.BACK_SPACE");
////		Thread.sleep(4000);
////		gen.inputTex	t(TextDate, "Keys.BACKSPACE");
//		Thread.sleep(4000);
//		gen.inputText(TextDate, DDBMMMBYYYY);

		By TextTime = By.xpath("//input[@class='hu ks']");
		// driver.findElement(By.xpath("//input[@class='hu ks']")).clear();
		// gen.inputText(TextTime, "Keys.chord(Keys.CONTROL,\"a\", Keys.DELETE)");
		Thread.sleep(4000);
//		gen.inputText(TextTime, "Keys.CONTROL + \"a\"");
//		Thread.sleep(4000);
//		gen.inputText(TextTime, "Keys.DELETE");
//		Thread.sleep(4000);
		gen.inputText(TextTime, HHBMMBAMPM);
		Thread.sleep(4000);

		By btnSS = By.xpath("//button[text()='Schedule send']");
		driver.findElement(By.xpath("//button[text()='Schedule send']"));
		gen.clickElement(btnSS);

	}

	// Provide the font name as the argument so that the font is selected for the
	// email body
	public void selectFont(String Fontname) throws Exception {
		By textBoxEmail = By.xpath("//div[@role='textbox']");
		gen.clickElement(textBoxEmail);

		By dropdn = By.xpath("//div[@command='+fontName']");
		gen.clickElement(dropdn);

		By font = By.xpath("//div[text()='" + Fontname + "']");
		gen.clickElement(font);

	}

}
