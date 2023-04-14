package org.example.Helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static Object[][] readExcel(String filePath, String sheetName) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
        Object[][] data = new Object[rowCount][2];
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            Cell cellA = row.getCell(0);
            String action = cellA.getStringCellValue();
            Cell cellB = row.getCell(1);
            String value = cellB.getStringCellValue();
            data[i][0] = action;
            data[i][1] = value;
        }
        workbook.close();
        inputStream.close();
        return data;
    }
}
