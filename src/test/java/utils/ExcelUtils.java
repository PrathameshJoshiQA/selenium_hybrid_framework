package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private  XSSFWorkbook workbook;
	private   XSSFSheet sheet;
	//String filePath = "C:\\Users\\joshi\\eclipse-workspace\\Jarvis\\src\\test\\resources\\testdata\\LoginData.xlsx";
	//String sheetName = "Sheet1";
	
	
	public ExcelUtils(String filePath, String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
	}
	
	public String getCellData(int rowNum, int colNum)
	{
			XSSFRow row = sheet.getRow(rowNum);
			if(row==null)
				return "";
			XSSFCell cell = row.getCell(colNum);
			if(cell==null)
				return "";
			return cell.toString();
	}
	
}
