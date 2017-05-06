package Utilities;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.WebDriver;

import java.io.*;

/**
 * Created by laxmikant on 06/05/2017.
 */
public class ResultFunction {
   static  WebDriver driver;
    public static  void ShowR( WebDriver driver,int i,String R,String A,int cell,int cell2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("ExcelData/n.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

        HSSFSheet sheet = workbook.getSheet("n");

        int RowCount = sheet.getPhysicalNumberOfRows();


        // for(int roi=1;roi<RowCount;roi++)
        {

            HSSFRow row = sheet.getRow( i);

            String Re = "Pass";
            CellStyle style = workbook.createCellStyle();
            HSSFCell resultCell = row.createCell(cell);
            resultCell.setCellValue(R);

            if (R != Re) {
                style.setFillForegroundColor(IndexedColors.RED.getIndex());
                style.setFillPattern(CellStyle.SOLID_FOREGROUND);
                resultCell.setCellStyle(style);
            } else {
                style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                style.setFillPattern(CellStyle.SOLID_FOREGROUND);
                resultCell.setCellStyle(style);
            }

            HSSFCell ActualCell = row.createCell(cell2);
            ActualCell.setCellValue(A);
            if (R != Re) {
                style.setFillForegroundColor(IndexedColors.RED.getIndex());
                style.setFillPattern(CellStyle.SOLID_FOREGROUND);
                resultCell.setCellStyle(style);
            } else {
                style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                style.setFillPattern(CellStyle.SOLID_FOREGROUND);
                resultCell.setCellStyle(style);
            }


            FileOutputStream fout = new FileOutputStream(new File("ExcelData/r8.xls"));
            workbook.write(fout);
            fout.close();
        }

    }






}
