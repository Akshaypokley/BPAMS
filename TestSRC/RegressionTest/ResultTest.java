package RegressionTest;

import Pages.AppRegistration;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static Utilities.AlertFunction.AlerFun;
import static Utilities.OpenBrowser.GetUrl;
import static Utilities.OpenBrowser.openBrowser;
import static Utilities.ResultFunction.ShowR;
import static Utilities.Windowhander.NewWindow;

/**
 * Created by laxmikant on 06/05/2017.
 */
public class ResultTest {
    WebDriver driver;

    String f;
    String result;
    int roI=0;
    int r;

    @Test(dataProvider = "UserInput")
    public void RegistratTest(String Prifi, String FirstNM, String MiddNM, String LastNm, String Expected/*String Result2*/) throws IOException

    {
        driver = openBrowser("chrome");
        GetUrl("url");
        AppRegistration appRegistration = new AppRegistration(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        appRegistration.setRegistrationLink();
        NewWindow(driver);
        try {

            appRegistration.setPriFix(Prifi);
            appRegistration.setFirstNm(FirstNM);
            appRegistration.setMiddleNM(MiddNM);
            appRegistration.setLastNM(LastNm);
            appRegistration.ClickSubmit();
            AlerFun(driver);
            try {

                //String Expected = "You have been registered successfully !!!";
                if ((ExpectedConditions.alertIsPresent()) == null) {
                    System.out.println("alert was not present");
                } else {

                    Alert alert = driver.switchTo().alert();
                    String alertmessage = driver.switchTo().alert().getText();
                    System.out.println(alertmessage);
                    f = alertmessage;
                    alert.accept();
                    Assert.assertEquals(alertmessage, Expected, "Test pass");
                    result = "Pass";

                }
            } catch (NoSuchElementException e) {
                System.out.println(e);

            }

        } catch (AssertionError e) {
            result = "Fail";// System.out.println(e);

        }
      //  for(int i=-1;;i++)
        int i=1;
      ShowR(driver,i,result,f,6,5);
        i++;
        System.out.println(i);
    }


    @DataProvider
    public Object[][] UserInput() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("ExcelData/n.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

        HSSFSheet sheet = workbook.getSheet("n");

        int RowCount = sheet.getPhysicalNumberOfRows();

        String data[][] = new String[RowCount - 1][5];

        for (int i = 1; i < RowCount; i++)

        {
            HSSFRow row = sheet.getRow(i);

            HSSFCell PrifixCell = row.getCell(0);
            if (PrifixCell == null) {
                data[i - 1][0] = "";
            } else {
                PrifixCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][0] = PrifixCell.getStringCellValue();
            }


            HSSFCell FirstName = row.getCell(1);
            if (FirstName == null) {
                data[i - 1][1] = "";
            } else {
                FirstName.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][1] = FirstName.getStringCellValue();
            }

            HSSFCell MiddelName = row.getCell(2);
            if (MiddelName == null) {
                data[i - 1][2] = "";
            } else {
                MiddelName.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][2] = MiddelName.getStringCellValue();
            }
            HSSFCell LastName = row.getCell(3);
            if (LastName == null) {
                data[i - 1][3] = "";
            } else {
                LastName.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][3] = LastName.getStringCellValue();
            }

            HSSFCell Expeted = row.getCell(4);
            if (Expeted == null) {
                data[i - 1][4] = "";
            } else {
                Expeted.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][4] = Expeted.getStringCellValue();
            }


        }
        return data;


    }







}