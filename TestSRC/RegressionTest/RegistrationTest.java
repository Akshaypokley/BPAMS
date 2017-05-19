package RegressionTest;

import Pages.AppRegistration;
import Utilities.initExtentReport;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jxl.write.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
//import java.awt.Label;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import jxl.write.Label;
import static Utilities.AlertFunction.AlerFun;
import static Utilities.AttachFunction.AttachFuntn;
import static Utilities.DateFunction.DateFun;
import static Utilities.OpenBrowser.GetUrl;
import static Utilities.OpenBrowser.openBrowser;
import static Utilities.TakeScreenShot.takeScreenshot;
import static Utilities.Windowhander.NewWindow;

/**
 * Created by AKSHAY on 01/05/2017.
 */
public class RegistrationTest extends ExcelSheetT {

    WebDriver driver;
    ExtentReports extent ;
    private static int n = 1;
    private static int j = 1;
    private static int h = 1;
    @BeforeMethod()
    public void LoadBrowser() {
        extent = initExtentReport.init();
        driver = openBrowser("chrome");
        GetUrl("url");
    }

    @Test(dataProvider = "UserInput")
    public void RegistratTest(String Prifi, String FirstNM,String MiddNM ,String LastNm,
                               String Quallification, String FirmNm, String PostalAdress, String State,
                              String City, String Pincode, String MobileNo, String Email, String IDproof, String REgNo/*,String ValidDate*/,
                              String LoginName, String Password, String RePassword, String ApplicationCat,String EX
    ) throws IOException, AWTException, InterruptedException, ParseException, WriteException

    {
        ExtentTest test = extent.startTest("Registration Page Test", "To Test the functionalty of Submit button");

        AppRegistration appRegistration = new AppRegistration(driver);
        test.log(LogStatus.INFO, " initialised driver");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        appRegistration.setRegistrationLink();
        test.log(LogStatus.INFO, " Click On Registration link");
        NewWindow(driver);
        test.log(LogStatus.INFO, " Handel New Driver");

        try {

            appRegistration.setPriFix(Prifi);
            test.log(LogStatus.INFO, " Set Prifix");

            appRegistration.setFirstNm(FirstNM);
            test.log(LogStatus.INFO, " Set First Name");
            appRegistration.setMiddleNM(MiddNM);
            test.log(LogStatus.INFO, " Set Middel Name");
            appRegistration.setLastNM(LastNm);
            test.log(LogStatus.INFO, " Set Last Name");
            //  appRegistration.setApplicantNm(ApplicationCat); test.log(LogStatus.INFO, " Set Applicant Cat");
            appRegistration.setQlification(Quallification);
            test.log(LogStatus.INFO, " Set Qallification");
            appRegistration.setFirmName(FirmNm);
            test.log(LogStatus.INFO, " Set Firm Name");
            appRegistration.setPostalAddress(PostalAdress);
            test.log(LogStatus.INFO, " Set Postal Address");
            appRegistration.setState(State);
            test.log(LogStatus.INFO, " Set State");
            appRegistration.setCity(City);
            test.log(LogStatus.INFO, " Set City");
            appRegistration.setPinCode(Pincode);
            test.log(LogStatus.INFO, " Set Pincode");
            appRegistration.setMoileNm(MobileNo);
            test.log(LogStatus.INFO, " Set Mobile");
            appRegistration.setEmail(Email);
            test.log(LogStatus.INFO, " Set Email");
            appRegistration.setIdProf(IDproof);
            test.log(LogStatus.INFO, " Set ID proof");
            driver.findElement(By.id("IdattachIdproof")).click();

            String WinHandleBefore1 = driver.getWindowHandle();
            // Switch to new window opened
            for (String Handle1 : driver.getWindowHandles()) {
                driver.switchTo().window(Handle1);
            }

            try {
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
            ss.click();
            Thread.sleep(6000);
            StringSelection uploadphoto = new StringSelection("E:\\Akshay85\\vb.pdf");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(uploadphoto, null);

            try {

                Robot robot = new Robot();

                robot.keyPress(KeyEvent.VK_CONTROL);

                robot.keyPress(KeyEvent.VK_V);

                robot.keyRelease(KeyEvent.VK_V);

                robot.keyRelease(KeyEvent.VK_CONTROL);

                robot.keyPress(KeyEvent.VK_ENTER);

                robot.keyRelease(KeyEvent.VK_ENTER);

            } catch (AWTException e) {
                Robot robot = new Robot();

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

            }


            Thread.sleep(700);
            //WebDriverWait wait = new WebDriverWait(driver,1000);

            driver.switchTo().window(WinHandleBefore1);          // switch back to the original window
            driver.findElement(By.id("btnAttached")).click();
            String WinHandleBefore3 = driver.getWindowHandle();
            // Switch to new window opened
            for (String Handle3 : driver.getWindowHandles()) {
                driver.switchTo().window(Handle3);
            }
            try {
                Thread.sleep(6000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Thread.sleep(6000);

            WebElement ss2 = driver.findElement(By.id("RadAsyncUpload1file0"));
            ss2.click();

            Thread.sleep(5000);
            StringSelection uploadphoto2 = new StringSelection("E:\\Akshay85\\vb.pdf");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(uploadphoto2, null);

            try {

                Robot robot1 = new Robot();

                robot1.keyPress(KeyEvent.VK_CONTROL);

                robot1.keyPress(KeyEvent.VK_V);

                robot1.keyRelease(KeyEvent.VK_V);

                robot1.keyRelease(KeyEvent.VK_CONTROL);

                robot1.keyPress(KeyEvent.VK_ENTER);

                robot1.keyRelease(KeyEvent.VK_ENTER);

            } catch (AWTException e) {
                Robot robot1 = new Robot();

                robot1.keyPress(KeyEvent.VK_CONTROL);
                robot1.keyPress(KeyEvent.VK_V);
                robot1.keyRelease(KeyEvent.VK_V);
                robot1.keyRelease(KeyEvent.VK_CONTROL);
                robot1.keyPress(KeyEvent.VK_ENTER);
                robot1.keyRelease(KeyEvent.VK_ENTER);

            }
            Thread.sleep(700);
            driver.switchTo().window(WinHandleBefore1);

            appRegistration.setRegitrationNo(REgNo); test.log(LogStatus.INFO, " Set RegiNO");
            DateFun(driver,"20/5/2017");
                    appRegistration.setLoginNm(LoginName); test.log(LogStatus.INFO, " Set UserName");
                    appRegistration.setPassword(Password); test.log(LogStatus.INFO, " Set Password");
                    appRegistration.setRePass(RePassword); test.log(LogStatus.INFO, " Set RePassword");
                    appRegistration.setApplicantNm(ApplicationCat); test.log(LogStatus.INFO, " Set Applicant Cat");
                    appRegistration.clickAcceptTC(); test.log(LogStatus.INFO, "Accept Terms and Condition");
                    appRegistration.ClickSubmit(); test.log(LogStatus.INFO, "Click on Submit Button");

                    Thread.sleep(90);
                    AlerFun(driver);
                    try {

                       // String Expected = "You have been registered successfully !!!";
                        if ((ExpectedConditions.alertIsPresent()) == null) {
                            System.out.println("alert was not present");
                        } else {

                            Alert alert = driver.switchTo().alert();
                            String Actual = driver.switchTo().alert().getText();
                            alert.accept();
                           // Assert.assertEquals(Actual, Expected, "Test pass");
                            /*test.log(LogStatus.PASS, "Test Pass");
                            test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./Registration/"+takeScreenshot(driver)));
                  */          int LastRow = ++n;
                            {
                                TestCase =Actual;

                               Label l4 = new Label(19, LastRow, TestCase);
                                targetSheet.addCell(l4);
                                //  Assert.assertEquals(alertmessage, Expected, "Test pass");
                                int LastRow1 = ++j;

                                if(Actual.equals(EX))
                                {


                                   Label l5 = new Label(20,LastRow1, "PASS",cellFormat);
                                    targetSheet.addCell(l5);
                                }else
                                {

                                  Label l5 = new Label(20, LastRow1, "FAIL",cellFormat2);
                                    targetSheet.addCell(l5);
                                }
                                Assert.assertEquals(Actual,EX, "Test pass");
                                //lastrow=++h;
                            }
                                           }

                        } catch (NoSuchElementException e) {
                        System.out.println(e);

                    }

                }catch (AssertionError e)
                {
                    test.log(LogStatus.FAIL, "Element not found : "+e);
                    test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./Registration/"+takeScreenshot(driver)));

                }
                catch(NullPointerException e)
                {

                }
        extent.endTest(test);
        extent.flush();
                /*
*/




    }


    @DataProvider
    public Object[][] UserInput() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("ExcelData/RegistrationInput.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

        HSSFSheet sheet = workbook.getSheet("RegistrationInput");

        int RowCount = sheet.getPhysicalNumberOfRows();

        String data[][] = new String[RowCount - 2][19];

        for (int i = 2; i < RowCount; i++)

        {
            HSSFRow row = sheet.getRow(i);

            HSSFCell PrifixCell = row.getCell(0);
            if (PrifixCell == null) {
                data[i - 2][0] = "";
            } else {
                PrifixCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][0] = PrifixCell.getStringCellValue();
            }


            HSSFCell FirstName = row.getCell(1);
            if (FirstName == null) {
                data[i - 2][1] = "";
            } else {
                FirstName.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][1] = FirstName.getStringCellValue();
            }

            HSSFCell MiddelName = row.getCell(2);
            if (MiddelName == null) {
                data[i - 2][2] = "";
            } else {
                MiddelName.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][2] = MiddelName.getStringCellValue();
            }
            HSSFCell LastName = row.getCell(3);
            if (LastName == null) {
                data[i - 2][3] = "";
            } else {
                LastName.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][3] = LastName.getStringCellValue();
            }

            HSSFCell qualification = row.getCell(4);
            if (qualification == null) {
                data[i - 2][4] = "";
            } else {
                qualification.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][4] = qualification.getStringCellValue();
            }
            HSSFCell FirmName = row.getCell(5);
            if (FirmName == null) {
                data[i - 2][5] = "";
            } else {
                FirmName.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][5] = FirmName.getStringCellValue();
            }
            HSSFCell PostalAddress = row.getCell(6);
            if (PostalAddress == null) {
                data[i - 2][6] = "";
            } else {
                PostalAddress.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][6] = PostalAddress.getStringCellValue();
            }


            HSSFCell State = row.getCell(7);
            if (State == null) {
                data[i - 2][7] = "";
            } else {
                State.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][7] = State.getStringCellValue();
            }

            HSSFCell City= row.getCell(8);
            if (City == null) {
                data[i - 2][8] = "";
            } else {
                City.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][8] = City.getStringCellValue();
            }
            HSSFCell PinCode= row.getCell(9);
            if (PinCode == null) {
                data[i - 2][9] = "";
            } else {
                PinCode.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][9] = PinCode.getStringCellValue();
            }

            HSSFCell MobileNo= row.getCell(10);
            if (MobileNo == null) {
                data[i - 2][10] = "";
            } else {
                MobileNo.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][10] = MobileNo.getStringCellValue();
            }
            HSSFCell Email= row.getCell(11);
            if (Email == null) {
                data[i - 2][11] = "";
            } else {
                Email.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][11] = Email.getStringCellValue();
            }

            HSSFCell IdProf= row.getCell(12);
            if (IdProf == null) {
                data[i - 2][12] = "";
            } else {
                IdProf.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][12] = IdProf.getStringCellValue();
            }

            HSSFCell RegiNo= row.getCell(13);
            if (RegiNo == null) {
                data[i - 2][13] = "";
            } else {
                RegiNo.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][13] = RegiNo.getStringCellValue();
            }

            HSSFCell LoginName= row.getCell(14);
            if (LoginName == null) {
                data[i - 2][14] = "";
            } else {
                LoginName.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][14] = LoginName.getStringCellValue();
            }


            HSSFCell LoginPassword= row.getCell(15);
            if (LoginPassword == null) {
                data[i - 2][15] = "";
            } else {
                LoginPassword.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][15] = LoginPassword.getStringCellValue();
            }

            HSSFCell RePassword= row.getCell(16);
            if (RePassword == null) {
                data[i - 2][16] = "";
            } else {
                RePassword.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][16] = RePassword.getStringCellValue();
            }

            HSSFCell Applican = row.getCell(17);
            if (Applican == null) {
                data[i - 2][17] = "";
            } else {
                Applican.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][17] = Applican.getStringCellValue();
            }

            HSSFCell Expeted= row.getCell(18);
            if (Expeted == null) {
                data[i - 2][18] = "";
            } else {
                Expeted.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][18] = Expeted.getStringCellValue();
            }
        }
        return data;

    }
}