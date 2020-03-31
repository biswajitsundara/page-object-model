package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import base.CustomLoadableComponent;

/**
 * @author Biswajit Sundara
 * @date 30/03/2020
 */

public class ConfirmOrderPage extends CustomLoadableComponent<ConfirmOrderPage>
{

	private BasePage base;
	private WebDriver driver;

	public ConfirmOrderPage(WebDriver driver) 
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
		base=new BasePage(driver);
		this.driver=driver;
	}


	//Page Elements
	@FindBy(xpath="//h1[text()='Order confirmation' and @class='page-heading']")
	private WebElement pageHeading;


	@FindBy(xpath="//p[@class='alert alert-success']")
	private WebElement msgConf;


	//Loadable component
	@Override
	protected void load() {

	}

	@Override
	protected void isLoaded() throws Error 
	{
		if(!isElementLoaded(driver,pageHeading)) 
		{
			throw new Error ("Confirm Order page is not loaded");
		}
	}


	//Page services
	public void validateOrderConfirmation()
	{
		String actualText = base.getText(msgConf);
		String expectedText="Your order on My Store is complete.";
		Assert.assertEquals(actualText, expectedText);
	}
}
