package com.anhtester.Bai30_TakeScreenshot_RecordVideo;

import com.anhtester.Bai26_ParallelExecutionPOM.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.drivers.DriverManager;
import com.anhtester.helpers.CaptureHelper;
import com.anhtester.helpers.ExcelHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DemoTakeScreenshot extends BaseTest {
    LoginPage loginPage;

    @Test(testName = "TC01")
    public void testLoginCRM_Success() {
        //Khoi tao doi tuong class LoginPage de truyen gia tri driver tu BaseTest
        //De class LoginPage nhan duoc gia tri driver thi moi thuc thi cac ham trong class Page duoc
        //CaptureHelper.startRecord("testLoginCRM_Success");
        loginPage = new LoginPage();

       // ExcelHelper excelHelper = new ExcelHelper();
       // excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx", "LoginSuccess");
        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM("admin@example.com","123456");


        //CaptureHelper.takeScreenshot("testLoginCRM_Success_Cap");

        loginPage.verifyLoginSuccess();
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
// Gọi hàm để chụp ảnh màn hình - getScreenshotAs
        File source = ts.getScreenshotAs(OutputType.FILE);
// Kiểm tra folder tồn tại. Nếu không thì tạo mới folder theo đường dẫn
        File theDir = new File("./screenshots/");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
//Lưu file ảnh với tên cụ thể vào đường dẫn
        try {
            FileHandler.copy(source, new File("./screenshots/testHomePage1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
    @Test(testName = "TC_02")
    public void testLoginCRM_Fail() {
        //Khoi tao doi tuong class LoginPage de truyen gia tri driver tu BaseTest
        //De class LoginPage nhan duoc gia tri driver thi moi thuc thi cac ham trong class Page duoc
        //CaptureHelper.startRecord("testLoginCRM_Fail");
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx", "LoginFail");
        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM(
                excelHelper.getCellData("email", 2),
                excelHelper.getCellData("password", 2));
        //WebUI.waitForPageLoaded(); //Khi chuyển trang mới dùng (load trang)
        CaptureHelper.captureScreenshot("testLoginCRM_Fail");

        loginPage.verifyLoginSuccess();
//        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
//// Gọi hàm để chụp ảnh màn hình - getScreenshotAs
//        File source = ts.getScreenshotAs(OutputType.FILE);
//// Kiểm tra folder tồn tại. Nếu không thì tạo mới folder theo đường dẫn
//        File theDir = new File("./screenshots/");
//        if (!theDir.exists()) {
//            theDir.mkdirs();
//        }
////Lưu file ảnh với tên cụ thể vào đường dẫn
//        try {
//            FileHandler.copy(source, new File("./screenshots/testHomePage1.png"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        loginPage.verifyLoginSuccess();
    }
}


