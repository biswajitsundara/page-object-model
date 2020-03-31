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


public class ProductPage extends CustomLoadableComponent<ProductPage>
{

	private BasePage base;
	private WebDriver driver;

	public ProductPage(WebDriver driver) 
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
		base=new BasePage(driver);
		this.driver=driver;
	}


	//Page Elements
	@FindBy(xpath="//h2[contains(text()[2],'Product successfully added to your shopping cart')]")
	private WebElement pageHeading;

	@FindBy(xpath="//a[@title='Proceed to checkout'  and contains(@class,'button-medium')]")
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
			throw new Error ("Product page is not loaded");
		}
	}


	//Page services
	public CartPage proceedCheckout()
	{
		base.click(proceedCheckout);
		return new CartPage(driver).get();
	}
}
