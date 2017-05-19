package RegressionTest;

import jxl.Workbook;
import jxl.format.*;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Border;
import jxl.write.BorderLineStyle;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static jxl.format.Colour.GREEN;
import static jxl.format.Colour.RED;
import static jxl.format.Colour.YELLOW;

/**
 * Created by laxmikant on 16/05/2017.
 */
public class ExcelCF {
    public Label l4;
    public WritableCellFormat cellFormat;
    public WritableCellFormat cellFormat2;
    public String TestCase;
    WritableWorkbook writableTempSource;
    WritableWorkbook copyDocument;
    WritableSheet sourceSheet;
    WritableSheet targetSheet;
    Workbook sourceDocument;
    public WritableCellFormat cellFormat3;
    int LastRow;
    public WritableCellFormat cellFormat1;
    @BeforeTest
    public void ExcelWdata() throws IOException, BiffException, WriteException {

 sourceDocument = Workbook.getWorkbook(new File("ExcelData/n.xls"));
        writableTempSource = Workbook.createWorkbook(new File("ExcelData/temp.xls"), sourceDocument);
        copyDocument = Workbook.createWorkbook(new File("ExcelData/copy.xls"));
        sourceSheet = writableTempSource.getSheet(0);
        targetSheet = copyDocument.createSheet("sheet 1", 0);
        //      String InputData[][]=new String[sourceSheet.getRows()][sourceSheet.getColumns()];
        WritableFont cellFont = new WritableFont(WritableFont.COURIER, 10);

        WritableFont cellFont2 = new WritableFont(WritableFont.COURIER, 10);


        for (int row = 0; row < sourceSheet.getRows(); row++) {
            for (int col = 0; col < sourceSheet.getColumns(); col++) {
                WritableCell readCell = sourceSheet.getWritableCell(col, row);
                WritableCell newCell = readCell.copyTo(col, row);
                CellFormat readFormat = readCell.getCellFormat();
                    /* exception on the following line */
                WritableCellFormat newFormat = new WritableCellFormat(readFormat);
                newCell.setCellFormat(newFormat);
                //  targetSheet.addCell(l4);
                targetSheet.addCell(newCell);
                //  InputData[row][col]=sourceSheet.getCell(col,row).getContents();

                // Label l1=new Label(col,row,InputData[row][col]);
                // Label l7=new Label(0,0,"Test Report",cellFormat3);
                // cellFont2.setColour(RED);


       cellFormat1 = new WritableCellFormat();
                cellFormat1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
               // WritableFont cellFont = new WritableFont(WritableFont.COURIER, 10);  //System.out.println(alertmessage);
                cellFormat3 = new WritableCellFormat(cellFormat1);
                cellFormat3.setBackground(YELLOW);
                cellFormat = new WritableCellFormat(cellFormat1);
                cellFormat.setBackground(GREEN);
                cellFormat2 = new WritableCellFormat(cellFormat1);
                cellFormat2.setBackground(RED);
               /* cellFormat1.setBackground(Colour.LIGHT_BLUE);
                cellFormat1.setAlignment(Alignment.CENTRE);
                cellFormat1.setVerticalAlignment(VerticalAlignment.CENTRE);*/
               // cellFormat1.setBorder(Border.ALL, BorderLineStyle.THIN);
                Label l7=new Label(6,0,"Test Report", cellFormat1);

                Label l2 = new Label(5, 1, "Actual Message",cellFormat3);

                Label l3 = new Label(6, 1, "Result",cellFormat3);

                //    l4    = new Label(5, LastRow, TestCase);
                // fos=new FileOutputStream("ExcelData/copy.xls");
/*-----------------------------------------------------------------------------------------------------------------------*/


                //  targetSheet.addCell(l1);
                targetSheet.addCell(l2);
                targetSheet.addCell(l3);


            }
        }
    }
        @AfterTest
        public void f() throws IOException, WriteException

        {

        copyDocument.write();
            copyDocument.close();
            writableTempSource.close();
            sourceDocument.close();
        }


}
