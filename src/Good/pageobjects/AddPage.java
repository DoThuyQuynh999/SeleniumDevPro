package Good.pageobjects;

import Good.utils.ReadDataExcelFile;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import static Good.utils.ReadDataExcelFile.*;
import static Good.utils.ReadDataExcelFile.getColBaseOnFieldName;


public class AddPage {
      WebDriver driver;
        ReadDataExcelFile a= new ReadDataExcelFile();
      WebDriverWait wait;

    String pathProject = System.getProperty("user.dir");
    By lnkAdmin = By.xpath("//a[contains(text(),'quay lại trang admin')]");
    By lnkAddPro =By.linkText("Thêm sản phẩm");
    By txtProductName = By.xpath("(//input[@class='el-input__inner'])[1]");
//    By dropdownList = By.xpath("//li[@class='el-select-dropdown__item']");
    By dropdownList = By.xpath("//body/div[@id='app']/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]");
    By txtIntroduce = By.xpath("(//textarea[@class='el-textarea__inner'])[1]");
    By txtDetail = By.xpath("(//textarea[@class='el-textarea__inner'])[2]");

    By cbxHighlighProduct = By.xpath("//label[@class='el-checkbox']");

    By listItemElement = By.xpath("//body/div[2]/div[1]/div[1]/ul[1]/li");

    By txtPrice = By.xpath("(//input[@class='el-input__inner'])[3]");
    By txtPercent = By.xpath("(//input[@class='el-input__inner'])[4]");
    By uploadFile = By.xpath("//input[@id='upload-file']");
    By btnAddProduct = By.xpath("//span[contains(text(),'Thêm sản phẩm')]");
    By btnReset = By.xpath("//span[contains(text(),'Reset')]");


    By MesgSucess= By.xpath("//p[contains(text(),'Thêm sản phẩm thành công')]");
    By MesgWhiteName = By.xpath("//div[contains(text(),'Tên sản phẩm là trường bắt buộc')]");
    By MesgLegthName = By.xpath("//div[contains(text(),'Tên sản phẩm phải từ 3 - 50 kí tự')]");
    By MesgWhiteCategory = By.xpath("//div[contains(text(),'Danh mục là trường bắt buộc')]");
    By MesgWhiteIntro = By.xpath("//div[contains(text(),'Giới thiệu là trường bắt buộc')]");
    By MesgWhitePrice = By.xpath("//div[contains(text(),'Giá là trường bắt buộc')]");
    By MesgLengthPrice = By.xpath("//div[contains(text(),'Vui lòng nhập nhập số nguyên từ 1 đến 2 kí tự')]");
    By MesgValidatePrice= By.xpath("//div[contains(text(),'Vui lòng nhập số nguyên')]");
    By MesgLengthPrecent = By.xpath("//div[contains(text(),'Vui lòng nhập nhập số nguyên từ 3 đến 10 kí tự')]");
    By MesgExited = By.xpath("//p[contains(text(),'Tên sản phẩm đã tồn tại')]");
    public AddPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait= wait;

    }

    public void clickLnkAdd(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lnkAddPro));
        driver.findElement(lnkAddPro).click();
    }
    public boolean isExistedLabelAddNewPoduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lnkAddPro));
        return driver.findElement(lnkAddPro).isDisplayed();

    }
    public void inputProductName(String strProductname){
        driver.findElement(txtProductName).sendKeys(strProductname);
    }
    public void ClickList (String strList){

//        WebElement ele =  driver.findElement(dropdownList);
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", ele);


//        Actions actions = new Actions(driver);
//        actions.moveToElement(ele).click().perform();
        if (strList.isEmpty()) {
            return;
        }
        driver.findElement(dropdownList).click();
        List<WebElement> eleDropdownList = driver.findElements(listItemElement);
        for(WebElement liTag : eleDropdownList) {
            if(liTag.getText().contains(strList)) {
                liTag.click();
                break;
            }
        }
    }


    public void inputIntroduce (String strIntroduce){
        driver.findElement(txtIntroduce).sendKeys(strIntroduce);
    }
    public void inputDetail (String strDetail){
        driver.findElement(txtDetail).sendKeys(strDetail);
    }


    public void clickLight (String strCheckbox) {
        if (strCheckbox.equals("Yes")) {

            driver.findElement(cbxHighlighProduct).click();
        }

    }



    public void inputPrice (String strPrice){
        driver.findElement(txtPrice).sendKeys(strPrice);
    }
    public void inputPercent (String strPercent){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtPercent));
        driver.findElement(txtPercent).sendKeys(strPercent);
    }
    public void setUploadFile (String strFile){
        if(strFile.equals("Yes")) {
            driver.findElement(uploadFile).sendKeys(pathProject + "/testdata/automation.png");
        }
    }
    public void clickButtonAddNewProduct(){
        driver.findElement(btnAddProduct).click();
    }
    public  void clickButtonReset(){
        driver.findElement(btnReset).click();
    }
    public void InputDataAddNewProduct(String strProductname,String strCate, String strIntroduce, String strDetail, String strCheckbox, String strPrice, String strDiscount, String strFile){
        this.inputProductName(strProductname);
        this.ClickList(strCate);
        this.inputIntroduce(strIntroduce);
        this.inputDetail(strDetail);
        this.clickLight(strCheckbox);
        this.inputPrice(strPrice);
        this.inputPercent(strDiscount);
        this.setUploadFile(strFile);
        this.clickButtonAddNewProduct();
    }
    public  String ShowMesgSucess(){
        wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MesgSucess));
        return   driver.findElement(MesgSucess).getText();
    }
    public  String ShowMesgWhiteName(){
        wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MesgWhiteName));
        return   driver.findElement(MesgWhiteName).getText();
    }
    public  String ShowMesgLegthName(){
        wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MesgLegthName));
        return   driver.findElement(MesgLegthName).getText();
    }
    public  String ShowMesgWhiteCategory(){
        wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MesgWhiteCategory));
        return   driver.findElement(MesgWhiteCategory).getText();
    }
    public  String ShowMesgWhiteIntro(){
        wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MesgWhiteIntro));
        return   driver.findElement(MesgWhiteIntro).getText();
    }
    public  String ShowMesgWhitePrice(){
        wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MesgWhitePrice));
        return   driver.findElement(MesgWhitePrice).getText();
    }
    public  String ShowMesgLengthPrice(){
        wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MesgLengthPrice));
        return   driver.findElement(MesgLengthPrice).getText();
    }
    public  String ShowMesgValidatePrice(){
        wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MesgValidatePrice));
        return   driver.findElement(MesgValidatePrice).getText();
    }
    public  String ShowMesgLengthPrecent(){
        wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MesgLengthPrecent));
        return   driver.findElement(MesgLengthPrecent).getText();
    }
    public  String ShowMesgExited(){
        wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MesgExited));
        return   driver.findElement(MesgExited).getText();
    }

}


