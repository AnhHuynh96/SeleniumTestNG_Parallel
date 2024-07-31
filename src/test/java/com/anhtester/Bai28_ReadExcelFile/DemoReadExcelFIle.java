package com.anhtester.Bai28_ReadExcelFile;

import com.anhtester.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class DemoReadExcelFIle {
    @Test
    public void testGetDataFromExcelFile(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile();
    }
}