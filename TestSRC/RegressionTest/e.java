/*
package RegressionTest;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.write.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static jxl.format.Colour.GREEN;
import static jxl.format.Colour.RED;
import static jxl.format.Colour.YELLOW;

*/
/*
*
 * Created by laxmikant on 19/05/2017.

*//*


public class e {
    public String TestCase;
    public String Result="pass";
    public WritableWorkbook workbookcopy;
    public WritableSheet WriteTableS;
    public WritableCell Getcell;
    public WritableCellFormat cellFormat;
    public WritableCellFormat cellFormat2;
    public WritableCellFormat cellFormat3;
    public WritableCellFormat cellFormat4;

    public Sheet sheet;
    @BeforeTest
    public void ExcelWdata() throws IOException, BiffException, WriteException {
        FileInputStream fis=new FileInputStream("ExcelData/RegistrationInput.xls");

        Workbook workbook=Workbook.getWorkbook(fis);

        sheet=workbook.getSheet("RegistrationInput");
        int noRows=sheet.getRows();
       */
/* String InputData[][]=new String[sheet.getRows()][sheet.getColumns()];
        System.out.println(noRows);
*//*

        FileOutputStream fos=new FileOutputStream("ExcelData/TestResult.xls");
        System.out.println("Create New File");

        workbookcopy=workbook.createWorkbook(fos);
        WriteTableS=workbookcopy.createSheet("n",0);
        WritableFont cellFont = new WritableFont(WritableFont.COURIER, 10);

        WritableFont cellFont2 = new WritableFont(WritableFont.COURIER, 10);
        cellFormat = new WritableCellFormat(cellFont);
        cellFormat.setBackground(GREEN);
        cellFormat2 = new WritableCellFormat(cellFont);
        cellFormat2.setBackground(RED);

        cellFormat3 = new WritableCellFormat(cellFont);
        cellFormat3.setBackground(YELLOW);

        // cellFormat.setBackground(LIGHT_BLUE);
        for(int i=0;i<sheet.getRows();i++)
        {
            for (int k=0;k<sheet.getColumns();k++)
            {
                WritableCell readCell =sheet.getWritableCell(k,i);
                WritableCell newCell =  readCell.copyTo(k,i);

                CellFormat readFormat = readCell.getCellFormat();


               */
/* InputData[i][k]=sheet.getCell(k,i).getContents();

                Cell readCell = sheet.getCell(k,i);
              WritableCell newCell = readCell.copyTo(k,i);
                CellFormat readFormat = readCell.getCellFormat();

                Label l1=new Label(k,i,InputData[i][k]);
                *//*
Label l7=new Label(0,0,"Test Report",cellFormat3);
                cellFont2.setColour(RED);
                Label l2=new Label(19,1,"Actual Message");
                Label l3=new Label(20,1,"Result");
                WritableCellFormat newFormat = new WritableCellFormat(readFormat);
                newCell.setCellFormat(newFormat);

                WriteTableS.addCell(newCell);

                // Label l6=new Label(7,,"TestCase Fail Due To");
                WriteTableS.addCell(l1);
                WriteTableS.addCell(l2);
                WriteTableS.addCell(l3);
                WriteTableS.addCell(l7);
                //  WriteTableS.addCell(l6);
            }
        }

    }
    @AfterTest
    public void d() throws IOException {
        try {
            workbookcopy.write();

        } catch (IOException e) {
            System.out.println(e);
        }
        try {
            workbookcopy.close();
        } catch (WriteException e) {
            e.printStackTrace();

        }
    }



}
*/
