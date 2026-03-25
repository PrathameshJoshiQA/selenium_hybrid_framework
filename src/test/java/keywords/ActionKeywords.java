package keywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ActionKeywords {

    RemoteWebDriver driver;
    Properties prop;

    public ActionKeywords(RemoteWebDriver driver) {
        this.driver = driver;

        try {
            FileInputStream fis = new FileInputStream("src/test/resources/objectRepository/OR.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click(String locator) {

        String loc = prop.getProperty(locator);

        if (loc == null) {
            throw new RuntimeException("Locator not found in OR: " + locator);
        }

        System.out.println("Clicking on: " + locator);
        driver.findElement(By.cssSelector(loc)).click();
    }

    public void type(String locator, String value) {

        String loc = prop.getProperty(locator);

        if (loc == null) {
            throw new RuntimeException("Locator not found in OR: " + locator);
        }

        driver.findElement(By.cssSelector(loc)).clear();
        driver.findElement(By.cssSelector(loc)).sendKeys(value);
    }
}