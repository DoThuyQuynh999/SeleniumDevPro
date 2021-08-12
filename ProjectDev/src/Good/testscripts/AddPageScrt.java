package Good.testscripts;


import Good.common.Base;
import Good.pageobjects.AddPage;
import Good.pageobjects.HomePage;
import Good.pageobjects.LoginPage;

import Good.utils.ReadDataExcelFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static Good.utils.ReadDataExcelFile.*;
import static Good.utils.ReadDataExcelFile.getCellData;
// page : chỉ chứa các property và method thực hiện trên 1 trang

public class AddPageScrt extends Base {
    public HomePage objHomepage;
    public LoginPage objLoginpage;
    public AddPage objAddpage;

    private String strColProductName = "Product name";
    private String strColList = "List";
    private String strColIntroduce = "Introduce";
    private String strColDetail = "Detail";
    private String strCheck = "Check";
    private String strColPrice = "Price";
    private String strColDiscount = "Percent";
    private String strColFile = "File";
    private String strColMessage = "Message";

    private int intColNumProductName;
    private int intColNumList;
    private int intColNumIntroduce;
    private int intColNumDetail;
    private int intColNumCheckbox;
    private int intColNumPrice;
    private int intColNumDiscount;
    private int intColFile;
    private int intColMessage;

    @BeforeClass
    public void setUpClassAddScrt() throws Exception {
        objHomepage = new HomePage(driver,wait);
        objAddpage = new AddPage(driver,wait);
        objLoginpage = new LoginPage(driver,wait);
        String strDir = System.getProperty("user.dir");
        ReadDataExcelFile.setExcelFile(strDir + "/testdata/DataAddProduct.xlsx", "Sheet1");
        intColNumProductName = getColBaseOnFieldName(strColProductName);
        intColNumList = getColBaseOnFieldName(strColList);
        intColNumIntroduce = getColBaseOnFieldName(strColIntroduce);
        intColNumDetail = getColBaseOnFieldName(strColDetail);
        intColNumCheckbox = getColBaseOnFieldName(strCheck);
        intColNumPrice = getColBaseOnFieldName(strColPrice);
        intColNumDiscount = getColBaseOnFieldName(strColDiscount);
        intColFile = getColBaseOnFieldName(strColFile);
        intColMessage = getColBaseOnFieldName(strColMessage);
    }
        @BeforeMethod
        public void gotoAddPage() throws Exception {
            driver.get(baseURL);
            objHomepage.clickLinkLogin();
            objLoginpage.InputLogin();
            objAddpage.clickLnkAdd();
        }

    @Test(priority = 0, description = "Thêm thành công")
    public void TC01_Suc() throws Exception {
        String strTestID = "TC_001";
        int rowTC = getRowBaseOnTCID(strTestID);

        String strProName = getCellData(rowTC,intColNumProductName);
        objAddpage.InputDataAddNewProduct(getCellData(rowTC,intColNumProductName),getCellData(rowTC,intColNumList),
                getCellData(rowTC,intColNumIntroduce),
                getCellData(rowTC,intColNumDetail),getCellData(rowTC,intColNumCheckbox),
                getCellData( rowTC, intColNumPrice), getCellData(rowTC, intColNumDiscount),
                getCellData(rowTC, intColFile));
       String  messExpected = getCellData(rowTC, intColMessage);
        Assert.assertEquals(objAddpage.ShowMesgSucess(),messExpected);
    }
    @Test(priority =1, description = "Không nhập tên sản phẩm ")
    public void TC02_Product() throws Exception {
        String strTestID = "TC_002";
        int rowTC = getRowBaseOnTCID(strTestID);

        String strProName = getCellData(rowTC,intColNumProductName);
        objAddpage.InputDataAddNewProduct(getCellData(rowTC,intColNumProductName), getCellData(rowTC,intColNumList),
                getCellData(rowTC,intColNumIntroduce),
                getCellData(rowTC,intColNumDetail),getCellData(rowTC,intColNumCheckbox),
                getCellData( rowTC, intColNumPrice), getCellData(rowTC, intColNumDiscount),
                getCellData(rowTC, intColFile));
        String messExpected = getCellData(rowTC, intColMessage);
        Assert.assertEquals(objAddpage.ShowMesgWhiteName(),messExpected);
    }
    @Test(priority =2, description = "Tên sản phẩm từ 3 đến 50 kí tự")
    public void TC03_Name() throws Exception {
        String strTestID = "TC_003";
        int rowTC = getRowBaseOnTCID(strTestID);

        String strProName = getCellData(rowTC,intColNumProductName);
        objAddpage.InputDataAddNewProduct(getCellData(rowTC,intColNumProductName),getCellData(rowTC,intColNumList),
                getCellData(rowTC,intColNumIntroduce),
                getCellData(rowTC,intColNumDetail),getCellData(rowTC,intColNumCheckbox),
                getCellData( rowTC, intColNumPrice), getCellData(rowTC, intColNumDiscount),
                getCellData(rowTC, intColFile));
        String messExpected = getCellData(rowTC, intColMessage);
        Assert.assertEquals(objAddpage.ShowMesgLegthName(),messExpected);
    }
        @Test(priority =3, description = "Danh mục sản phẩm không được để trống")
        public void TC04_Cate() throws Exception {
            String strTestID = "TC_004";
            int rowTC = getRowBaseOnTCID(strTestID);

            intColMessage = getColBaseOnFieldName(strColMessage);
            String strProName = getCellData(rowTC,intColNumProductName);

            objAddpage.InputDataAddNewProduct(getCellData(rowTC,intColNumProductName),getCellData(rowTC,intColNumList),
                    getCellData(rowTC,intColNumIntroduce),
                    getCellData(rowTC,intColNumDetail), getCellData(rowTC,intColNumCheckbox),
                    getCellData( rowTC, intColNumPrice), getCellData(rowTC, intColNumDiscount),
                    getCellData(rowTC, intColFile));
            String messExpected = getCellData(rowTC, intColMessage);
            Assert.assertEquals(objAddpage.ShowMesgWhiteCategory(),messExpected);
        }
    @Test(priority =4, description = "Trường giới thiệu không được để trống")
    public void TC05_Intro() throws Exception {
        String strTestID = "TC_005";
        int rowTC = getRowBaseOnTCID(strTestID);

        String strProName = getCellData(rowTC,intColNumProductName);
        objAddpage.InputDataAddNewProduct(getCellData(rowTC,intColNumProductName),getCellData(rowTC,intColNumList),
                getCellData(rowTC,intColNumIntroduce),
                getCellData(rowTC,intColNumDetail),getCellData(rowTC,intColNumCheckbox),
                getCellData( rowTC, intColNumPrice), getCellData(rowTC, intColNumDiscount),
                getCellData(rowTC, intColFile));
        String messExpected = getCellData(rowTC, intColMessage);
        Assert.assertEquals(objAddpage.ShowMesgWhiteIntro(),messExpected);
    }
    @Test(priority =5, description = "Giá không được để trống")
    public void TC06_Price() throws Exception {
        String strTestID = "TC_006";
        int rowTC = getRowBaseOnTCID(strTestID);

        String strProName = getCellData(rowTC,intColNumProductName);
        objAddpage.InputDataAddNewProduct(getCellData(rowTC,intColNumProductName),getCellData(rowTC,intColNumList),
                getCellData(rowTC,intColNumIntroduce),
                getCellData(rowTC,intColNumDetail),getCellData(rowTC,intColNumCheckbox),
                getCellData( rowTC, intColNumPrice), getCellData(rowTC, intColNumDiscount),
                getCellData(rowTC, intColFile));

        String messExpected = getCellData(rowTC, intColMessage);
        Assert.assertEquals(objAddpage.ShowMesgWhitePrice(),messExpected);
    }
    @Test(priority =6, description = "Discount từ 1-2 chữ số nguyên")
    public void TC07_Fee() throws Exception {
        String strTestID = "TC_007";
        int rowTC = getRowBaseOnTCID(strTestID);

        String strProName = getCellData(rowTC,intColNumProductName);
        objAddpage.InputDataAddNewProduct(getCellData(rowTC,intColNumProductName),getCellData(rowTC,intColNumList),
                getCellData(rowTC,intColNumIntroduce),
                getCellData(rowTC,intColNumDetail),getCellData(rowTC,intColNumCheckbox),
                getCellData( rowTC, intColNumPrice), getCellData(rowTC, intColNumDiscount),
                getCellData(rowTC, intColFile));
        String messExpected = getCellData(rowTC, intColMessage);
        Assert.assertEquals(objAddpage.ShowMesgLengthPrice(),messExpected);
    }
    @Test(priority =7)
    public void TC08_Price() throws Exception {
        String strTestID = "TC_008";
        int rowTC = getRowBaseOnTCID(strTestID);

        String strProName = getCellData(rowTC,intColNumProductName);
        objAddpage.InputDataAddNewProduct(getCellData(rowTC,intColNumProductName),getCellData(rowTC,intColNumList),
                getCellData(rowTC,intColNumIntroduce),
                getCellData(rowTC,intColNumDetail),getCellData(rowTC,intColNumCheckbox),
                getCellData( rowTC, intColNumPrice), getCellData(rowTC, intColNumDiscount),
                getCellData(rowTC, intColFile));

        String messExpected = getCellData(rowTC, intColMessage);
        Assert.assertEquals(objAddpage.ShowMesgValidatePrice(),messExpected);
    }
    @Test(priority =8)
    public void TC09_Price() throws Exception {
        String strTestID = "TC_009";
        int rowTC = getRowBaseOnTCID(strTestID);

        String strProName = getCellData(rowTC,intColNumProductName);
        objAddpage.InputDataAddNewProduct(getCellData(rowTC,intColNumProductName), getCellData(rowTC,intColNumList),
                getCellData(rowTC,intColNumIntroduce),
                getCellData(rowTC,intColNumDetail),getCellData(rowTC,intColNumCheckbox),
                getCellData( rowTC, intColNumPrice), getCellData(rowTC, intColNumDiscount),
                getCellData(rowTC, intColFile));

        String messExpected = getCellData(rowTC, intColMessage);
        Assert.assertEquals(objAddpage.ShowMesgLengthPrecent(),messExpected);
    }
    @Test(priority =8)
    public void TC10_Exited() throws Exception {
        String strTestID = "TC_010";
        int rowTC = getRowBaseOnTCID(strTestID);

        String strProName = getCellData(rowTC,intColNumProductName);
        objAddpage.InputDataAddNewProduct(getCellData(rowTC,intColNumProductName), getCellData(rowTC,intColNumList),
                getCellData(rowTC,intColNumIntroduce),
                getCellData(rowTC,intColNumDetail),getCellData(rowTC,intColNumCheckbox),
                getCellData( rowTC, intColNumPrice), getCellData(rowTC, intColNumDiscount),
                getCellData(rowTC, intColFile));

        String messExpected = getCellData(rowTC, intColMessage);
        Assert.assertEquals(objAddpage.ShowMesgExited(),messExpected);
    }
}




