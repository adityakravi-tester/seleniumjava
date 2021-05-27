package exercise.daily;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
  
  public static void main(String[] args) throws IOException {
    
    XSSFWorkbook workbook   = new XSSFWorkbook("./data/CreateLead.xlsx");
    
    XSSFSheet sheet = workbook.getSheet("Sheet1");
    
    String stringCellValue = sheet.getRow(2).getCell(2).getStringCellValue();
    
    System.out.println(stringCellValue);
    
  }
}
