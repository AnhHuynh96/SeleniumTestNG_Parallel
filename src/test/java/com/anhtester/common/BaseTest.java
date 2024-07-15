package com.anhtester.common;

import com.anhtester.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {


    @BeforeMethod
    @Parameters({"browser"})

    public void createBrowser(String browserName) {
        WebDriver driver = setBrowser(browserName);
        DriverManager.setDriver(driver); //Gan gia tri driver vao trong ThreadLocal

    }

    public WebDriver setBrowser(@Optional("chrome") String browserName) {
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
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //Dành cho Junior
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
        DriverManager.quit();
    }
}