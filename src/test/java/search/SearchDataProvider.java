package search;

import org.testng.annotations.DataProvider;
import utils.ExcelFileReader;
import utils.PropertiesFileReader;

public class SearchDataProvider {

    private static PropertiesFileReader props = new PropertiesFileReader("config.properties");

    @DataProvider
    public Object [] [] getData()
    {
        Object [] [] data = readData(props.getTestDataExcelSheetName());
        return data;
    }

    public static Object [] [] readData(String fileName)
    {
        ExcelFileReader efd = new ExcelFileReader(fileName);
        int rows = efd.getNumOfRows();
        int columns = efd.getNumOfColumns();
        Object [] [] data = new Object [rows-1] [columns];
        for(int i=1;i<rows;i++){
            for (int j=0;j<columns;j++)
            {
                if(j == 4 ||j == 6|| j == 7 ){
                    data[i-1][j]=efd.getNumericCellData(i,j);
                }
                else{
                    data[i-1][j]=efd.getStringCellData(i,j);
                }
            }
        }
        return data;
    }
}
