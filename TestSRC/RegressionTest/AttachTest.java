package RegressionTest;

import Pages.AppRegistration;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import static Utilities.AttachFunction.AttachFuntn;
import static Utilities.IDProofType.AttachID;
import static Utilities.OpenBrowser.GetUrl;
import static Utilities.OpenBrowser.openBrowser;
import static Utilities.WindowFun2.WindowFunction2;
import static Utilities.Windowhander.LastWindow;
import static Utilities.Windowhander.NewWindow;
import static Utilities.copAtt.Attachcopy;

/**
 * Created by AKSHAY on 05/05/2017.
 */
public class AttachTest {

WebDriver driver;
    @Test
    public void attachTest() throws AWTException, InterruptedException {
        driver = openBrowser("chrome");
        GetUrl("url");
        AppRegistration appRegistration = new AppRegistration(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        appRegistration.setRegistrationLink();
        String p = "E:\\UBBL 2016.pdf";
        NewWindow(driver);

        driver.findElement(By.id("IdattachIdproof")).click();

        String WinHandleBefore1 = driver.getWindowHandle();
        // Switch to new window opened
        for (String Handle1 : driver.getWindowHandles()) {
            driver.switchTo().window(Handle1);
        }

        try {
            Thread.sleep(500);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
        ss.click();

        StringSelection uploadphoto = new StringSelection("E:\\UBBL 2016.pdf");
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


        Thread.sleep(4000);
        //WebDriverWait wait = new WebDriverWait(driver,1000);

        driver.switchTo().window(WinHandleBefore1);          // switch back to the original window
        driver.findElement(By.id("btnAttached")).click();
        String WinHandleBefore3 = driver.getWindowHandle();
        // Switch to new window opened
        for (String Handle3 : driver.getWindowHandles()) {
            driver.switchTo().window(Handle3);
        }
        try {
            Thread.sleep(600);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.sleep(500);
        WebElement ss2 = driver.findElement(By.id("RadAsyncUpload1file0"));
        ss2.click();
        Thread.sleep(2000);
        StringSelection uploadphoto2 = new StringSelection("E:\\UBBL 2016.pdf");
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
        Thread.sleep(500);
    }
}
