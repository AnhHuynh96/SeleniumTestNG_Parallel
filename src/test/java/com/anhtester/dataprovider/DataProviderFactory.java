package com.anhtester.dataprovider;

import com.anhtester.helpers.ExcelHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {
    // Khai bao noi cung cap du lieu - dung @DataProvider
    @DataProvider(name = "dataLogin", parallel = false)
    public Object [][] dataLogin(){
        return new Object[][]{
                {"admin1@example.com","123456"},
                {"admin2@example.com","1234567"},
                {"admin123@example.com","12345678"}

        };
    }
    @DataProvider(name = "dataAddCustomer", parallel = false)
    public Object [][] dataAddCustomer() {
        return new Object[][]{
                {"Hung", 25, "HN"},
                {"Anh", 28, "CT"},
                {"Thi", 30, "HCM"}

        };
    }
    @DataProvider(name = "dataLoginFromExcel", parallel = true)
    public Object[][] dataLoginFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/resources/testdata/LoginData.xlsx", "LoginData");
        System.out.println("Extract Data from Excel: " + data);
        return data;
    }
    @DataProvider(name = "dataLoginFromExcelMultipleRow", parallel = true)
    public Object[][] dataLoginFromExcelMultipleRow() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable("src/test/resources/testdata/LoginData.xlsx", "LoginData",2,3);
        System.out.println("Extract Data from Excel: " + data);
        return data;
    }
}
