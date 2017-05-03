package RegressionTest;

import Pages.AppRegistration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static Utilities.OpenBrowser.GetUrl;
import static Utilities.OpenBrowser.openBrowser;

/**
 * Created by AKSHAY on 01/05/2017.
 */
public class RegistrationTest {

    WebDriver driver;

    @BeforeMethod()
    public void LoadBrowser() {
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver = openBrowser("chrome");
        //  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        GetUrl("url");
    }

    @Test
    public void RegistratTest() throws AWTException {
        AppRegistration appRegistration = new AppRegistration(driver);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        appRegistration.setRegistrationLink();
        String parentWindow = driver.getWindowHandle();

        Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                appRegistration.setPriFix("Mr");
                appRegistration.setFirstNm("Akshay");
                appRegistration.setMiddleNM("rajaram");
                appRegistration.setLastNM("Pokley");


                WebElement ss = driver.findElement(By.id("Button1"));
                ss.click();

                 String WinHandleBefore1 = driver.getWindowHandle();
                // Switch to new window opened
                for(String Handle1 : driver.getWindowHandles())
                {
                    driver.switchTo().window(Handle1);
                }
                        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                        WebElement ss2 = driver.findElement(By.id("Radupload1file0"));
                        ss2.click();
                        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                        StringSelection uploadphoto = new StringSelection("E:\\Akshay85\\Resized-RX5MH.jpg");
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


                        //appRegistration.setUploadImage("Image/Resized-RX5MH.jpg");
                        // appRegistration.setApplicantNm("");

                        //     driver.close(); //closing child window
                        // driver.switchTo().window(parentWindow); //cntrl to parent window
                    }


                }
            }

        }
