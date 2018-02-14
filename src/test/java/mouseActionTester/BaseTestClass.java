package mouseActionTester;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class BaseTestClass {
	
	private static ExtentReports report;
	private static WebDriver webDriver;
	private static String BASE_URL;
	private static Workbook m_inputWorkbook;
	public static final String SHEET_NAME = "Sheet1";
	private static int m_rowToOperateOn = 0;
	private static final String WORK_BOOK_NAME = "example.xlsx";
	
	@BeforeClass
	public static void init()
	{
		String workbookFilePath = System.getProperty("user.dir") + File.separatorChar + "Workbooks" + File.separatorChar + WORK_BOOK_NAME;
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
        BASE_URL = readRow(1, SHEET_NAME).get(0);
        report = new ExtentReports();
		String repFilePath = readRow(1, SHEET_NAME).get(1);
		repFilePath = System.getProperty("user.dir") + File.separatorChar + "Reports" + File.separatorChar +repFilePath;
		report.attachReporter(new ExtentHtmlReporter(repFilePath));
	}
	
	@Before
	public void setup()
	{
		webDriver = new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
	}
	
	@Test
	public void test()
	{
		m_rowToOperateOn = 1;
		ExtentTest extTest = report.createTest(readRow(m_rowToOperateOn, SHEET_NAME).get(2));
		extTest.log(Status.INFO, "the test has started");
		try {TimeUnit.SECONDS.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		//Page indexPage = PageFactory.initElements(webDriver, Page.class);
		try {
			//assertEquals(readRow(m_rowToOperateOn, SHEET_NAME).get(3), //page.getCondition);
			extTest.pass(readRow(m_rowToOperateOn, SHEET_NAME).get(4));
		}
		catch(AssertionError e)
		{
			extTest.fail(readRow(m_rowToOperateOn, SHEET_NAME).get(5));
		}
	}
	
	@After
	public void cleanup()
	{
		webDriver.quit();
	}
	
	@AfterClass
	public static void tearDown()
	{
		
		report.flush();
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
