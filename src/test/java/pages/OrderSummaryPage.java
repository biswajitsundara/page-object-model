package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.CustomLoadableComponent;

/**
 * @author Biswajit Sundara
 * @date 31/03/2020
 */

public class OrderSummaryPage extends CustomLoadableComponent<OrderSummaryPage>
{

	private BasePage base;
	private WebDriver driver;

	public OrderSummaryPage(WebDriver driver) 
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
		base=new BasePage(driver);
		this.driver=driver;
	}
	
	
	//Page Elements
	@FindBy(xpath="//h1[text()='Order summary' and @class='page-heading']")
	private WebElement pageHeading;

	@FindBy(xpath="//p[@id='cart_navigation']/child::button[@type='submit']")
	private WebElement btnconfirmOrder;
	
	
	//Loadable component
	@Override
	protected void load()
	{
		
	}

	@Override
	protected void isLoaded() throws Error 
	{
		if(!isElementLoaded(driver,pageHeading)) 
		{
			throw new Error ("Address page is not loaded");
		}
	}
	
	
	//Page services
	public ConfirmOrderPage confirmOrder()
	{
		base.scrollToElement(btnconfirmOrder);
		base.click(btnconfirmOrder);
		return new ConfirmOrderPage(driver).get();
	}
	
}
