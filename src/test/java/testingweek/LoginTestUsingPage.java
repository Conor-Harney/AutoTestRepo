package testingweek;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	private static Workbook m_inputWorkbook;

	@BeforeClass
	public static void init() {
		String workbookFilePath = System.getProperty("user.dir") + File.separatorChar + "Workbooks" + File.separatorChar + "Book1.xlsx";
		FileInputStream iPutStream = null;
		m_inputWorkbook = null;
        try {
        	iPutStream = new FileInputStream(new File(workbookFilePath));
            m_inputWorkbook = new XSSFWorkbook(iPutStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (iPutStream != null) {
                	iPutStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println(readRow(0, "Sheet1").get(1));
        report = new ExtentReports();
		String repFilePath = "MyReport" + ".html";
		repFilePath = System.getProperty("user.dir") + File.separatorChar + repFilePath;
		report.attachReporter(new ExtentHtmlReporter(repFilePath));
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
		addScreenShot(test, "CreateAccPage");
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
		addScreenShot(test, "loginSubmittedSct");
        /*try {
        	File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        	String pathname = System.getProperty("user.dir") + File.separatorChar + "loginSubmittedSct" +".jpg";
			FileUtils.copyFile(scrFile, new File(pathname));
			test.addScreenCaptureFromPath(pathname);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

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
	
	private static void addScreenShot(ExtentTest et, String screenshotName)
	{
		 try {
	        	File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
	        	String pathname = System.getProperty("user.dir") + File.separatorChar + "Screenshots" + File.separatorChar + screenshotName  +".jpg";
				FileUtils.copyFile(scrFile, new File(pathname));
				et.addScreenCaptureFromPath(pathname);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
	
    public static ArrayList<String> readRow(int rowNum, String sheetName){
        ArrayList<String> returns = new ArrayList<String>();//the current row of the excel sheet
        Sheet curSheet = m_inputWorkbook.getSheet(sheetName);//set to current sheet
        Row currentRow =  curSheet.getRow(rowNum);//set to current row
        
        for (Cell currentCell : currentRow) {
            switch (currentCell.getCellTypeEnum()) {
                case STRING:
                	returns.add(currentCell.getStringCellValue());
                    break;
                case NUMERIC:
                	returns.add(String.valueOf(currentCell.getNumericCellValue()));
                    break;
                case BOOLEAN:
                	returns.add(String.valueOf(currentCell.getBooleanCellValue()));
                    break;
                case BLANK:
                	returns.add(currentCell.getStringCellValue());
                    break;
                case _NONE:
                    System.out.println("No Value in cell");
                    break;
                case ERROR:
                    System.out.println("Error in cell");
                    break;
                case FORMULA:
                	returns.add(currentCell.getCellFormula());
                    break;
            }
        }
        return returns;
    }
}
