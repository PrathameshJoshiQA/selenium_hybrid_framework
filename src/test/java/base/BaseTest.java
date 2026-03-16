package base;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static RemoteWebDriver driver;
	
	@BeforeMethod
	public void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
