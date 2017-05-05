package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

import static Utilities.AttachFunction.AttachFuntn;
import static Utilities.WindowFun2.WindowFunction2;

/**
 * Created by laxmikant on 05/05/2017.
 */
public class copAtt {
    static WebDriver driver;

    public static WebDriver Attachcopy(String pp) throws InterruptedException, AWTException {
        driver.findElement(By.id("btnAttached")).click();

        WindowFunction2(driver);

        WebElement ss2 = driver.findElement(By.id("RadAsyncUpload1file0"));
        ss2.click();
        AttachFuntn(pp);

        return driver;
    }
}