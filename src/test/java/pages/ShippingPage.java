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

public class ShippingPage extends CustomLoadableComponent<ShippingPage>
{

	private BasePage base;
	private WebDriver driver;

	public ShippingPage(WebDriver driver)
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
		base=new BasePage(driver);
		this.driver=driver;
	}
	
	
	//Page Elements
	@FindBy(xpath="//span[@class='navigation_page' and text()='Shipping']")
	private WebElement pageHeading;

	@FindBy(id="cgv")
	private WebElement chkTermsCond;
	
	@FindBy(name="processCarrier")
	private WebElement processCarrier;
	
	
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
			throw new Error ("Shipping page is not loaded");
		}
	}
	
	
	//Page services
	public ShippingPage acceptTermsCondition()
	{
		base.scrollToElement(chkTermsCond);
		base.checkbox(chkTermsCond);
		return this;
	}
	
	public PaymentPage shippingCheckout()
	{
		base.click(processCarrier);
		return new PaymentPage(driver).get();		
	}
	
}
