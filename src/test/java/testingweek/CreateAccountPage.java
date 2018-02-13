package testingweek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage {

	// create account page
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
	private WebElement m_createAccUNameTF;

	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
	private WebElement m_createAccUPassTF;

	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
	private WebElement m_createAccCreateBtn;
	
	@FindBy(css = "body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")
	private WebElement m_nextPageLink;
	
	public void sendUNameToCreateAcc(String userName)
	{
		m_createAccUNameTF.sendKeys(userName);
	}
	
	public void sendPassToCreateAcc(String pass)
	{
		m_createAccUPassTF.sendKeys(pass);
	}
	
	public void clickCreateAccBtn()
	{
		m_createAccCreateBtn.click();
	}
	
	public void goToLogin()
	{
		 m_nextPageLink.click();
	}
	

}
