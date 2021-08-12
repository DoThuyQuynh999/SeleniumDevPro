package Good.testscripts;

import Good.common.Base;
import Good.pageobjects.AddPage;
import Good.pageobjects.HomePage;
import Good.pageobjects.LoginPage;
import Good.pageobjects.OutPage;
import Good.utils.ReadDataExcelFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Good.utils.ReadDataExcelFile.*;
import static Good.utils.ReadDataExcelFile.getCellData;

public class OutpageScrt extends Base {


    public HomePage objHomepage;
    public LoginPage objLoginpage;
    public AddPage objAddpage;
    public OutPage objOutPage;
    @BeforeClass
    public void setUpClassAddScrt() throws Exception {
        objHomepage = new HomePage(driver, wait);
        objAddpage = new AddPage(driver, wait);
        objLoginpage = new LoginPage(driver, wait);
        objOutPage = new OutPage(driver, wait);

    }
    @BeforeMethod
    public void gotoAddPage() throws Exception {
        driver.get(baseURL);
        objHomepage.clickLinkLogin();
        objLoginpage.InputLogin();
         objOutPage.Wait();

        objOutPage.clickOut();
    }
    @Test(priority = 0)
    public void TestOutCancel(){
        objOutPage.clickRe();
    }
    @Test(priority =1)
    public void TestOut(){
        objOutPage.clickOk();

    }


}
