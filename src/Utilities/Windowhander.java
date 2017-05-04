package Utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Created by AKSHAY on 02/05/2017.
 */
public class Windowhander {
    static WebDriver driver;
    public static void NewWindow(WebDriver driver) {
        String parentWindow = driver.getWindowHandle();

        Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
    }
}
