package com.anhtester.Bai26_ParallelExecutionPOM.pages;

import com.anhtester.drivers.DriverManager;
import org.testng.Assert;

public class ProfilePage extends CustomerPage {


    public void verifyCustomerDetail(String companyName) {
        Assert.assertEquals(DriverManager.getDriver().findElement(inputCompanyName).getAttribute("value"), "Viettel A2", "Message");
    }

}

