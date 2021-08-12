package Good.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class OutPage {
    WebDriver driver;
    WebDriverWait wait;

    By labelPo = By.xpath("//body[@class='el-popup-parent--hidden']");
    By btnOut = By.xpath("//li[@class='logout']");
    By lblOut = By.xpath("//span[contains(text(),'Đăng xuất')]");
    By lblRequest = By.xpath("//p[contains(text(),'Bạn muốn đăng xuất')]");
    By btnOK = By.xpath("//span[contains(text(),'Ok')]");
    By btnCancel = By.xpath("//span[contains(text(),'Cancel')]");

    public OutPage(WebDriver driver, WebDriverWait wait) {
//        khai báo contructor để điều hướng, được gọi trong SCRT
        this.driver = driver;
        this.wait = wait;
    }
//    kiểm tra xem phần tử có xuất hiện trên trang đó không?
    public boolean isExistedLabelPopup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(labelPo));
        return driver.findElement(labelPo).isDisplayed();
    }
    public boolean isExistedLabelOut() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblOut));
        return driver.findElement(lblOut).isDisplayed();
    }
    public boolean isExistedLabelLogOut() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblRequest));
        return driver.findElement(lblRequest).isDisplayed();
    }
//    method thực hiện với các phần tử trên trang. nhấn chuột/ enter = click(), nhập dữ liệu vào trường = sendKeys()
    public void clickOk(){
        driver.findElement(btnOK).click();
    }
    public void clickRe(){
        driver.findElement(btnCancel).click();
    }
    public void clickOut() {

        WebElement ele = driver.findElement(btnOut);
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click();", ele);
    }
    public void Wait()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnOut));
    }
}
