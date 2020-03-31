package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Biswajit Sundara
 * @date 31/03/2020
 */

public abstract class CustomLoadableComponent<T extends CustomLoadableComponent<T>> 
{

	private WebDriverWait wait = null;
	private static final int LOAD_TIMEOUT=30;

	@SuppressWarnings("unchecked")
	public T get() 
	{
		try 
		{
			isLoaded();
			return (T) this;
		} 
		catch (Error e) 
		{
			System.out.println(e.getMessage());	
			load();
		}

		isLoaded();

		return (T) this;
	}

	public boolean isElementLoaded(WebDriver driver,WebElement ele)
	{
		wait= new WebDriverWait(driver,LOAD_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(ele));

		if(ele.isDisplayed())
			return true;

		else
			return false;	  
	}

	protected abstract void load();

	protected abstract void isLoaded() throws Error;

}
