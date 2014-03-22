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
 * 作业草稿箱判段信显示的个数是否与我们打开的草稿箱的信个数一致，用browsers类,assert,wait,无法翻页；
 * @author zhengtenglong
 *
 */
public class HomeWorkFour {
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
		wait = new WaitElement(driver);
		wait.waitForElementPresent(By.id("idInput"));
		driver.findElement(By.id("idInput")).sendKeys(pp.getValue("username"));
		driver.findElement(By.id("pwdInput")).sendKeys(pp.getValue("password"));
		driver.findElement(By.id("loginBtn")).submit();
		wait.waitForElementPresent("//span[@title = '草稿箱']");
		driver.findElement(By.xpath("//span[@title = '草稿箱']")).click();
		WebElement e = driver.findElement(By.xpath("//span[@title = '草稿箱']/following-sibling::span"));
		String num = e.getText().substring(1, e.getText().length()-1);
		int i = Integer.parseInt(num,10);
		List<WebElement> list = driver.findElements(By.xpath("//b[@sign='logo' and @title='草稿']"));
		int n = list.size();
		Assert.assertEquals(i, n);
	}
	
	@AfterClass
	public void end(){
		driver.close();
	}
}



/*
 * 翻页参考
 * totalPagesNum = Integer.valueOf(du.what("totalPages").getText.split("/")[1]);
 * 
 * while(totalPagesNum>=1){
 * 		actualunreadMailsNum = actualunreadMailsNum + du.whats("unreadMails").size();
 * 		try{
 * 			du.what("nextBtn").click();
 * 		}catch(Exception e){
 * 			break;
 * 		}
 * 		totalPagesNum--;
 * }
 * System.out.println("1------:"+inboxunReadMailsNum);
 * System.out.println("2------:"+actualunreadMailsNum);
 * 
 * 
 * 
 */


//result = new String(toConvert.getBytes("ISO-8859-1"), "UTF-8"); 转化字符串编码


