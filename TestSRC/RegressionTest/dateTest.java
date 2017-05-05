package RegressionTest;

import Pages.AppRegistration;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static Utilities.DateFunction.DateFun;
import static Utilities.OpenBrowser.GetUrl;
import static Utilities.OpenBrowser.openBrowser;
import static Utilities.Windowhander.NewWindow;

/**
 * Created by AKSHAY on 05/05/2017.
 */
public class dateTest {
    WebDriver driver;
    @Test
    public void DatTest() throws ParseException {

        driver = openBrowser("chrome");
        GetUrl("url");
        AppRegistration appRegistration = new AppRegistration(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        appRegistration.setRegistrationLink();
        NewWindow(driver);

        String d="08/5/2017";
        DateFun(driver,d);

    }


}
