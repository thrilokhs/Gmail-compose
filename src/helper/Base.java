package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import pageObjects.GmailLogin;

public class Base {

	public static GmailLogin gl = new GmailLogin();
	public static WebDriver driver;

	@BeforeSuite
	public static WebDriver initializeDriver() throws Exception {
		System.setProperty("webdriver.chrome.driver", "//Users//t.somashekar//Desktop//PER//Work//chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	@BeforeClass
	public static void login() throws Exception {
		gl.Login();
	}

	@AfterClass
	public static void logout() throws Exception {
		gl.Logout();
	}

	@AfterSuite
	public static void closeBrowser() {
		driver.close();
	}
}
