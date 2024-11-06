package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class DataProviderUtilities {

    @DataProvider(name = "MinMaxData")
    public static Object[][] getMinMaxData(){
        String filePath = "E:\\Year 4\\IS 4102\\Assignment 2\\20020961\\Data.xlsx";
        Object[][] minMaxData = null;

        try{
            FileInputStream fip = new FileInputStream(new File(filePath));
            XSSFWorkbook workbook = new XSSFWorkbook(fip);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowCount = sheet.getPhysicalNumberOfRows() - 1;
            minMaxData = new Object[rowCount][2];

            Iterator<Row> rowIterator = sheet.rowIterator();
            rowIterator.next();

            int i = 0;
            while(rowIterator.hasNext()){
                Row row = rowIterator.next();

                Cell minCell = row.getCell(0);
                Cell maxCell = row.getCell(1);

                if(minCell != null && maxCell != null){
                    int minValue = (int) minCell.getNumericCellValue();
                    int maxValue = (int) maxCell.getNumericCellValue();

                    minMaxData[i][0] = minValue;
                    minMaxData[i][1] = maxValue;
                    i++;
                }
            }

            workbook.close();
            fip.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return minMaxData;
    }
}
