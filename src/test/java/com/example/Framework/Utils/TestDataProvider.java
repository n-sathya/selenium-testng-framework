package com.example.Framework.Utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name="Read_XL")
    public static Object[][] getData() throws IOException{
        ExcelReader excel = new ExcelReader();
        String path = System.getProperty("user.dir") + "//Data//Excel.xlsx";
        Object[][] obj = excel.readXL(path);
        return obj;
    }  
    
}
