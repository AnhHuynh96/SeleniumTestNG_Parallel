package com.anhtester.Bai28_ReadExcelFile;

import com.anhtester.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class DemoReadExcelFIle {
    @Test
    public void testGetDataFromExcelFile(){
        //Goi ham setExcelFile de chi dinh file excel va sheet cu the
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx","Sheet1");

        //Goi ham getCellData de doc data theo tung file
        System.out.println(excelHelper.getCellData("email",1));
        System.out.println(excelHelper.getCellData("email",2));
        System.out.println(excelHelper.getCellData("password",1));
        System.out.println(excelHelper.getCellData(0,1));
    }
      @Test
    public void testSetDataToExcelFile(){
          ExcelHelper excelHelper = new ExcelHelper();
          excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx","Sheet1");

          //Goi ham setCellData de ghi data vao tung o chi dinh theo cot va dong
          excelHelper.setCellData("admin@example.com","email",1);
          excelHelper.setCellData("123456","password",1);
          excelHelper.setCellData("project manager","role",1);
      }

}