package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author Biswajit Sundara
 * @date 31/03/2020
 */

public class TestSetup 
{

	public WebDriver driver;
	public WebDriverWait wait;


	@BeforeClass
	public void startTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Biswajit\\Documents\\Lib\\drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().window().maximize();

		wait= new WebDriverWait(driver,30);
	}

	
	@AfterClass()
	public void endTest()
	{
		driver.quit();
	}
	
}
