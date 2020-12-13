package pageObjects;

import org.openqa.selenium.By;
import helper.Base;
import helper.Generic;

public class GmailCompose extends Base {
	Generic gen = new Generic();

	public void clickCompose(String deviceName) throws Exception {
		By linkCompose = By.xpath("//li[@class='chapternav-item chapternav-item-" + deviceName + "']");
		gen.clickElement(linkCompose);
	}

	public void enterToEmail(String emails) throws Exception {
		By textboxTo = By.xpath("//textarea[@name='to']");
		gen.inputText(textboxTo, emails);
	}

	public void clickOnCc() throws Exception {
		By linkCc = By.xpath("//span[text()='Cc']");
		gen.clickElement(linkCc);
	}

	public void enterCcEmails(String emails) throws Exception {
		By textboxCc = By.xpath("//textarea[@name='cc']");
		gen.inputText(textboxCc, emails);
	}

	public void clickOnBcc() throws Exception {
		By linkBcc = By.xpath("//span[text()='Bcc']");
		gen.clickElement(linkBcc);
	}

	public void enterBccEmails(String emails) throws Exception {
		By textboxBcc = By.xpath("//textarea[@name='bcc']");
		gen.inputText(textboxBcc, emails);
	}

	public void enterPartialEmail(String partialEmail, String Name) throws Exception {
		By textboxTo = By.xpath("//textarea[@name='to']");
		gen.inputText(textboxTo, partialEmail);
		Thread.sleep(4000);
		By textSuggested = By.xpath("//div[text()='" + Name + "']");
		gen.clickElement(textSuggested);
	}

	public void addSubject(String subject) throws Exception {
		By textboxSubject = By.xpath("//input[@name='subjectbox']");
		gen.inputText(textboxSubject, subject);
	}

	public void addEmailText(String emailBody) throws Exception {
		By textBoxEmail = By.xpath("//div[@role='textbox']");
		gen.inputText(textBoxEmail, emailBody);
	}

	public void addAttachment(String path) throws Exception {
		By linkAttach = By.xpath("//input[@name='Filedata']");
		gen.inputText(linkAttach, path);
	}

	public void clickOnSignature() throws Exception {
		By linkSignature = By.xpath("//div[@class='BP aaA aMZ']");
		gen.clickElement(linkSignature);
	}

	public void addSignature(String SignatureName) throws Exception {
		By linkAddSign = By.xpath("//div[text()='" + SignatureName + "']");
		gen.clickElement(linkAddSign);
	}

	public boolean Noemailerror() {
		By errmsg = By.xpath("//div[text()='Please specify at least one recipient.']");
		boolean result = driver.findElement(errmsg).isDisplayed();
		return result;
	}

	public void clickOnSend() throws Exception {
		By sendLink = By.xpath("//div[text()='Send']");
		gen.clickElement(sendLink);
	}

	public void ClickOnCloseComposeBox() throws Exception {
		By btnClose = By.xpath("//img[@alt='Close']");
		gen.clickElement(btnClose);
	}

	public void ClickOkOnErrMsgBox() throws Exception {
		By btnOk = By.xpath("//button[text()='OK']");
		gen.clickElement(btnOk);
	}

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

	public void selectFont(String Fontname) throws Exception {
		By textBoxEmail = By.xpath("//div[@role='textbox']");
		gen.clickElement(textBoxEmail);

		By dropdn = By.xpath("//div[@command='+fontName']");
		gen.clickElement(dropdn);

		By font = By.xpath("//div[text()='" + Fontname + "']");
		gen.clickElement(font);

	}

}
