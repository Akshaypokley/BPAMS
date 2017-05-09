package Utilities;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by laxmikant on 06/05/2017.
 */
public class ResultFunction {
    static WebDriver driver;

    public static void ShowR(WebDriver driver, String r,String A) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("ExcelData/n.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

        HSSFSheet worksheet = workbook.getSheet("n");

        int rowCount = worksheet.getPhysicalNumberOfRows();

 for (int i = 1; i < rowCount;i++) {

            HSSFRow row = worksheet.getRow(i);

            HSSFCell Actual = row.createCell(5);
            Actual.setCellValue(A);
           /* String DateStr = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
            String ER = "nh" + DateStr + ".xls";
            String imagePath = "ExcelData/" + ER;*/
            FileOutputStream fout = new FileOutputStream("ExcelData/n1.xls");
            workbook.write(fout);
            fout.close();



    }  }}