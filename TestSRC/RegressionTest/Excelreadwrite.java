package RegressionTest;
import java.awt.HeadlessException;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.util.concurrent.TimeUnit;

        import org.apache.poi.hssf.usermodel.HSSFCell;
        import org.apache.poi.hssf.usermodel.HSSFRow;
        import org.apache.poi.hssf.usermodel.HSSFSheet;
        import org.apache.poi.hssf.usermodel.HSSFWorkbook;
        import org.apache.poi.ss.usermodel.Cell;
        import org.apache.poi.ss.usermodel.Row;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.testng.annotations.AfterTest;
        import org.testng.annotations.BeforeTest;
        import org.testng.annotations.DataProvider;
        import org.testng.annotations.Test;

import static com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT.value;

/**
 * Created by laxmikant on 09/05/2017.
 */
public class Excelreadwrite {


    private static WebDriver driver;
    private static String baseUrl;
    private static int n = 0;

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "https://xyz.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "DP")
    public static String login(String username, String password)
            throws Exception {

        driver.get(baseUrl + "/login.v");
        String actualtitle = driver.getTitle();
        System.out.println(actualtitle);

        driver.findElement(By.id("login-username")).sendKeys(username);
        driver.findElement(By.id("login-password")).sendKeys(password);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("user-welcome")).click();
        driver.findElement(By.id("user-logout")).click();

        String expectedtitle = driver.getTitle();
        System.out.println("Expected Title is: " + expectedtitle);

        int LastRow = ++n;
        if (expectedtitle.equals(actualtitle)) {
            System.out.println("PASSED");
            String status = "PASS";
            excelwrite(status, LastRow);
        } else {
            System.out.println("FAILED");
            String status = "FAIL";
            excelwrite(status, LastRow);
        }

        return expectedtitle;

    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }

    public static void main(String[] args) throws Exception {
        excelRead();
    }

    @DataProvider(name = "DP")
    public static Object[][] excelRead() throws Exception {
        File excel = new File("C:\\Test\\data.xls");
        FileInputStream fis = new FileInputStream(excel);
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet ws = wb.getSheet("Sheet1");

        int rowNum = ws.getLastRowNum() + 1;
        int colNum = ws.getRow(0).getLastCellNum();
        String[][] data = new String[(rowNum - 1)][colNum];
        int k = 0;
        for (int i = 1; i < rowNum; i++) {
            HSSFRow row = ws.getRow(i);
            for (int j = 0; j < colNum; j++) {
                HSSFCell cell = row.getCell(j);
                String value = cellToString(cell);
                data[k][j] = value;
                // System.out.println("The value is" + value);

            }
            k++;
        }
        return data;

    }

    public static void excelwrite(String status, int LastRow) throws Exception {
        try {
            FileInputStream file = new FileInputStream(new File(
                    "C:\\Test\\data.xls"));

            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);

            Row row = sheet.getRow(LastRow);

            Cell cell2 = row.createCell(2); // Shift the cell value depending upon column size
            cell2.setCellValue(status);
            // System.out.println(status);
            file.close();
            FileOutputStream outFile = new FileOutputStream(new File(
                    "C:\\Test\\data.xls"));
            workbook.write(outFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (HeadlessException e) {
            e.printStackTrace();
        }
    }

    public static String cellToString(HSSFCell cell) {
        int type;
        Object result;
        type = cell.getCellType();
        switch (type) {
            case 0:
                result = cell.getNumericCellValue();
                break;
            case 1:
                result = cell.getStringCellValue();
                break;
            default:
                throw new RuntimeException("There are no support for this type of cell");
        }
        return value;
    }
}