package com.anhtester.Bai31_TestListener;

import com.anhtester.drivers.DriverManager;
import com.anhtester.listener.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;


@Listeners(TestListener.class)
public class DemoListener {
    WebDriver driver;

    @BeforeMethod
    public void setupDriver() {
        driver = new ChromeDriver();
        DriverManager.setDriver(driver);
    }

    @Test(priority = 1) //Success Test
    public void gotoPage() {
        driver.get("https://anhtester.com");
    }

    @Test(priority = 2) //Failed Test
    public void checkTitle() {
        driver.get("https://anhtester.com");
        String expectedTitle = "Anh Tester";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, expectedTitle, "Title of the website do not match");
    }

    @Test(priority = 3)  //Skip Test
    public void skipTest() {
        throw new SkipException("Skipping The Test Method ");
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
        System.out.println("Day la AfterClass");

    }
}
