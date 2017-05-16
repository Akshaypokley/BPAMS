package RegressionTest;

import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.write.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;

import static jxl.format.Colour.GREEN;
import static jxl.format.Colour.RED;

/**
 * Created by laxmikant on 16/05/2017.
 */
public class ExcelCF {

    public WritableCellFormat cellFormat;
    public WritableCellFormat cellFormat2;
    public String TestCase;
    WritableWorkbook writableTempSource;
    WritableWorkbook copyDocument;
    WritableSheet sourceSheet;
    WritableSheet targetSheet;
    FileOutputStream fos;
    @BeforeTest
    public void ExcelWdata() {

        try {
            Workbook sourceDocument = Workbook.getWorkbook(new File("ExcelData/n.xls"));
      writableTempSource = Workbook.createWorkbook(new File("ExcelData/temp.xls"), sourceDocument);
            fos=new FileOutputStream("ExcelData/copy.xls");

           copyDocument = Workbook.createWorkbook(fos);
        sourceSheet = writableTempSource.getSheet(0);
          targetSheet = copyDocument.createSheet("sheet 1", 0);
         String InputData[][]=new String[sourceSheet.getRows()][sourceSheet.getColumns()];
            WritableFont cellFont = new WritableFont(WritableFont.COURIER, 10);

            WritableFont cellFont2 = new WritableFont(WritableFont.COURIER, 10);
            cellFormat = new WritableCellFormat(cellFont);
            cellFormat.setBackground(GREEN);
            cellFormat2 = new WritableCellFormat(cellFont);
            cellFormat2.setBackground(RED);

            for (int row = 0; row < sourceSheet.getRows(); row++) {
                for (int col = 0; col < sourceSheet.getColumns(); col++) {

                    InputData[row][col]=sourceSheet.getCell(col,row).getContents();

                   // Label l1=new Label(col,row,InputData[row][col]);
                    // Label l7=new Label(0,0,"Test Report",cellFormat3);
                   // cellFont2.setColour(RED);
                    Label l2=new Label(5,1,"Actual Message");
                    Label l3=new Label(6,1,"Result");

/*-----------------------------------------------------------------------------------------------------------------------*/

                    WritableCell readCell = sourceSheet.getWritableCell(col, row);
                    WritableCell newCell = readCell.copyTo(col, row);
                    CellFormat readFormat = readCell.getCellFormat();
                    /* exception on the following line */
                    WritableCellFormat newFormat = new WritableCellFormat(readFormat);
                    newCell.setCellFormat(newFormat);
                    targetSheet.addCell(newCell);

                  //  targetSheet.addCell(l1);
                    targetSheet.addCell(l2);
                    targetSheet.addCell(l3);



                }
            }
            copyDocument.write();
            copyDocument.close();
            writableTempSource.close();
            sourceDocument.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
       /* @Test
                public void h()
        {


        }*/
    }





