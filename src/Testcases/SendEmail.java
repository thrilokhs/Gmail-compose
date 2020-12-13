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
	GmailDashboard dashBoard = new GmailDashboard();
	GmailCompose compose = new GmailCompose();

	String Emailbody = "Hello, Wishing you a Merry Christmast and happy new year 2021";

	String Subject1 = "Email1";
	String Subject2 = "Email2";
	String Subject3 = "Email3";

	String toEmail = "3loktestid@gmail.com";
	String ccEmail = "3lokhs37@gmail.com";
	String bccEmail = "3lokhs37+1@gmail.com";

	@Test(description = "Sending a simple email with To address")
	public void send_email_with_to_address() throws Exception {
		dashBoard.clickOnCompose();
		boolean valid = EmailValidator.getInstance().isValid(toEmail);
		Assert.assertTrue(valid);
		compose.enterToEmail(toEmail);
		compose.addSubject(Subject1);
		compose.selectFont("Wide");
		compose.addEmailText(Emailbody);
		compose.clickOnSend();
	}

	@Test(description = "Selecting email from the auto populated list ")
	public void select_email_from_the_dynamic_suggestion() throws Exception {
		dashBoard.clickOnCompose();
		compose.enterPartialEmail("3lok", "Thrilok Two");
		compose.addSubject(Subject2);
		compose.addEmailText(Emailbody);
		compose.clickOnSend();
	}

	@Test(description = "Sending an email containing addresses in To,Cc & Bcc along with an attachment")
	public void send_email_with_To_Cc_Bcc_and_attachment() throws Exception {
		dashBoard.clickOnCompose();
		compose.enterToEmail(toEmail);
		compose.clickOnCc();
		compose.enterCcEmails(ccEmail);
		compose.clickOnBcc();
		compose.enterBccEmails(bccEmail);
		driver.findElement(By.xpath("//input[@name='Filedata']")).sendKeys("/Users/t.somashekar/Downloads/Netmob running.png"); // Do not work from PageObject
		compose.addSubject(Subject2);
		compose.addEmailText(Emailbody);
		compose.clickOnSend();
	}

	@Test(description = "Scheduling an email to the future date and time")
	public void schedule_email_to_future_date() throws Exception {
		dashBoard.clickOnCompose();
		compose.enterToEmail(toEmail);
		compose.addSubject(Subject3);
		compose.addEmailText(Emailbody);
		compose.scheduleSend("18 Dec 2020", "11:50 PM");
	}

	@Test(description = "Send an email By adding a Signature")
	public void send_email_by_inserting_signature() throws Exception {
		dashBoard.clickOnCompose();
		compose.enterToEmail(ccEmail);
		compose.addSubject(Subject3);
		compose.addEmailText(Emailbody);
		compose.clickOnSignature();
		compose.addSignature("Work");
		compose.clickOnSend();
	}

	@Test(description = "To Check if the email is received by the recipient", dependsOnMethods = {
			"send_email_with_to_address" })
	public void verify_email_delivery() throws Exception {
		boolean emailrecvstatus = dashBoard.verifyinbox(Subject3);
		Assert.assertTrue(emailrecvstatus);
	}

	@Ignore
	@Test(description = "Checks the error message when trying to send with no email ids")
	public void no_recepients_added() throws Exception {
		dashBoard.clickOnCompose();
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
