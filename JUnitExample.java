package testingweek;

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


public class JUnitExample {
	
	private WebDriver webDriver;
	private static final String BASE_URL = "https://www.qa.com";
	@BeforeClass
	public static void init()
	{
		System.out.println("Before Class");
	}
	
	@Before
	public void setup()
	{
		webDriver = new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
		System.out.println("Before");
	}
	
	@Test
	public void internet()
	{
		try {
			TimeUnit.MICROSECONDS.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement searchOption = webDriver.findElement(By.cssSelector("#select2-chosen-2"));
		searchOption.sendKeys("the shafeeq");
		System.out.println("Test");
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
