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

public class HomePage extends CustomLoadableComponent<HomePage>
{

	private BasePage base;
	private WebDriver driver;

	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
		base=new BasePage(driver);
		this.driver=driver;
	}


	
	//Page Elements
	@FindBy(id="search_query_top")
	private WebElement searchBox;

	@FindBy(name="submit_search")
	private WebElement searchIcon;

	@FindBy(xpath="//h1[@class='page-heading' and text()='My account']")
	private WebElement pageHeading;



	//Loadable Component
	@Override
	protected void load() {

	}

	@Override
	protected void isLoaded() throws Error 
	{
		if(!isElementLoaded(driver,pageHeading)) 
		{
			throw new Error ("Home page is not loaded");
		}
	}


	
	//Page services
	public HomePage enterSearchItem(String text){
		base.enterText(searchBox,text);
		return this;
	}

	public SearchPage clickSearchIcon(){
		base.click(searchIcon);
		return new SearchPage(driver).get();
	}

}
