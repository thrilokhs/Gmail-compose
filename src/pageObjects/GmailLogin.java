package pageObjects;

import org.openqa.selenium.By;
import helper.Base;
import helper.Generic;

public class GmailLogin extends Base {

	Generic gen = new Generic();
	
	By logoutmenu = By.xpath("//img[@class='gb_Da gbii']");
	
	By btnsignout = By.xpath("//a[text()='Sign out']");
	

	public void enterEmail() throws Exception
	{
		By emailid = By.xpath("//input[@type='email']");
		gen.inputText(emailid, "3lokhs37@gmail.com");
	}
	
	public void clickNext() throws Exception
	{
		By next = By.xpath("//div[@class='VfPpkd-RLmnJb']");
		gen.clickElement(next);
	}
	
	public void enterPassword() throws Exception
	{
		By password = By.xpath("//input[@type='password']");
		gen.inputText(password, "Passw0rd123$");
	}
	
	public void clickAltLogin() throws Exception
	{
		By altlogin = By.xpath("//a[@class='login-link s-btn s-btn__filled py8 js-gps-track']");
		gen.clickElement(altlogin);
	}
	
	public void clickLoginWithGoogle() throws Exception
	{
		By loginwithgoogle = By.xpath("//button[@data-provider='google']");
		gen.clickElement(loginwithgoogle);
	}
	
	
	public void Login() throws Exception {
		
		driver.navigate().to("https://stackoverflow.com/");
		this.clickAltLogin();
		this.clickLoginWithGoogle();;
		this.enterEmail();
		this.clickNext();
		this.enterPassword();
		this.clickNext();
		driver.get("https://mail.google.com/mail/u/0/#inbox");
		Thread.sleep(2000);
		driver.get("https://mail.google.com/mail/u/0/#inbox");
	}
	
	public void Logout() throws Exception
	{   
        gen.clickElement(logoutmenu);
        Thread.sleep(2000);
        gen.clickElement(btnsignout);
	}

}
