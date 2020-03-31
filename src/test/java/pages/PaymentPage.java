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

public class PaymentPage extends CustomLoadableComponent<PaymentPage>
{

	private BasePage base;
	private WebDriver driver;

	public PaymentPage(WebDriver driver) 
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
		base=new BasePage(driver);
		this.driver=driver;
	}


	//Page Elements
	@FindBy(xpath="//span[@class='navigation_page' and text()='Your payment method']")
	private WebElement pageHeading;

	@FindBy(className="cheque")
	private WebElement cheque;


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
	public OrderSummaryPage selectPayment()
	{
		base.scrollToElement(cheque);
		base.click(cheque);
		return new OrderSummaryPage(driver).get();
	}

}
