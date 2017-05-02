package RegressionTest;

import Pages.AppRegistration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void LoadBrowser()
    {
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver=openBrowser("chrome") ;
      //  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        GetUrl("url");
    }

    @Test
    public void RegistratTest()
    {
        AppRegistration appRegistration=new AppRegistration(driver);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        appRegistration.setRegistrationLink();
        String parentWindow = driver.getWindowHandle();

        Set<String> handles =  driver.getWindowHandles();
        for(String windowHandle  : handles)
        {
            if(!windowHandle.equals(parentWindow))
            {
                driver.switchTo().window(windowHandle);
                appRegistration.setPriFix("Mr");
                appRegistration.setFirstNm("Akshay");
                appRegistration.setMiddleNM("rajaram");
                appRegistration.setLastNM("Pokley");
                appRegistration.setUploadImage("Image/download.jpg");
                appRegistration.setApplicantNm("");

                //     driver.close(); //closing child window
               // driver.switchTo().window(parentWindow); //cntrl to parent window
            }


        }
    }

}
