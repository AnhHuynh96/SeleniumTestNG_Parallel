package com.anhtester.common;

import com.anhtester.drivers.DriverManager;
import com.anhtester.helpers.CaptureHelper;
import com.anhtester.helpers.PropertiesHelper;
import com.anhtester.listener.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {


    @BeforeMethod
    @Parameters({"browser"})

    public void createBrowser(@Optional("chrome")String browserName) {
        //WebDriver driver = setBrowser(browserName);
        PropertiesHelper.loadAllFiles();
        WebDriver driver = setBrowser(PropertiesHelper.getValue("browser"));
        System.out.println(PropertiesHelper.getValue("timeout"));

        DriverManager.setDriver(driver); //Gan gia tri driver vao trong ThreadLocal

    }

    public WebDriver setBrowser( String browserName) {
        WebDriver driver = null;
        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        }
        if (browserName.equals("edge")) {
            driver = new EdgeDriver();
        }
        if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Dành cho Junior
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        return driver;


    }


    @AfterMethod
    public void closeBrowser() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        public void closeBrowser(ITestResult iTestResult) {
//        // Chup man hinh khi test case bi FAIL. Nguoc lai ko chup
//        if (ITestResult.FAILURE == iTestResult.getStatus()) {
//            CaptureHelper.captureScreenshot(iTestResult.getName());
//            }
//        CaptureHelper.stopRecord();
        DriverManager.quit();
    }
}