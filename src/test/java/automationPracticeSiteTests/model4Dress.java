package automationPracticeSiteTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class model4Dress {
	
	
	@FindBy(css = "#product_reference > span")
	private WebElement m_modelName;
	
	public String getModelName()
	{
		return m_modelName.getText();
	}
}
