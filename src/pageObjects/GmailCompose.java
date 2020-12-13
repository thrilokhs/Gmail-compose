package pageObjects;

import org.openqa.selenium.By;
import helper.Base;
import helper.Generic;

public class GmailCompose extends Base {
	Generic gen = new Generic();
	
	public void clickCompose(String deviceName) throws Exception {
		By LinkCompose = By.xpath("//li[@class='chapternav-item chapternav-item-" + deviceName + "']");
		gen.clickElement(LinkCompose);
	}
	
	public void enterToEmail(String emails) throws Exception {
		By TextboxTo = By.xpath("//textarea[@name='to']");
		gen.inputText(TextboxTo, emails);
	}
	
	public void clickOnCc() throws Exception {
		By LinkCc = By.xpath("//span[text()='Cc']");
		gen.clickElement(LinkCc);
	}
	
	public void enterCcEmails(String emails) throws Exception {
		By TextboxCc = By.xpath("//textarea[@name='cc']");
		gen.inputText(TextboxCc, emails);
	}
	
	public void clickOnBcc() throws Exception {
		By LinkBcc = By.xpath("//span[text()='Bcc']");
		gen.clickElement(LinkBcc);
	}
	
	public void enterBccEmails(String emails) throws Exception {
		By TextboxBcc = By.xpath("//textarea[@name='bcc']");
		gen.inputText(TextboxBcc, emails);
	}
	
	public void enterPartialEmail(String partialemail, String Name) throws Exception {
		By TextboxTo = By.xpath("//textarea[@name='to']");
		gen.inputText(TextboxTo, partialemail);
		Thread.sleep(4000);
		By TextSuggested = By.xpath("//div[text()='" + Name + "']");
		gen.clickElement(TextSuggested);
	}
	
	public void addSubject(String subject) throws Exception {
		By TextboxSubject = By.xpath("//input[@name='subjectbox']");
		gen.inputText(TextboxSubject,subject );
	}
	
	public void addEmailText(String emailBody) throws Exception {
		By TextBoxEmail = By.xpath("//div[@role='textbox']");
		gen.inputText(TextBoxEmail,emailBody );
	}
	
	public void addAttachment(String path) throws Exception {
		By LinkAttach = By.xpath("//input[@name='Filedata']");
		gen.inputText(LinkAttach,path );
	}
	
	public void clickOnSignature() throws Exception {
		By LinkSignature = By.xpath("//div[@class='BP aaA aMZ']");
		gen.clickElement(LinkSignature);
	}
	
	public void addSignature(String SignatureName) throws Exception {
		By LinkAddSign = By.xpath("//div[text()='" + SignatureName + "']");
		gen.clickElement(LinkAddSign);
	}
	
	public boolean Noemailerror()
	{
		By errmsg = By.xpath("//div[text()='Please specify at least one recipient.']");
		boolean result = driver.findElement(errmsg).isDisplayed();
		return result;
	}
	
	public void clickOnSend() throws Exception {
		By SendLink = By.xpath("//div[text()='Send']");
		gen.clickElement(SendLink);
	}
	
	public void ClickOnCloseComposeBox() throws Exception {
		By BtnClose	 = By.xpath("//img[@alt='Close']");
		gen.clickElement(BtnClose);
	}
	
	public void ClickOkOnErrMsgBox() throws Exception {
		By BtnOk = By.xpath("//button[text()='OK']");
		gen.clickElement(BtnOk);
	}
	
	public void scheduleSend(String DDBMMMBYYYY, String HHBMMBAMPM) throws Exception {
		By Dropdn = By.xpath("//div[@class='G-asx']");
		gen.clickElement(Dropdn);
		
		By LinkSS = By.xpath("//div[@selector='scheduledSend']");
		gen.clickElement(LinkSS);
		
		By LinkPickDate = By.xpath("//div[text()='Pick date & time']");
		gen.clickElement(LinkPickDate);
		
		Thread.sleep(2000);
		
		//By TextDate = By.xpath("//input[@class='hu jA']");
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
		//driver.findElement(By.xpath("//input[@class='hu ks']")).clear();
		//gen.inputText(TextTime, "Keys.chord(Keys.CONTROL,\"a\", Keys.DELETE)");
		Thread.sleep(4000);
//		gen.inputText(TextTime, "Keys.CONTROL + \"a\"");
//		Thread.sleep(4000);
//		gen.inputText(TextTime, "Keys.DELETE");
//		Thread.sleep(4000);
		gen.inputText(TextTime,HHBMMBAMPM);
		Thread.sleep(4000);
			
		By BtnSS = By.xpath("//button[text()='Schedule send']");
		driver.findElement(By.xpath("//button[text()='Schedule send']"));
		gen.clickElement(BtnSS);
		
	}
	
	public void selectFont(String Fontname) throws Exception {
		By TextBoxEmail = By.xpath("//div[@role='textbox']");
		gen.clickElement(TextBoxEmail);
		
		By Dropdn = By.xpath("//div[@command='+fontName']");
		gen.clickElement(Dropdn);
		
		By Font = By.xpath("//div[text()='" + Fontname + "']");
		gen.clickElement(Font);
		
	}
	
}
