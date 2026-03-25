package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import engine.TestSteps;
import keywords.ActionKeywords;

public class KeywordTest extends BaseTest{

	@Test
	public void testUsingKeywords()
	{
		ActionKeywords actions = new ActionKeywords(driver);
		actions.click("myAccountDropdown");
		actions.click("loginLink");
		actions.type("emailField", "vaceyi3307@pazard.com");
		actions.type("passwordField", "Test@1234");
		actions.click("loginBtn");
	}
	
	@Test
	public void testUsingKeywordsExcel()
	{
		TestSteps steps = new TestSteps(driver);
		steps.executeSteps();
	}
}
