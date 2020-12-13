package helper;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Generic extends Base {
	
	public boolean clickElement(By by) throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(by));
			if ((e1.isDisplayed() && e1.isEnabled())) {
				e1.click();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	
	public boolean inputText(By by, String data) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(by));
			if (e1.isDisplayed()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(e1).click().build().perform();
				e1.clear();
				e1.sendKeys(data);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean VerifyText(String Expected, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		String Actual = driver.findElement(by).getText().trim();
		if (Actual.equalsIgnoreCase(Expected)) {
			return true;
		} else {
			return false;
		}
	}
}
