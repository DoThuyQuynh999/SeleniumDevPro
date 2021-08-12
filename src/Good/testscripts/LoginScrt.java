package Good.testscripts;
import Good.common.Base;
import Good.pageobjects.HomePage;
import Good.pageobjects.LoginPage;
import Good.utils.ReadDataExcelFile;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


// chứa các testcase

import static Good.utils.ReadDataExcelFile.*;
public class LoginScrt extends Base {

    public HomePage objHomepage;
    public LoginPage objLogin;
//khai báo các cột trong file data
    private String colEmail = "Email";
    private String colPass = "Pass";
    private String colMesg = "Mesg";
// khai báo số thứ tự các cột (làm việc với excel)
    private int intColEmail;
    private int intColPass;
    private int intColMesg;

    @BeforeClass
    public void setUpClassLoginScrt() throws Exception{
        objHomepage = new HomePage(driver,wait);// khai báo đối tượng làm việc
        objLogin = new LoginPage(driver,wait);
        String strDir = System.getProperty("user.dir"); // khai báo đường dẫn động, lấy cái file data đó
        ReadDataExcelFile.setExcelFile(strDir + "/testdata/DataProject.xlsx", "Login");
    }
    @BeforeMethod
    public void gotoLoginPage(){
        driver.get(baseURL); // mở trang home
        objHomepage.clickLinkLogin(); // thực hiện click để ra màn hình login
    }

    @Test(priority = 0, description = "TC01-Login successfully")
    public void TC01_Successfully() throws Exception {
        String strTestID = "TC01_Succes";// tên trùng với testcasename trong file xlsx
        int rowTC = getRowBaseOnTCID(strTestID);// lấy ra dòng của testcase
        intColEmail= getColBaseOnFieldName(colEmail);// lấy ra giá trị cột
        intColPass = getColBaseOnFieldName(colPass);
        intColMesg = getColBaseOnFieldName(colMesg);
        String strEmail = getCellData(rowTC,intColEmail);
//      hàm input này ở trang LoginPage mục page object, hàm get ở util
        objLogin.InputData(getCellData(rowTC,intColEmail),getCellData(rowTC,intColPass));
        String messExpected = getCellData(rowTC, intColMesg); // kết quả thực tế trên page
        Assert.assertEquals(objLogin.ShowSuccessfully(),messExpected);//so sánh kết quả thực tế và kết quả mong muốn trong file data
    }
    @Test(priority = 1, description = "TC02 - EmailFail")
    public void TC02_EmailFail() throws Exception {
        String strTestID = "TC02_Failemail";
        int rowTC = getRowBaseOnTCID(strTestID);

        intColEmail= getColBaseOnFieldName(colEmail);
        intColPass = getColBaseOnFieldName(colPass);
        intColMesg = getColBaseOnFieldName(colMesg);
        String strEmail = getCellData(rowTC,intColEmail);
        objLogin.InputData(getCellData(rowTC,intColEmail),getCellData(rowTC,intColPass));
        String messExpected = getCellData(rowTC, intColMesg);
        Assert.assertEquals(objLogin.ShowFailEmail(),messExpected);
    }

    @Test(priority = 2, description = "TC03 - PassFail")
    public void TC03_PassFail() throws Exception {
        String strTestID = "TC03_FailPass";
        int rowTC = getRowBaseOnTCID(strTestID);
        intColEmail= getColBaseOnFieldName(colEmail);
        intColPass = getColBaseOnFieldName(colPass);
        intColMesg = getColBaseOnFieldName(colMesg);
        String strEmail = getCellData(rowTC,intColEmail);
        objLogin.InputData(getCellData(rowTC,intColEmail),getCellData(rowTC,intColPass));
        String messExpected = getCellData(rowTC, intColMesg);
        Assert.assertEquals(objLogin.ShowFailPass(),messExpected);
    }
    @Test(priority = 3, description = "TC04 - WrongPass")
    public void TC04_WrongPass() throws Exception {
        String strTestID = "TC04_WrongPass";
        int rowTC = getRowBaseOnTCID(strTestID);
        intColEmail= getColBaseOnFieldName(colEmail);
        intColPass = getColBaseOnFieldName(colPass);
        intColMesg = getColBaseOnFieldName(colMesg);
        String strEmail = getCellData(rowTC,intColEmail);
        objLogin.InputData(getCellData(rowTC,intColEmail),getCellData(rowTC,intColPass));
        String messExpected = getCellData(rowTC, intColMesg);
        Assert.assertEquals(objLogin.ShowWrongPass(),messExpected);
    }
    @Test(priority = 4, description = "TC04 - WrongPass")
    public void TC05_WrongEmail() throws Exception {
        String strTestID = "TC05_WrongEmail";
        int rowTC = getRowBaseOnTCID(strTestID);
        intColEmail= getColBaseOnFieldName(colEmail);
        intColPass = getColBaseOnFieldName(colPass);
        intColMesg = getColBaseOnFieldName(colMesg);
        String strEmail = getCellData(rowTC,intColEmail);
        objLogin.InputData(getCellData(rowTC,intColEmail),getCellData(rowTC,intColPass));
        String messExpected = getCellData(rowTC, intColMesg);
        Assert.assertEquals(objLogin.ShowWrongEmail(),messExpected);
    }
    @Test(priority = 5, description = "TC06 - Wrong")
    public void TC06_Wrong() throws Exception {
        String strTestID = "TC06_Wrong";
        int rowTC = getRowBaseOnTCID(strTestID);
        intColEmail= getColBaseOnFieldName(colEmail);
        intColPass = getColBaseOnFieldName(colPass);
        intColMesg = getColBaseOnFieldName(colMesg);
        String strEmail = getCellData(rowTC,intColEmail);
        objLogin.InputData(getCellData(rowTC,intColEmail),getCellData(rowTC,intColPass));
        String messExpected = getCellData(rowTC, intColMesg);
        Assert.assertEquals(objLogin.ShowWrong(),messExpected);
    }



}
