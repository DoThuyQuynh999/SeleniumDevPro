package Good.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Good.utils.ReadDataExcelFile;

import static Good.utils.ReadDataExcelFile.*;
import static Good.utils.ReadDataExcelFile.getCellData;
//      pageob tạo đối tượng trang. Chỉ chứa các property và method
public class LoginPage {
     WebDriver driver;
     WebDriverWait wait;
//        xpath của các phần tử trên 1 trang

    By lblProject = By.xpath("//a[contains(text(),'Project')]");
    By txtEmail = By.xpath("(//input[@class='el-input__inner'])[1]");
    By txtPass = By.xpath("(//input[@class='el-input__inner'])[2]");
    By btnLogin = By.xpath("(//button[@class='el-button btn-update el-button--primary'])");
    By btnReset = By.xpath("(//button[@class='el-button btn-update el-button--danger'])");
    By ActualSuccess = By.xpath("//a[contains(text(),'Thêm sản phẩm')]");
    By ActualEmailWhite = By.xpath("(//div[@class='el-form-item__error'])[1]");
    By ActualPassWhite = By.xpath("//div[contains(text(),'Vui lòng nhập mật khẩu')]");
    By ActualWrongPass = By.xpath("//p[contains(text(),'Sai mật khẩu.')]");
    By ActualWrongEmail = By.xpath("//div[contains(text(),'Email không đúng định dạng')]");
    By ActualFail= By.xpath("//p[contains(text(),'Tài khoản không tồn tại.')]");
    public LoginPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;

    }
//    hàm xem title có xuất hiện không
    public boolean isExistedLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblProject));
        return driver.findElement(lblProject).isDisplayed();

    }
//     nhập vào trường email sendKeys, cái strEmail được đọc từ file excel lên. trong cái thư mục testdata
//    còn nhấn chuột thay = click()
    public  void inputEmail(String strEmail){
        driver.findElement(txtEmail).sendKeys(strEmail);
    }
    public void inputPass(String strPass){
        driver.findElement(txtPass).sendKeys(strPass);
    }
    public void clickLogin(){
        driver.findElement(btnLogin).click();
    }
    public void clickReset(){
        driver.findElement(btnReset).click();
    }
    public  String ShowSuccessfully(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ActualSuccess));
        return   driver.findElement(ActualSuccess).getText();
    }
    public  String ShowFailEmail(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ActualEmailWhite));
        return   driver.findElement(ActualEmailWhite).getText();
    }
    public  String ShowFailPass(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ActualPassWhite));
        return   driver.findElement(ActualPassWhite).getText();
    }
    public  String ShowWrongPass(){
        wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ActualWrongPass));
        return   driver.findElement(ActualWrongPass).getText();
    }
    public  String ShowWrongEmail(){
        wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ActualWrongEmail));
        return   driver.findElement(ActualWrongEmail).getText();
    }
//    lấy ra dòng chữ thông báo
    public  String ShowWrong(){
        wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ActualFail));
        return   driver.findElement(ActualFail).getText();
    }
//    thực hiện các thao tác trên trang
    public void InputData(String strEmail, String strPass){
        this.inputEmail(strEmail);
        this.inputPass(strPass);
        this.clickLogin();
//        this.clickReset();
    }
     public void InputLogin(){
        InputData("admin@gmail.com","123456");
    }



}
