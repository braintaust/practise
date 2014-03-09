package practisefour;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import seleniumpractise.Browser;
import seleniumpractise.BrowserTypes;
import seleniumpractise.ParseProperties;
import seleniumpractise.WaitElement;

/**
 * ��ҵ�ݸ����ж�����ʾ�ĸ����Ƿ������Ǵ򿪵Ĳݸ�����Ÿ���һ�£���browsers��,assert,wait��
 * @author zhengtenglong
 *
 */
public class HomeWork {
	private Browser browser;
	private WebDriver driver;
	private WaitElement wait;
	private ParseProperties pp;
	
	
	@BeforeClass
	public void start(){
		browser = new Browser(BrowserTypes.firefox);
		driver = browser.getDriver();
	} 
	
	@Parameters({"ItemData"})
	@Test
	public void Test(@Optional("aaa")String itemdata){
		pp = new ParseProperties(System.getProperty("user.dir")+itemdata);
		driver.get(pp.getValue("url"));
		wait.waitElementVisibility(By.id("idInput"));
		driver.findElement(By.id("idInput")).sendKeys(pp.getValue("username"));
		driver.findElement(By.id("pwdInput")).sendKeys(pp.getValue("password"));
		wait.waitForElementPresent("//span[@title = '�ݸ���']");
		driver.findElement(By.xpath("//span[@title = '�ݸ���']")).click();
		WebElement e = driver.findElement(By.xpath("//span[@title = '�ݸ���']/following-sibling::span"));
		String num = e.getText().substring(1, 2);
		List<WebElement> list = driver.findElements(By.xpath("//b[@sign='logo' and @title='�ݸ�']"));
		int n = list.size();
		Assert.assertEquals(num, n);
	}
	
	@AfterClass
	public void end(){
		driver.close();
	}
}
