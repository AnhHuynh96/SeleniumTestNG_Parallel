package com.anhtester.Bai26_ParallelExecutionPOM.testcases;

import com.anhtester.Bai26_ParallelExecutionPOM.pages.CustomerPage;
import com.anhtester.Bai26_ParallelExecutionPOM.pages.DashboardPage;
import com.anhtester.Bai26_ParallelExecutionPOM.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    private String CUSTOMER_NAME = "Viettel ct1";

    @Test
    public void addNewCustomer() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.verifyRedirectCustomerPageSuccess();
        customerPage.clickButtonAddNew();
        customerPage.inputDataCustomer(CUSTOMER_NAME);


    }

    @Test
    public void testLogin() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

    }
}
