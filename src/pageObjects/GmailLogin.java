package pageObjects;

import org.openqa.selenium.By;
import helper.Base;
import helper.Generic;

public class GmailLogin extends Base {

	Generic gen = new Generic();

	By logoutMenu = By.xpath("//img[@class='gb_Da gbii']");

	By btnSignout = By.xpath("//a[text()='Sign out']");

	// This enters the email address to be logged in
	public void enterEmail() throws Exception {
		By emailId = By.xpath("//input[@type='email']");
		gen.inputText(emailId, "3lokhs37@gmail.com");
	}

	// This clicks on the Next button after entering the email/password
	public void clickNext() throws Exception {
		By next = By.xpath("//div[@class='VfPpkd-RLmnJb']");
		gen.clickElement(next);
	}

	// This enters the corresponding password for the email id to be logged in
	public void enterPassword() throws Exception {
		By password = By.xpath("//input[@type='password']");
		gen.inputText(password, "Passw0rd123$");
	}

	// This clicks on the login button of the stackoverflow website
	// Since gmail has restriction to allow login, as a workaround, a login session
	// is created here
	public void clickAltLogin() throws Exception {
		By altLogin = By.xpath("//a[@class='login-link s-btn s-btn__filled py8 js-gps-track']");
		gen.clickElement(altLogin);
	}

	// This selects and clicks the Loginwith google button of stackoverflow login
	// page
	public void clickloginWithGoogle() throws Exception {
		By loginWithGoogle = By.xpath("//button[@data-provider='google']");
		gen.clickElement(loginWithGoogle);
	}

	// This creates a login session through stackoverflow.com and takes to the logged
	// in Gmail dashboard page of the user
	public void Login() throws Exception {

		driver.navigate().to("https://stackoverflow.com/");
		this.clickAltLogin();
		this.clickloginWithGoogle();
		;
		this.enterEmail();
		this.clickNext();
		this.enterPassword();
		this.clickNext();
		driver.get("https://mail.google.com/mail/u/0/#inbox");
		Thread.sleep(2000);
		driver.get("https://mail.google.com/mail/u/0/#inbox");
	}

	// This logs out the user session
	public void Logout() throws Exception {
		gen.clickElement(logoutMenu);
		Thread.sleep(2000);
		gen.clickElement(btnSignout);
	}

}
