package com.example.Framework.Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public Object[][] readXL(String filePath) throws IOException{
        FileInputStream fis = new FileInputStream(filePath);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheetAt(0);
        fis.close();
        int rowCount = sheet.getLastRowNum();
        System.out.println("ROW-COUNT : " + rowCount);
        int cellCount = sheet.getRow(0).getLastCellNum();
        System.out.println("Cell-Count : " + cellCount);
        Object[][] Obj = new Object[rowCount][cellCount];
        for(int r=1; r<=rowCount;r++){
            Row row = sheet.getRow(r);
            
            for (int c = 0; c<cellCount; c++){
                Cell cell = row.getCell(c);

              switch (cell.getCellType()) {
                case STRING:
                     Obj[r-1][c] = cell.getStringCellValue();
                    break;
                default:
                    break;
              
            }       
        }
    }
    wb.close();
    return Obj;
}
}
    
        


