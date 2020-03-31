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

public class CartPage extends CustomLoadableComponent<CartPage>
{

	private BasePage base;
	private WebDriver driver;

	public CartPage(WebDriver driver) 
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
		base=new BasePage(driver);
		this.driver=driver;
	}


	//Page Elements
	@FindBy(xpath="//h1[@class='page-heading' and contains(text(),'Shopping-cart summary')]")
	private WebElement pageHeading;

	@FindBy(xpath="//p[@class='cart_navigation clearfix']/child::a[@title='Proceed to checkout']")
	private WebElement proceedCheckout;


	//Loadable Component
	@Override
	protected void load() 
	{

	}

	@Override
	protected void isLoaded() throws Error 
	{
		if(!isElementLoaded(driver,pageHeading)) 
		{
			throw new Error ("Cart Page is not loaded");
		}

	}

	
	//Page services
	public AddressPage checkoutCart()
	{
		base.scrollToElement(proceedCheckout);
		base.click(proceedCheckout);
		return new AddressPage(driver).get();
	}

}
