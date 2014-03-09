package practisefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import seleniumpractise.Browser;
import seleniumpractise.BrowserTypes;
import seleniumpractise.ParseProperties;

public class TestProperties {
	    Browser browser;
	    WebDriver driver;
		@BeforeClass
		public void start(){
			browser = new Browser(BrowserTypes.firefox);
			driver = browser.getDriver();
		}

		@Parameters({"TestData"})
		@Test
		public void test(@Optional("aaa") String testdata){
			ParseProperties pp = new ParseProperties(System.getProperty("user.dir")+"testdata");
			driver.get(pp.getValue("url"));
			driver.findElement(By.id("idInput")).sendKeys(pp.getValue("username"));
			driver.findElement(By.id("pwdInput")).sendKeys(pp.getValue("password"));
			driver.findElement(By.id("loginBtn")).submit();
			
		}
		
		@AfterClass
		public void Quit(){
			driver.close();
		}
		

}
