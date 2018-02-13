package testingweek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	// login page
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
	private WebElement m_loginUNameTF;

	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
	private WebElement m_loginUPassTF;

	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
	private WebElement m_loginBtn;
	
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b")
	private WebElement m_successStateTxt;
	
	
	
	
	public void sendUNameToLogin(String userName)
	{
		m_loginUNameTF.sendKeys(userName);
	}
	
	public void sendPassToCLogin(String password)
	{
		m_loginUPassTF.sendKeys(password);
	}
	
	public void clickLoginBtn()
	{
		m_loginBtn.click();
	}
	
	public String getSuccessField()
	{
		return m_successStateTxt.getText();
	}
	
	

}
