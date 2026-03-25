package engine;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;

import keywords.ActionKeywords;
import utils.ExcelUtils;

public class TestSteps {

	ActionKeywords actions;
	ExcelUtils excel;
	RemoteWebDriver driver;
	
	public TestSteps(RemoteWebDriver driver)
	{
		this.driver=driver;
		actions = new ActionKeywords(driver);
		try {
			excel = new ExcelUtils("src/test/resources/testdata/TestSteps.xlsx", "Steps");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void executeSteps()
	{
		int rows = excel.getRowCount();
		
		for(int i = 1; i < rows; i++)
		{
			String keyword = excel.getCellData(i, 0);
			String object = excel.getCellData(i, 1);
			String data = excel.getCellData(i, 2);
			
			if(keyword.equalsIgnoreCase("click")) {
				actions.click(object);
			}
			else if(keyword.equalsIgnoreCase("type")) {
				actions.type(object, data);
			}
		}
		
	}
}
