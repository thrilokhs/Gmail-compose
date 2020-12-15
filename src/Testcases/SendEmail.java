package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import helper.Base;
import pageObjects.GmailCompose;
import pageObjects.GmailDashboard;
import org.apache.commons.validator.routines.EmailValidator;

public class SendEmail extends Base {
	GmailDashboard dashBoard = new GmailDashboard();
	GmailCompose compose = new GmailCompose();

	String Emailbody = "Hello, Wishing you a Merry Christmas and happy new year 2021";

	String Subject1 = "Email1";
	String Subject2 = "Email2";
	String Subject3 = "Email3";

	String toEmail = "3loktestid@gmail.com";
	String ccEmail = "3lokhs37@gmail.com";
	String bccEmail = "3lokhs37+1@gmail.com";

	@Test(description = "Selecting an email from the auto suggested list ")
	public void select_email_from_the_dynamic_suggestion() throws Exception {
		dashBoard.clickOnCompose();
		compose.enterPartialEmail("3lok", "Thrilok Two");
		compose.enterSubject(Subject2);
		compose.selectFont("Wide");
		compose.enterEmailText(Emailbody);
		compose.clickOnSend();
	}

	@Test(description = "Sends email using To, Cc & Bcc along with an attachment")
	public void send_email_with_To_Cc_Bcc_and_attachment() throws Exception {
		dashBoard.clickOnCompose();
		compose.enterToEmail(toEmail);
		compose.clickOnCc();
		compose.enterCcEmails(ccEmail);
		compose.clickOnBcc();
		compose.enterBccEmails(bccEmail);
		String pwd = System.getProperty("user.dir"); // to get the present working directory
		compose.addAttachment(pwd + "/resources/attachment.doc"); // fetches the attachment stored in the resource
																	// folder
		compose.enterSubject(Subject2);
		compose.enterEmailText(Emailbody);
		compose.clickOnSend();
	}

	@Test(description = "Scheduling an email to next Monday + Inserting Signature")
	public void schedule_send_with_signature() throws Exception {
		dashBoard.clickOnCompose();
		compose.enterToEmail(toEmail);
		compose.enterSubject(Subject3);
		compose.enterEmailText(Emailbody);
		compose.clickOnSignature();
		compose.addSignature("Work"); // Provide the Signature label that needs to be chosen
		compose.scheduleSendMonday(); // Email will be sent on the coming Monday
	}

	// This test is dependent on the previous test which sends the email to the
	// logged in email id
	@Test(description = "To Check if the email is received by the recipient", dependsOnMethods = {
			"send_email_with_To_Cc_Bcc_and_attachment" })
	public void verify_email_delivery() throws Exception {
		boolean emailrecvstatus = dashBoard.verifyinbox(Subject3);
		Assert.assertTrue(emailrecvstatus);
	}

	@Test(description = "Checks the error message when trying to send with no email id entered")
	public void no_recepients_added() throws Exception {
		dashBoard.clickOnCompose();
		compose.enterSubject(Subject1);
		compose.enterEmailText(Emailbody);
		compose.clickOnSend();
		Thread.sleep(2000);// sleep is to wait for the pop up to appear to enable assertion read
		boolean errmsg = compose.Noemailerror();
		Assert.assertTrue(errmsg);
		compose.ClickOkOnErrMsgBox();
		compose.ClickOnCloseComposeBox();
		Thread.sleep(2000);// Sleep is needed for draft saving to complete
	}
}
