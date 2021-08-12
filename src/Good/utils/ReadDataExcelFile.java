package Good.utils;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadDataExcelFile {
//    khai báo các tham số làm việc
    public static XSSFWorkbook excelWBook;
    public static XSSFSheet excelWSheet;
    public static XSSFCell cell;

    //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
    public static void setExcelFile(String path, String sheetName) throws Exception {
        try {
            File file = new File(path);
            FileInputStream excelFile = new FileInputStream(file);
            // Access the test data sheet
            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
        } catch (Exception e) {
            throw (e);
        }
    }

    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
    public static String getCellData(int rowNum, int colNum) throws Exception {
        try {
            cell = excelWSheet.getRow(rowNum).getCell(colNum);
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        } catch (Exception e) {
            System.out.println(e);
            return "";
        }
    }

    public static int getRowBaseOnTCID(String TestCaseID) throws Exception {
        //Find number of rows in excel file
        int rowCount = excelWSheet.getLastRowNum();
        int i = 0;
        while (i <= rowCount) {
            if (getCellData(i, 0).equals(TestCaseID))
                return i;
            else
                i++;
        }
        return i;
    }
//  <p class="el-message__content">Tài khoản không tồn tại.</p>
    public static int getColBaseOnFieldName(String fieldName) throws Exception {
//        get ca cot , add bat ki cai cot nao vao code
        int firstRow = excelWSheet.getFirstRowNum();
        int lastCol = excelWSheet.getRow(firstRow).getLastCellNum();
        int j = 0;
        while (j <= lastCol) {
            if (getCellData(firstRow, j).equals(fieldName))
                return j;
            else
                j++;
        }
        return j;
    }
}