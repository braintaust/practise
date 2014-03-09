package seleniumpractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeWork {
	
	private Browser browser;
	private WebDriver driver;
	
	@BeforeClass
	public void setup(){
		browser = new Browser(BrowserTypes.firefox);
		driver = browser.getDriver();
		driver.get("http://www.126.com");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("BeforeClass");
	}
	
	@Test()
	public void test1(){
		WebElement user = driver.findElement(By.id("idInput"));
		user.clear();
		user.sendKeys("FireflyAutomation");
		WebElement pwd = driver.findElement(By.id("pwdInput"));
		pwd.sendKeys("Firefly");
		WebElement submit = driver.findElement(By.id("loginBtn"));
		submit.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement inputbox = driver.findElement(By.xpath("//div[@id='dvNavTop']/descendant::li[1]"));
		inputbox.click();
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//driver.findElement(By.xpath("//a[@class='relogin' and Contains(text(),'重新登录')]")).click();
		System.out.println("Test1()");
	}
	@Test
	public void test2(){
		WebElement user = driver.findElement(By.id("idInput"));
		user.clear();
		user.sendKeys("FireflyAutomation");
		WebElement pwd = driver.findElement(By.id("pwdInput"));
		pwd.sendKeys("Firefly");
		WebElement submit = driver.findElement(By.id("loginBtn"));
		submit.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement sendbox = driver.findElement(By.xpath("//div[@id='navtree']/ul/li[4]/div"));//span[Contains(text(),'已发送') and ancestor::div[@id='navtree']]
		sendbox.click();
		System.out.println("Test2");
	}
	
	@AfterClass
	public void teardown(){
		WebElement logout =  driver.findElement(By.xpath("//ul[preceding-sibling::h1[@id='h1Logo']]/li[last()]/a"));
		logout.click();
		driver.quit();
		System.out.println("AfterClass");
		
	}
}
