package pageObjects;

import org.openqa.selenium.By;
import helper.Base;
import helper.Generic;

public class GmailLogin extends Base {

	Generic generic = new Generic();

	By logoutMenu = By.xpath("//img[@class='gb_Da gbii']");
	By btnSignout = By.xpath("//a[text()='Sign out']");
	By txtEmail = By.xpath("//input[@type='email']");
	By next = By.xpath("//div[@class='VfPpkd-RLmnJb']");
	By TxtPassword = By.xpath("//input[@type='password']");
	By altLogin = By.xpath("//a[@class='login-link s-btn s-btn__filled py8 js-gps-track']");
	By loginWithGoogle = By.xpath("//button[@data-provider='google']");

	// This enters the email address to be logged in
	public void enterEmail(String emailid) throws Exception {
		generic.inputText(txtEmail, emailid);
	}

	// This clicks on the Next button after entering the email/password
	public void clickNext() throws Exception {
		generic.clickElement(next);
	}

	// This enters the corresponding password for the email id to be logged in
	public void enterPassword(String password) throws Exception {
		generic.inputText(TxtPassword, password);
	}

	// This clicks on the login button of the stackoverflow website
	// Since gmail has restriction to allow login, as a workaround, a login session
	// is created here
	public void clickAltLogin() throws Exception {
		generic.clickElement(altLogin);
	}

	// This selects and clicks the Loginwith google button of stackoverflow login
	// page
	public void clickloginWithGoogle() throws Exception {
		generic.clickElement(loginWithGoogle);
	}

	// This creates a login session through stackoverflow.com and takes to the
	// logged
	// in Gmail dashboard page of the user
	public void Login(String emailid, String password) throws Exception {

		driver.navigate().to("https://stackoverflow.com/");
		this.clickAltLogin();
		this.clickloginWithGoogle();
		this.enterEmail(emailid);
		this.clickNext();
		this.enterPassword(password);
		this.clickNext();
		Thread.sleep(2000);// sleep is used to wait for the gmail session to be established
		driver.get("https://mail.google.com/mail/u/0/#inbox");
	}

	// This logs out the user session
	public void Logout() throws Exception {
		generic.clickElement(logoutMenu);
		generic.clickElement(btnSignout);
	}

}
