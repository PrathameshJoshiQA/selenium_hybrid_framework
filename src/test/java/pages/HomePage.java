package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePage extends BasePage{

	public HomePage(RemoteWebDriver driver) {
		super(driver);
	}
	
	By myAccountDropdown = By.cssSelector("a[title='My Account']");
	By loginLink = By.cssSelector("a[href*='account/login']");
	
	public void clickMyAccountDropdown()
	{
		driver.findElement(myAccountDropdown).click();
	}
	
	public void clickLoginLink() {
		driver.findElement(loginLink).click();
	}

}
