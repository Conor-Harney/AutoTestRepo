package testingweek;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	private WebDriver webDriver;
	private static final String BASE_URL = "http://thedemosite.co.uk";
	@BeforeClass
	public static void init()
	{
		System.out.println("Before Class");
	}
	
	@Before
	public void setup()
	{
		webDriver = new ChromeDriver();
		webDriver.navigate().to(BASE_URL + "/addauser.php");
		System.out.println("Before");
	}
	
	@Test
	public void openLogin()
	{
		
		try {
			TimeUnit.MICROSECONDS.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement cursor = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		cursor.sendKeys("johndoe5555");
		cursor = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		cursor.sendKeys("johndoe1");
		cursor = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		cursor.click();
		
		webDriver.navigate().to(BASE_URL + "/login.php");
		try {
			TimeUnit.MICROSECONDS.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cursor = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		cursor.sendKeys("johndoe5555");
		cursor = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		cursor.sendKeys("johndoe1");
		cursor = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		cursor.click();
		try {
			TimeUnit.MICROSECONDS.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cursor = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));
		assertEquals(cursor.getText(), "**Successful Login**");
		
	}
	
	@After
	public void cleanup()
	{
		webDriver.quit();
		System.out.println("After ");
	}
	
	@AfterClass
	public static void tearDown()
	{
		
		System.out.println("After Class");
	}
}
