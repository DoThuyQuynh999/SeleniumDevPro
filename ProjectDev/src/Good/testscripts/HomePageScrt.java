package Good.testscripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class HomePageScrt {
    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeTest
    public void setup(){
        String pathProject = System.getProperty("user.dir");
        String browser = "Chrome";
        switch(browser){
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", pathProject + "/libs/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", pathProject + "/libs/geckodriver.exe");
                System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browser);

        }
        wait = new WebDriverWait(driver,30);
    }


    @AfterTest
    public void tearDown(){
        driver.close();
    }
}

