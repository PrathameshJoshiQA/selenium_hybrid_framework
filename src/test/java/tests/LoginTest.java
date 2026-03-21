package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ExcelUtils;

public class LoginTest extends BaseTest{
	
	@DataProvider(name = "loginData")
	public Object[][] getData() throws IOException
	{
		ExcelUtils excel = new ExcelUtils("C:\\Users\\joshi\\eclipse-workspace\\Jarvis\\src\\test\\resources\\testdata\\LoginData.xlsx","Sheet1");
		Object[][] data = new Object[1][2];
		data[0][0] = excel.getCellData(1, 0);
		data[0][1] = excel.getCellData(1, 1);
		return data;
	}
	
	
	@Test(dataProvider = "loginData")
	public void verifyLogin(String email, String password) {
		HomePage home = new  HomePage(driver);
		home.clickMyAccountDropdown();
		home.clickLoginLink();
		
		LoginPage login = new LoginPage(driver);
		login.enterEmail(email);
		login.enterPassword(password);
		login.clickLogin();
		
		AccountPage account = new AccountPage(driver);
		String getHeading = account.getHeadingText();
		Assert.assertEquals(getHeading, "My Account");
	}
	


}
