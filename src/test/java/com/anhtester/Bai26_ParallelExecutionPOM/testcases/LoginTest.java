package com.anhtester.Bai26_ParallelExecutionPOM.testcases;

import com.anhtester.Bai26_ParallelExecutionPOM.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    // Khai bao doi tuong class Login Page toan cuc
    LoginPage loginPage;

    @Test
    public void testLoginSuccess() {
        //Khoi tao doi tuong class LoginPage de truyen gia tri driver tu BaseTest
        //De class LoginPage nhan duoc gia tri driver thi moi thuc thi cac ham trong class Page duoc
        loginPage = new LoginPage();

        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM("admin@example.com", "123456");
        //WebUI.waitForPageLoaded(); //Khi chuyển trang mới dùng (load trang)
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginWith_EmailInvalid() {
        loginPage = new LoginPage();

        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM("admin123@example.com", "123456");
        //waitForPageLoaded();
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginWith_PasswordInvalid() {
        loginPage = new LoginPage();

        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM("admin@example.com", "1234567");
        //waitForPageLoaded();
        loginPage.verifyLoginFail();
    }
}

