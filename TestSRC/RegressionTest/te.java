package RegressionTest;

import Pages.AppRegistration;
import jxl.write.WriteException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.*;
import java.util.concurrent.TimeUnit;

import static Utilities.AlertFunction.AlerFun;
import static Utilities.OpenBrowser.GetUrl;
import static Utilities.OpenBrowser.openBrowser;
import static Utilities.Windowhander.NewWindow;

/**
 * Created by laxmikant on 08/05/2017.
 */
public class te {
    WebDriver driver;
    String result;
    private static int n = 0;

    @Test(dataProvider = "UserInput")
    public void RegistratTest(String Prifi, String FirstNM, String MiddNM, String LastNm, String Expected/*String Result2*/) throws IOException, WriteException

    {
        driver = openBrowser("chrome");
        GetUrl("url");
        AppRegistration appRegistration = new AppRegistration(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        appRegistration.setRegistrationLink();
        NewWindow(driver);
        appRegistration.setPriFix(Prifi);
        appRegistration.setFirstNm(FirstNM);
        appRegistration.setMiddleNM(MiddNM);
        appRegistration.setLastNM(LastNm);
        appRegistration.ClickSubmit();
        AlerFun(driver);

        if ((ExpectedConditions.alertIsPresent()) == null) {
            System.out.println("alert was not present");
        } else {

            Alert alert = driver.switchTo().alert();
            String alertmessage = driver.switchTo().alert().getText();
            alert.accept();
            System.out.println(alertmessage);
            int LastRow = ++n;
        }
    }
}