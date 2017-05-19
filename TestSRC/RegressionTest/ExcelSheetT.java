package RegressionTest;

import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.write.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import static jxl.format.Colour.GREEN;
import static jxl.format.Colour.RED;

/**
 * Created by laxmikant on 19/05/2017.
 */
public class ExcelSheetT {

    public Label l4;
    public WritableCellFormat cellFormat;
    public WritableCellFormat cellFormat2;
    public String TestCase;
    WritableWorkbook writableTempSource;
    WritableWorkbook copyDocument;
    WritableSheet sourceSheet;
    WritableSheet targetSheet;
    Workbook sourceDocument;
    int LastRow;

    @BeforeTest
    public void ExcelWdata() throws IOException, BiffException, WriteException {

        sourceDocument = Workbook.getWorkbook(new File("ExcelData/RegistrationInput.xls"));
        writableTempSource = Workbook.createWorkbook(new File("ExcelData/temp.xls"), sourceDocument);
        copyDocument = Workbook.createWorkbook(new File("ExcelData/TestReport.xls"));
        sourceSheet = writableTempSource.getSheet(0);
        targetSheet = copyDocument.createSheet("sheet 1", 0);

        WritableFont cellFont = new WritableFont(WritableFont.COURIER, 10);

        WritableFont cellFont2 = new WritableFont(WritableFont.COURIER, 10);
        cellFormat = new WritableCellFormat(cellFont);
        cellFormat.setBackground(GREEN);
        cellFormat2 = new WritableCellFormat(cellFont);
        cellFormat2.setBackground(RED);

        for (int row = 0; row < sourceSheet.getRows(); row++) {
            for (int col = 0; col < sourceSheet.getColumns(); col++) {
                WritableCell readCell = sourceSheet.getWritableCell(col, row);
                WritableCell newCell = readCell.copyTo(col, row);
                CellFormat readFormat = readCell.getCellFormat();

                WritableCellFormat newFormat = new WritableCellFormat(readFormat);
                newCell.setCellFormat(newFormat);
                targetSheet.addCell(newCell);


                Label l2=new Label(19,1,"Actual Message");

                Label l3=new Label(20,1,"Result");


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
