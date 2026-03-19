package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AccountPage extends BasePage {

	public AccountPage(RemoteWebDriver driver) {
		super(driver);
	}
	
	By heading = By.xpath("//h2[text()='My Account']");
	
	public String getHeadingText() {
		return driver.findElement(heading).getText();
	}

}
