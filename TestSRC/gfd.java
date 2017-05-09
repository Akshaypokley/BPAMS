import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by laxmikant on 08/05/2017.
 */
public class gfd {

    public static void ShowR(WebDriver driver, String A) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("ExcelData/n.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

        HSSFSheet s = workbook.getSheet("n");

        //String a[][] = new String[s.getRows()][s.getColumns()];
    }
}