package RegressionTest;

import Pages.AppRegistration;
import jxl.write.Label;
import jxl.write.WriteException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static Utilities.AlertFunction.AlerFun;
import static Utilities.OpenBrowser.GetUrl;
import static Utilities.OpenBrowser.openBrowser;
import static Utilities.ResultFunction.ShowR;
import static Utilities.Windowhander.NewWindow;
import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Created by laxmikant on 06/05/2017.
 */
public class ResultTest extends ExcelsheetTest {
    WebDriver driver;
    String result;

    int i;
public static String status="Pass";
    public HSSFWorkbook workbook;
   /* @BeforeMethod
    public void l() {
    }
*/    private static int n = 0;
    private static int j = 0;
    @Test(dataProvider = "UserInput")
    public void RegistratTest(String Prifi, String FirstNM, String MiddNM, String LastNm, String Expected/*String Result2*/) throws IOException, WriteException

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
                  String  alertmessage = driver.switchTo().alert().getText();
                    alert.accept();
                    System.out.println(alertmessage);

                    int LastRow = ++n;
                    {
                        TestCase = alertmessage;

                        Label l4 = new Label(5, LastRow, TestCase);
                        WriteTableS.addCell(l4);
                      //  Assert.assertEquals(alertmessage, Expected, "Test pass");
                        int LastRow1 = ++j;

                        if(alertmessage.equals(Expected))
                        {

                            Label l5 = new Label(6,LastRow1, "Pass");
                            WriteTableS.addCell(l5);
                        }else
                        {
                            Label l5 = new Label(6, LastRow1, "Fail");
                            WriteTableS.addCell(l5);
                        }
                    }
                    //    ShowR(driver,result, alertmessage);

                }
            } catch (NoSuchElementException e) {
                System.out.println(e);

            }

        } catch (AssertionError e) {
            result = "Fail";// System.out.println(e);

}



    }

    @DataProvider
    public Object[][] UserInput() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("ExcelData/n.xls");

        workbook = new HSSFWorkbook(fileInputStream);

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

/*

    @AfterTest
    public void h() throws IOException, BiffException {

        String FilePath = "ExcelData/n.xls";
        FileInputStream fs = new FileInputStream(FilePath);
        Workbook wb = Workbook.getWorkbook(fs);

        // TO get the access to the sheet
        Sheet sh = wb.getSheet("n");

        // To get the number of rows present in sheet
        int totalNoOfRows = sh.getRows();

        // To get the number of columns present in sheet
        int totalNoOfCols = sh.getColumns();

        for (int i = 1; i < totalNoOfRows; i++) {
        //
         */
/*//*
/   HSSFCell Actual = row.createCell(5);

            Actual.setCellValue(alertmessage);


            for (int j = 1; j < totalNoOfCols; j++) {
                System.out.print(sh.getCell(j, i).getContents() + "\t");

           *//*



            }
*/


    }