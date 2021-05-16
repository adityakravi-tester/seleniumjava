package exercise.daily;

import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelClassExercise {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook("./data/CreateLead.xlsx");
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowCount = sheet.getLastRowNum();
		
		System.out.println(rowCount);
		
		short colCount = sheet.getRow(0).getLastCellNum();
		
		System.out.println(colCount);
		
		String [][] data = new String[rowCount][colCount];
		
		for (int i = 1; i <= rowCount; i++) {
			for(int j = 0; j < colCount; j++) {
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		for (String[] strings : data) {
			Arrays.stream(strings).forEach(e -> System.out.println(e));
		}
		
		workbook.close();
	}
}
