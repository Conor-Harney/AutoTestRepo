package automationPracticeSiteTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product3Page {
	
	@FindBy(css = "#our_price_display")
	private WebElement m_priceElement;
	
	public String getPrice()
	{
		return m_priceElement.getText();
	}
}
