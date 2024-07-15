package com.anhtester.Bai26_ParallelExecutionPOM.pages;

import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CustomerPage {


    private WebDriverWait wait;

    private By buttonAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By headerCustomerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By inputSearch = By.xpath("//div[@id='DataTables_Table_0_filter']//input[@type='search']");

    //Trang Customer List
    //private By buttonAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImportCustomers = By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts = By.xpath("//a[contains(@href,'clients/all_contacts')]");
    private By headerCustomersPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By inputSearchCustomers = By.xpath("//div[@id='DataTables_Table_0_filter']//input[@type='search']");

    //Add New Customer
    public By inputCompanyName = By.xpath("//input[@id='company']");
    public By inputVatNumber = By.xpath("//input[@id='vat']");
    public By inputPhone = By.xpath("//input[@id='phonenumber']");
    public By inputWebsite = By.xpath("//input[@id='website']");
    private By dropdownGroups = By.xpath("//button[@data-id='groups_in[]']");
    private By inputSearchGroup = By.xpath("//div[@app-field-wrapper='groups_in[]']//input[@type='search']");
    private By dropdownCurrency = By.xpath("//button[@data-id='default_currency']");
    private By inputSearchCurrency = By.xpath("//div[@app-field-wrapper='default_currency']//input[@type='search']");
    private By dropdownLanguage = By.xpath("//button[@data-id='default_language']");
    private By optionVietnamese = By.xpath("//span[normalize-space()='Vietnamese']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By dropdownCountry = By.xpath("//button[@data-id='country']");
    private By inputSearchCountry = By.xpath("//div[@app-field-wrapper='country']//input[@type='search']");
    private By buttonSaveAndCreateContact = By.xpath("//button[normalize-space()='Save and create contact']");
    private By buttonSaveCustomer = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");
    private By inputSearchCustomer = By.xpath("//input[@placeholder='Search...']");
    private By firstItemCustomerOnTable = By.xpath("//td[@class='sorting_1']");


    public void clickButtonAddNew() {
        //driver.findElement(buttonAddNew).click();
        WebUI.clickElement(buttonAddNewCustomer);
    }

    public void verifyRedirectCustomerPageSuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(headerCustomerPage).isDisplayed(), "Khong tim thay Customer header page");
        Assert.assertEquals(DriverManager.getDriver().findElement(headerCustomerPage).getText(), "Customers Summary", "Gia tri header customer page khong dung");

    }

    public void searchCustomer(String customerName) {

        DriverManager.getDriver().findElement(inputSearch).sendKeys(customerName);
    }

    public void inputDataCustomer(String companyName) {
        WebUI.setText(inputCompanyName, companyName);
        WebUI.setText(inputVatNumber, "10");
        WebUI.setText(inputPhone, "123456");
        WebUI.setText(inputWebsite, "https://viettel.com.vn");
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(inputSearchGroup, "Gold");
        WebUI.sleep(1);
        WebUI.setKey(inputSearchGroup, Keys.ENTER);
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(inputAddress, "Ha Noi");
        WebUI.setText(inputCity, "Ha Noi");
        WebUI.setText(inputState, "Thang Long");
        WebUI.setText(inputZipCode, "1234");
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry, "Vietnam");
        WebUI.sleep(1);
        //driver.findElement(inputSearchCountry).sendKeys(Keys.ENTER);
        WebUI.setKey(inputSearchCountry, Keys.ENTER);
        WebUI.clickElement(buttonSaveCustomer);

    }
//    public ProfilePage searchCustomer(String companyName){
//    WebUI.setText(inputSearchCustomer, companyName );
//    WebUI.sleep(2);
//    WebUI.clickElement(firstItemCustomerOnTable);
//    return new ProfilePage(driver);
//
//
//    }


}
