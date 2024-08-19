package com.anhtester.Bai29_DataProvider;

import com.anhtester.dataprovider.DataProviderFactory;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class DemoDataProvider {

    // Truyen noi cung cap du lieu vao trong test case @Test
    @Test(dataProvider = "dataLogin", dataProviderClass = DataProviderFactory.class)
    public void testLoginSuccess(String email, String password) {
        System.out.println("EMAIL :" + email);
        System.out.println("PASSWORD :" + password);

    }

    @Test(dataProvider = "dataAddCustomer", dataProviderClass = DataProviderFactory.class)
    public void dataAddCustomer(String name, int age, String address) {
        System.out.println("Ten: " + name);
        System.out.println("Tuoi: " + age);
        System.out.println("Dia chi: " + address);

    }

    @Test(dataProvider = "dataLoginFromExcel", dataProviderClass = DataProviderFactory.class)
    public void testLoginFromExcelFile(String email, String password) {
        System.out.println("EMAIL :" + email);
        System.out.println("PASSWORD :" + password);
    }
    @Test(dataProvider = "dataLoginFromExcelMultipleRow", dataProviderClass = DataProviderFactory.class)
    public void testLoginFromExcelFileMultipleRow(Hashtable<String, String> data) {
        System.out.println("EMAIL :" + data.get("email")); //email là tên cột trong file excel( first row)
        System.out.println("PASSWORD :" + data.get("password")); //password là tên cột trong file excel( first row)
    }
}
