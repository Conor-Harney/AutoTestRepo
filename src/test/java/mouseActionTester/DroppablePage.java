package mouseActionTester;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DroppablePage {
	//default functionality 
	@FindBy(css = "#draggableview")
	private WebElement m_defaultDragableView;
	
	@FindBy(css = "#droppableview > p")
	private WebElement m_defaultTargetOutput;
	
	public String clickAndHoldefaultDragableView(Actions mouseLst)
	{
		mouseLst.clickAndHold(m_defaultDragableView).perform();
		return "defaultDragableView held";
	}
	public String dragToDefaultTarget(Actions mouseLst)
	{
		mouseLst.moveToElement(m_defaultTargetOutput).perform();
		return "Mouse draaged to default target";
	}
	public String releaseMouse(Actions mouseLst)
	{
		mouseLst.release().perform();
		return "Action released";
	}
	public String getDefaultTargetText()
	{
		return m_defaultTargetOutput.getText().toString();
	}
	
	
	//accept functionality
	@FindBy(css = "#ui-id-2")
	private WebElement m_AcceptBtn;
	
	@FindBy(css = "#draggable-nonvalid")
	private WebElement m_DragableNotDropableView;
	
	@FindBy(css = "#draggableaccept")
	private WebElement m_DdragableAndDropableView;
	
	@FindBy(css = "#droppableaccept")
	private WebElement m_acceptTarget;
	
	@FindBy(css = "#droppableaccept > p")
	private WebElement m_acceptTargetOutput;
	
	public String clickAcceptBtn()
	{
		m_AcceptBtn.click();
		return "Accept tab selected";
	}
	
	public String clickAndHolAcceptDragableAndDroppableView(Actions mouseLst)
	{
		mouseLst.clickAndHold(m_DdragableAndDropableView).perform();
		return "Ddragable And Dropable View held";
	}
	public String clickAndHolAcceptDragableNotDroppableView(Actions mouseLst)
	{
		mouseLst.clickAndHold(m_DragableNotDropableView).perform();
		return "Dragable Not, Dropable View held";
	}
	
	public String dragToAcceptTarget(Actions mouseLst)
	{
		mouseLst.moveToElement(m_acceptTargetOutput).perform();
		return "Mouse draaged to accept target";
	}
	
	public String getAcceptTargetText()
	{
		return m_acceptTargetOutput.getText().toString();
	}
	
	//prevent propagation 
	
	@FindBy(css = "#ui-id-3")
	private WebElement m_pvttpropBtn;
	
	@FindBy(css = "#draggableprop")
	private WebElement m_pvttpropDragableView;
	
	@FindBy(css = "#droppableprop")
	private WebElement m_pvttpropNonGreedyOtr;
	
	@FindBy(css = "#droppable-inner")
	private WebElement m_pvttpropNonGreedyInner;

	@FindBy(css = "#droppableprop2")
	private WebElement m_pvttpropGreedyOtr;
	
	@FindBy(css = "#droppable2-inner")
	private WebElement m_pvttpropGreedyInner;
	
	@FindBy(css = "#droppableprop > p")
	private WebElement m_pvttpropNonGreedyTargetOutput;
	
	@FindBy(css = "#droppableprop2 > p")
	private WebElement m_pvttpropGreedyTargetOutput;
	
	public String clickPvttpropgBtn()
	{
		m_pvttpropBtn.click();
		return "Prevent Propagate tab selected";
	}
	
	public String clickAndHolPvttpropDragableView(Actions mouseLst)
	{
		mouseLst.clickAndHold(m_pvttpropDragableView).perform();
		return "Prevent propagate dragable view held";
	}
	public String dragToPvttpropNonGreedyOtrTarget(Actions mouseLst)
	{
		mouseLst.moveToElement(m_pvttpropNonGreedyOtr).perform();
		return "Mouse draaged to prevent propagation Non greedy outter target";
	}
	public String dragToPvttpropGreedyOtrTarget(Actions mouseLst)
	{
		mouseLst.moveToElement(m_pvttpropGreedyOtr).perform();
		return "Mouse draaged to prevent propagation greedy outter target";
	}
	public String dragToPvttpropNonGreedyInnerTarget(Actions mouseLst)
	{
		mouseLst.moveToElement(m_pvttpropNonGreedyInner).perform();
		return "Mouse draaged to prevent propagation Non greedy Inner target";
	}
	public String dragToPvttpropGreedyInnerTarget(Actions mouseLst)
	{
		mouseLst.moveToElement(m_pvttpropGreedyInner).perform();
		return "Mouse draaged to prevent propagation greedy Inner target";
	}
	
	public String getpvttpropGreedyTargetText()
	{
		return m_pvttpropGreedyTargetOutput.getText().toString();
	}
	
	public String getpvttpropNonGreedyTargetText()
	{
		return m_pvttpropNonGreedyTargetOutput.getText().toString();
	}
	
}
