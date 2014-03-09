package seleniumpractise;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitElement {
	private WebDriver driver;
	
	public WaitElement(WebDriver driver){
		this.driver = driver;
	}
	
	public void waitElementVisibility(By by){
		
		(new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(by));	
	}
	
	
	public void waitForElementPresent(String locator){
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
			
	public void waitForElementIsEnable(String locator){
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}
	
	public void waitFor(long timeout){
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
