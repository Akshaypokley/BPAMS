package RegressionTest;

import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.write.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import static jxl.format.Colour.*;

/**
 * Created by laxmikant on 19/05/2017.
 */
public class ExcelSheetT {

    public Label l4;
    public WritableCellFormat cellFormat;
    public WritableCellFormat cellFormat2;
    public WritableCellFormat cellFormat3;
    public String TestCase;
    WritableWorkbook writableTempSource;
    WritableWorkbook copyDocument;
    WritableSheet sourceSheet;
    WritableSheet targetSheet;
    Workbook sourceDocument;
    int LastRow;
    public WritableCellFormat cellFormat1;
    @BeforeTest
    public void ExcelWdata() throws IOException, BiffException, WriteException {

        sourceDocument = Workbook.getWorkbook(new File("ExcelData/RegistrationInput.xls"));
        writableTempSource = Workbook.createWorkbook(new File("ExcelData/temp.xls"), sourceDocument);
        copyDocument = Workbook.createWorkbook(new File("ExcelData/TestReport.xls"));
        sourceSheet = writableTempSource.getSheet(0);
        targetSheet = copyDocument.createSheet("sheet 1", 0);

        WritableFont cellFont = new WritableFont(WritableFont.COURIER, 10);


        cellFormat = new WritableCellFormat(cellFont);
        cellFormat.setBackground(GREEN);
        cellFormat2 = new WritableCellFormat(cellFont);
        cellFormat2.setBackground(RED);

        for (int row = 0; row < sourceSheet.getRows(); row++) {
            for (int col = 0; col < sourceSheet.getColumns(); col++) {
                WritableCell readCell = sourceSheet.getWritableCell(col, row);
                WritableCell newCell = readCell.copyTo(col, row);
                CellFormat readFormat = readCell.getCellFormat();
                cellFormat1 = new WritableCellFormat();
                cellFormat1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);

                cellFormat3 = new WritableCellFormat(cellFormat1);
             //   cellFormat3.setBackground();
            //    WritableFont cellFont2 = new WritableFont((jxl.format.Font) cellFormat1);
                WritableCellFormat newFormat = new WritableCellFormat(readFormat);
                newCell.setCellFormat(newFormat);
                targetSheet.addCell(newCell);
                cellFormat = new WritableCellFormat(cellFormat1);
                cellFormat.setBackground(GREEN);
                cellFormat2 = new WritableCellFormat(cellFormat1);
                cellFormat2.setBackground(RED);
                cellFont.setColour(BROWN);

                Label l2=new Label(19,1,"Actual Message",cellFormat3);

                Label l3=new Label(20,1,"Result",cellFormat3);


/*-----------------------------------------------------------------------------------------------------------------------*/


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
