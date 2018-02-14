package automationPracticeSiteTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DressesPage {
	@FindBy(css = "#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.left-block > div > a.product_img_link > img")
	private WebElement m_printedDress1Image;
	
	
	@FindBy(css = "#ul_layered_id_feature_5 > li:nth-child(3) > label > a")
	private WebElement m_compositionsViscoseFilter;
	
	@FindBy(css = "#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.left-block > div > a.quick-view > span")
	private WebElement m_printedDress1ImageQuickView;
	
	@FindBy(css = "#ul_layered_id_feature_6 > li:nth-child(2) > label > a")
	private WebElement m_stylesDressyFilter;
	
	
	@FindBy(css = "#center_column > ul > li > div > div.left-block > div > a.product_img_link > img")
	private WebElement m_ViscoseDressyDressImage;
	
	public String clickPrintedDress1Image()
	{
		m_printedDress1Image.click(); 
		return "The dress image was seleced";
	}
	
	public String clickCompositionsViscoseFilter()
	{
		m_compositionsViscoseFilter.click();
		return "The Viscose filter in the  Compositions section was seleced";
	}
	
	public String clickStylesDressyFilter()
	{
		m_stylesDressyFilter.click();
		return "The Dressy filter in the Styles section was seleced";
	}
	
	public String clickPrintedDress1ImageQuickView()
	{
		m_printedDress1ImageQuickView.click();
		return "The quick view of the dress image was seleced";
	}
	
	public String clickViscoseDressyDressImage()
	{
		m_ViscoseDressyDressImage.click();
		return "The dress image was seleced";
	}
	
}
