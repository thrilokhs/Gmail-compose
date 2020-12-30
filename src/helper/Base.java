package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pageObjects.GmailLogin;

public class Base {

	// Provide the Gmail account credentials here
	static String emailid = "3lokhs37@gmail.com";
	static String password = "Passw0rd123$";

	public static GmailLogin gl = new GmailLogin();
	public static WebDriver driver;

	@BeforeSuite(description = "This initialises the chromedriver which can be used by all tests")
	public WebDriver initializeDriver() throws Exception {

		System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		return driver;
	}

	@BeforeClass(description = "This logs into the gmail")
	public static void login() throws Exception {
		gl.Login(emailid, password);
	}

	@AfterClass(description = "This logs out from the gmail")
	public static void logout() throws Exception {
		gl.Logout();
	}

	@AfterSuite(description = "This closes the chromedriver")
	public static void closeBrowser() {
		driver.close();
	}
}
