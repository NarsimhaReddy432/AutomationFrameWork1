package dataprovider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

    XSSFWorkbook wb;


    public ExcelDataProvider() {

        String location = System.getProperty("user.dir") + "/ApplicationTestData/AppData.xlsx";
        System.out.println("Test data file path:" + location);
        File src = new File(location);

        try {
            FileInputStream fis = new FileInputStream(src);

            wb = new XSSFWorkbook(fis);

        } catch (Exception e) {
            System.out.println("Ëxception is " + e.getMessage());
        }

    }


    public String getData(int sheetIndex, int rowNumber, int columnNumber) {

        Sheet sheet = wb.getSheetAt(sheetIndex);   //getting the XSSFSheet object at given index
        Row row = sheet.getRow(rowNumber); //returns the logical row
        Cell cell = row.getCell(columnNumber); //getting the cell representing the given column
        String value = cell.getStringCellValue();    //getting cell value
//        String data=wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
        System.out.println("Data value from excel is: " + value);

        return value;
    }

    public String getData(String sheetName, int row, int column) {

        String data = wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
        System.out.println("Data value from excel is: " + data);

        return data;
    }


}