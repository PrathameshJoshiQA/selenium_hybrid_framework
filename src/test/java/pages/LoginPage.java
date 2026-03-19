package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage extends BasePage{

	public LoginPage(RemoteWebDriver driver) {
		super(driver);
	}
	//vaceyi3307@pazard.com
	By emailField = By.cssSelector("#input-email");
	By passwordField = By.cssSelector("input[type=\"password\"]");
	By loginBtn = By.cssSelector("input[value='Login']");

	public void enterEmail(String email)
	{
		driver.findElement(emailField).clear();
		driver.findElement(emailField).sendKeys(email);
	}
	public void enterPassword(String password)
	{
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickLogin()
	{
		driver.findElement(loginBtn).click();
	}
}
