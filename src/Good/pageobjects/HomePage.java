package Good.pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomePage {
   WebDriver driver;
    WebDriverWait wait;

    By lnkLogin = By.linkText("Project");

    By lblCommonCommands = By.className("title");

    public HomePage(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;

    }

    public void clickLinkLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lnkLogin));
        driver.findElement(lnkLogin).click();
    }

}
