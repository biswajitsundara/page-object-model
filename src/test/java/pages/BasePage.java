package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Biswajit Sundara
 * @date 31/03/2020
 */

public class BasePage 
{

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	private JavascriptExecutor js;

	public BasePage(WebDriver driver) 
	{
		this.driver=driver;
		wait= new WebDriverWait(driver,30);
		actions= new Actions(driver);
		js=(JavascriptExecutor)driver;
	}


	//Click Method
	public void click (WebElement ele) 
	{
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	}

	public void checkbox (WebElement ele) 
	{
		ele.click();
	}


	//Write Text
	public void enterText (WebElement username, String text) 
	{
		wait.until(ExpectedConditions.elementToBeClickable(username));
		username.sendKeys(text);
	}


	//Read Text
	public String getText (WebElement ele) 
	{
		wait.until(ExpectedConditions.visibilityOf(ele));
		return ele.getText();
	}


	//Element Displayed
	public boolean isDisplayed(WebElement ele) 
	{
		wait.until(ExpectedConditions.visibilityOf(ele));
		if(ele.isDisplayed())
			return true;
		else return false;
	}

	//Hover on element
	public void hoveronItem(WebElement ele)
	{
		wait.until(ExpectedConditions.visibilityOf(ele));
		actions.moveToElement(ele).perform();
	}

	//Scroll to element
	public void scrollToElement(WebElement ele)
	{
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

}