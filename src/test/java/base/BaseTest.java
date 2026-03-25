package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseTest {
	
	public static RemoteWebDriver driver;
	protected ConfigReader config;
	@BeforeMethod
	public void setupBrowser() {
		config = new ConfigReader();
		String browser = config.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}		
		driver.manage().window().maximize();
		driver.get(config.getProperty("url"));
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
