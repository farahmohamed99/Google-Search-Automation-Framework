package utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelFileReader {

    private static FileInputStream fs;
    private static XSSFWorkbook workBook;
    private static XSSFSheet sheet;

    public ExcelFileReader(String fileName) {
        try {
            fs = new FileInputStream("src/test/resources/" + fileName);
            workBook = new XSSFWorkbook(fs);
            sheet = workBook.getSheetAt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getNumOfRows() {
        return sheet.getPhysicalNumberOfRows();
    }

    public static int getNumOfColumns() {
        XSSFRow row = sheet.getRow(0);
        return row.getLastCellNum();
    }

    public static String getStringCellData(int row, int col) {
        return sheet.getRow(row).getCell(col).getStringCellValue();
    }

    public static int getNumericCellData(int row, int col) {
        return (int) sheet.getRow(row).getCell(col).getNumericCellValue();
    }

}
