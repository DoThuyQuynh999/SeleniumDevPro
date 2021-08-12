package Good.common;


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
// comom chứa những cái dùng chung trong cách tổ chức code POM
public class Base {
    public static WebDriver driver; // khai báo đối tượng làm việc với selenium và brower
    public static WebDriverWait wait;
    public String baseURL = "http://commands.test-code.com";// trang cần mở


    @BeforeTest
    public void setup() {
        String pathProject = System.getProperty("user.dir");// lấy đường dẫn động
        String brower = "Chrome";
        switch (brower) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", pathProject + "/libs/chromedriver.exe");
//                System.setProperty("webdriver.chrome.driver", pathProject + "/chromedriver.exe");// khai báo đường dẫn command setting
                driver = new ChromeDriver();// khởi tạo đối tượng làm việc với trình duyệt
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", pathProject + "/libs/geckodriver.exe");
                System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + brower);
        }

        wait = new WebDriverWait(driver, 30); // xử lý ngoại lệ,time chờ tối đa cho các element trên page xuất hiện
    }



    @AfterTest
    public void tearDown(){
        driver.close();
    } // đóng trình duyệt mỗi khi thực hiện test xong
}