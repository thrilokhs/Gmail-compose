package pageObjects;

import org.openqa.selenium.By;
import helper.Base;
import helper.Generic;

public class GmailCompose extends Base {
	Generic gen = new Generic();

	By textboxTo = By.xpath("//textarea[@name='to']");
	By linkCc = By.xpath("//span[text()='Cc']");
	By textboxCc = By.xpath("//textarea[@name='cc']");
	By linkBcc = By.xpath("//span[text()='Bcc']");
	By textboxBcc = By.xpath("//textarea[@name='bcc']");
	By textboxSubject = By.xpath("//input[@name='subjectbox']");
	By textBoxEmail = By.xpath("//div[@role='textbox']");
	By linkAttach = By.xpath("//input[@name='Filedata']/preceding-sibling::div");
	By linkSignature = By.xpath("//div[@class='BP aaA aMZ']");
	By errmsg = By.xpath("//div[text()='Please specify at least one recipient.']");
	By dropdnSend = By.xpath("//div[@class='G-asx']");
	By linkSS = By.xpath("//div[@selector='scheduledSend']");
	By linkTomorrow = By.xpath("//div[text()='Monday morning']");
	By dropdnFont = By.xpath("//div[@command='+fontName']");

	// This enters the email addresses in the "To" textbox
	public void enterToEmail(String emails) throws Exception {
		gen.inputText(textboxTo, emails);
	}

	// This clicks on the Cc link beside the address textbox
	public void clickOnCc() throws Exception {
		gen.clickElement(linkCc);
	}

	// This enters the email addresses in the "Cc" textbos
	public void enterCcEmails(String emails) throws Exception {
		gen.inputText(textboxCc, emails);
	}

	// This clicks on the Bcc link beside the address textbox
	public void clickOnBcc() throws Exception {
		gen.clickElement(linkBcc);
	}

	// This enters the email addresses in the "Bcc" textbox
	public void enterBccEmails(String emails) throws Exception {
		gen.inputText(textboxBcc, emails);
	}

	// This identifies and selects the email id from the dynamically auto suggested
	// emails
	public void enterPartialEmail(String partialEmail, String Name) throws Exception {
		gen.inputText(textboxTo, partialEmail);
		Thread.sleep(4000);
		By textSuggested = By.xpath("//div[text()='" + Name + "']");
		gen.clickElement(textSuggested);
	}

	// This adds the text in the Subject textbox
	public void enterSubject(String subject) throws Exception {
		gen.inputText(textboxSubject, subject);
	}

	// This adds the text in the email body
	public void enterEmailText(String emailBody) throws Exception {
		gen.inputText(textBoxEmail, emailBody);
	}

	// This adds the attachment from the path passed as argument
	public void addAttachment(String path) throws Exception {
		gen.addAttachment(linkAttach, path);
		Thread.sleep(2000);// sleep is provided for the email send process to be completed
	}

	// This clicks on the Signature
	public void clickOnSignature() throws Exception {
		gen.clickElement(linkSignature);
	}

	// This selects and inserts the signature label that is provided as an argument
	public void addSignature(String SignatureName) throws Exception {
		By linkAddSign = By.xpath("//div[text()='" + SignatureName + "']");
		gen.clickElement(linkAddSign);
	}

	// This provides a boolean result if there is an error when trying to send an
	// email without entering an email id
	public boolean Noemailerror() {
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
	public void scheduleSendMonday() throws Exception {
		gen.clickElement(dropdnSend);
		gen.clickElement(linkSS);
		gen.clickElement(linkTomorrow);
	}

	// Provide the font name as the argument so that the font is selected for the
	// email body
	public void selectFont(String Fontname) throws Exception {
		gen.clickElement(textBoxEmail);
		gen.clickElement(dropdnFont);
		By font = By.xpath("//div[text()='" + Fontname + "']");
		gen.clickElement(font);
	}

}
