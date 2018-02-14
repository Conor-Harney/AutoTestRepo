package automationPracticeSiteTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductOnePage {
	@FindBy(css = "#add_to_cart > button > span")
	private WebElement m_addToCartbtn;
	
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > h2")
	private WebElement m_successMessage;
	
	
	public String clickAddToCart()
	{
		m_addToCartbtn.click();
		return "item added to cart";
	}
	
	public String getSuccessMessage()
	{
		return m_successMessage.getText();
	}
	
}
