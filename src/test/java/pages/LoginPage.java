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

public class LoginPage extends CustomLoadableComponent<LoginPage>
{

	private BasePage base;
	private WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
		base=new BasePage(driver);
		this.driver=driver;
	}


	//Page Elements
	@FindBy(id="email")
	private WebElement username;

	@FindBy(id="passwd")
	private WebElement password;

	@FindBy(id="SubmitLogin")
	private WebElement loginbutton;

	@FindBy(xpath="//h1[@class='page-heading' and text()='Authentication']")
	private WebElement pageHeading;


	//Loadable component
	@Override
	protected void load() {

	}

	@Override
	protected void isLoaded() throws Error
	{
		if(!isElementLoaded(driver,pageHeading)) 
		{
			throw new Error ("Log in page is not loaded");
		}
	}


	//Page services
	public LoginPage enterUserName(String text)
	{
		base.enterText(username,text);
		return this;
	}

	public LoginPage enterPassword(String text)
	{
		base.enterText(password,text);
		return this;
	}

	public HomePage clickLogin()
	{
		base.click(loginbutton);
		return new HomePage(driver).get();
	}

}
