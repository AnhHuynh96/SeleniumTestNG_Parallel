package com.anhtester.Bai26_ParallelExecutionPOM.pages;

import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.anhtester.constants.ConfigData.URL;

public class LoginPage {


    //Khai báo các element dạng đối tượng By (phương thức tìm kiếm)
    private By headerLoginPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[@id='alerts']");

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");


    // cac ham trung gian
    private void setEmail(String email) {

        //driver.findElement(inputEmail).sendKeys(email);
        WebUI.setText(inputEmail, email);
    }

    private void setPassword(String password) {

        //driver.findElement(inputPassword).sendKeys(password);
        WebUI.setText(inputPassword, password);
    }

    private void clickLoginButton() {

        WebUI.clickElement(buttonLogin);
    }

    public void verifyLoginSuccess() {
        Assert.assertFalse(DriverManager.getDriver().getCurrentUrl().contains("authentication"), "FAIL. Vẫn đang ở trang Login");
        Assert.assertTrue(DriverManager.getDriver().findElement(menuDashboard).isDisplayed(), "Menu Dashboard is not displayed");
    }

    public void verifyLoginFail() {
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(DriverManager.getDriver().findElement(errorMessage).isDisplayed(), "Error message NOT displays");
        Assert.assertEquals(WebUI.getElementText(errorMessage), "Invalid email or password", "Content of error message NOT match.");
    }

    //Các hàm xử lý cho chính trang này
//    public void loginCRM(String email, String password) {
//       driver.get(URL); //Gọi từ class ConfigData dạng biến static
//       System.out.println("Navigate to URL" + URL);
//       //Goi cac ham trung gian xuong LoginCRM
//       setEmail(email);
//       setPassword(password);
//       clickLoginButton();
//    }
    public DashboardPage loginCRM(String email, String password) {
        //driver.get(URL); //Gọi từ class ConfigData dạng biến static
        WebUI.openURL(URL);
        //Goi cac ham trung gian xuong LoginCRM
        setEmail(email);
        setPassword(password);
        clickLoginButton();
        return new DashboardPage();
    }

    public void verifyRedirectLoginPage() {
        System.out.println("Verify redirect to Login Page");
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("authentication"), "FAIL. Chua den duoc trang Login");
        Assert.assertTrue(DriverManager.getDriver().findElement(headerLoginPage).isDisplayed(), "Header of page NOT displays");
        Assert.assertEquals(WebUI.getElementText(headerLoginPage), "Login123", "Content of header for Login page NOT match.");
    }
}
