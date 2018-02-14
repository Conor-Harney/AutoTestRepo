package automationPracticeSiteTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class indexPage {
	
	@FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
	private WebElement m_signInBtn;
	
	@FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
	private WebElement m_dressesMenuOpt;
	
	
	@FindBy(css = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.left-block > div > a.product_img_link > img")
	private WebElement m_productOne;
	
	public void clickSignIn()
	{
		m_signInBtn.click();
	}
	
	public void clickDressesOption()
	{
		m_dressesMenuOpt.click();
	}
	
	public String clickProductOne()
	{
		m_productOne.click();
		return "Product one image clicked";
	}
	
	public void focusOnDresses(WebDriver webDriver)
	{
		/*Actions action = new Actions(webDriver);
		action.moveToElement(m_dressesMenuOpt).moveToElement(webDriver.findElement(By.xpath("/expression-here"))).click().build().perform();
		
		Actions builder = new Actions(webDriver);
		builder.moveToElement(m_dressesMenuOpt).perform();
		By locator = By.id("clickElementID");
		builder.click(locator);*/
	}
}
