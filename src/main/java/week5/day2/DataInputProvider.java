package week5.day2;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataInputProvider {

	public String[][] sendData(String fileName) throws IOException {
		//Get WorkBook
		XSSFWorkbook workbook = new XSSFWorkbook("./data/"+fileName+".xlsx");
		//Get Sheet
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		//Get number of rows
		int rowCount = sheet.getLastRowNum();
		//Get number of cells in first row
		int cellCount = sheet.getRow(0).getLastCellNum();
		
		String [][] data = new String[rowCount][cellCount];
		
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				//String cellData = sheet.getRow(i).getCell(j).getStringCellValue();
				//System.out.println(cellData);
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		workbook.close();
		return data;
	}
}
