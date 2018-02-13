package testingweek;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LoginTestUsingPage {
	private static ExtentReports report;
	private static WebDriver webDriver;
	private static HomePage m_homePage;
	private static CreateAccountPage m_CreateAccPageObj;
	private static LoginPage m_loginPage;
	private static final String BASE_URL = "http://thedemosite.co.uk";

	@BeforeClass
	public static void init() {
		report = new ExtentReports();
		String fileName = "MyReport" + ".html";
		String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
		report.attachReporter(new ExtentHtmlReporter(filePath));
		System.out.println("Before Class");
	}

	@Before
	public void setup() {
		webDriver = new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
		System.out.println("Before");
	}

	@Test
	public void openLogin() {
		ExtentTest test = report.createTest("MyFirstTest");
		test.log(Status.INFO, "Login test has started");
		try {
			TimeUnit.MICROSECONDS.sleep(5000);
			test.log(Status.INFO, "Waited for home page to load");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		m_homePage = PageFactory.initElements(webDriver, HomePage.class);
		m_homePage.GoToLoginPage();
		test.log(Status.INFO, "Navigated to create account page");
		try {
			TimeUnit.MICROSECONDS.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		m_CreateAccPageObj = PageFactory.initElements(webDriver, CreateAccountPage.class);
		m_CreateAccPageObj.sendUNameToCreateAcc("Shafeeq");
		m_CreateAccPageObj.sendPassToCreateAcc("Secret");
		test.log(Status.INFO, "Account details entered");
		m_CreateAccPageObj.clickCreateAccBtn();
		test.log(Status.INFO, "Account details saved");
		m_CreateAccPageObj.goToLogin();
		

		try {
			TimeUnit.MICROSECONDS.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		test.log(Status.INFO, "Navigated to login page");
		m_loginPage = PageFactory.initElements(webDriver, LoginPage.class);
		m_loginPage.sendUNameToLogin("Shafeeq");
		m_loginPage.sendPassToCLogin("Secret");
		test.log(Status.INFO, "Details entered");
		m_loginPage.clickLoginBtn();
		test.log(Status.INFO, "Details submitted");
		File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        
        try {
        	String pathname = System.getProperty("user.dir") + File.separatorChar + "loginSubmittedSct" +".jpg";
			FileUtils.copyFile(scrFile, new File(pathname));
			test.addScreenCaptureFromPath(pathname);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			TimeUnit.MICROSECONDS.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			assertEquals(m_loginPage.getSuccessField(), "**Successful Login**");
			test.pass("The login was successful");
		}
		catch(AssertionError e)
		{
			test.fail("The user was unable to login");
		}
		

	}

	@After
	public void cleanup() {
		webDriver.quit();
		System.out.println("After ");
	}

	@AfterClass
	public static void tearDown() {
		report.flush();
		System.out.println("After Class");
	}
}
