package Testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import helper.Base;
import pageObjects.GmailCompose;
import pageObjects.GmailDashboard;
import org.apache.commons.validator.routines.EmailValidator;

public class SendEmail extends Base {
	GmailDashboard dashboard = new GmailDashboard();
	GmailCompose compose = new GmailCompose();
	
	String Emailbody = "Hello, Wishing you a Merry Christmast and happy new year 2021";
	
	String Subject1 = "Email1";
	String Subject2 = "Email2";
	String Subject3 = "Email3";
	
	String Toemail = "3loktestid@gmail.com";
	String Ccemail = "3lokhs37@gmail.com";
	String Bccemail = "3lokhs37+1@gmail.com";
	
	@Ignore
	@Test(description = "Sending a simple email with To address")
	public void send_email_with_to_address() throws Exception
	{
		dashboard.clickOnCompose();
		boolean valid = EmailValidator.getInstance().isValid(Toemail);
		Assert.assertTrue(valid);
		compose.enterToEmail(Toemail);
		compose.addSubject(Subject1);
		compose.selectFont("Wide");
		compose.addEmailText(Emailbody);
		compose.clickOnSend();
	}
	
	@Test(description = "Selecting email from the auto populated list ")
	public void select_email_from_the_dynamic_suggestion() throws Exception
	{
		dashboard.clickOnCompose();
		compose.enterPartialEmail("3lok", "Thrilok HS");
		compose.addSubject(Subject2);
		compose.addEmailText(Emailbody);
		compose.clickOnSend();
	}
	
	@Ignore
	@Test(description = "Sending an email containing addresses in To,Cc & Bcc along with an attachment")
	public void send_email_with_To_Cc_Bcc_and_attachment() throws Exception
	{
		dashboard.clickOnCompose();
		compose.enterToEmail(Toemail);
		compose.clickOnCc();
		compose.enterCcEmails(Ccemail);
		compose.clickOnBcc();
		compose.enterBccEmails(Bccemail);
		driver.findElement(By.xpath("//input[@name='Filedata']")).sendKeys("/Users/t.somashekar/Downloads/Netmob running.png"); // Do not work from PageObject
		compose.addSubject(Subject2);
		compose.addEmailText(Emailbody);
		compose.clickOnSend();
	}
	
	@Ignore
	@Test(description = "Scheduling an email to the future date and time")
	public void schedule_email_to_future_date() throws Exception
	{
		dashboard.clickOnCompose();
		compose.enterToEmail(Toemail);
		compose.addSubject(Subject3);
		compose.addEmailText(Emailbody);
		compose.scheduleSend("18 Dec 2020", "11:50 PM");
	}
	
	@Ignore
	@Test(description = "Send an email By adding a Signature")
	public void send_email_by_inserting_signature() throws Exception
	{
		dashboard.clickOnCompose();
		compose.enterToEmail(Ccemail);
		compose.addSubject(Subject3);
		compose.addEmailText(Emailbody);
		compose.clickOnSignature();
		compose.addSignature("Work");
		compose.clickOnSend();
	}
	
	@Ignore
	@Test(description = "To Check if the email is received by the recipient", dependsOnMethods = {"send_email_with_to_address"})
	public void verify_email_delivery() throws Exception
	{
		boolean emailrecvstatus = dashboard.verifyinbox(Subject3);
		Assert.assertTrue(emailrecvstatus);
	}
	
	@Ignore
	@Test(description = "Checks the error message when trying to send with no email ids")
	public void no_recepients_added() throws Exception
	{
		dashboard.clickOnCompose();
		compose.addSubject(Subject1);
		compose.addEmailText(Emailbody);
		compose.clickOnSend();
		boolean errmsg = compose.Noemailerror();
		Assert.assertTrue(errmsg);
		Thread.sleep(2000);
		compose.ClickOkOnErrMsgBox();
		compose.ClickOnCloseComposeBox();
	}
}
