package RegressionTest;

import com.sun.deploy.xml.XMLable;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.*;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.udf.UDFFinder;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Iterator;
import java.util.List;

import static jxl.format.Colour.*;

/**
 * Created by AKSHAY on 09/05/2017.
 */

public class ExcelsheetTest {

    public String TestCase;
    public String Result="pass";
    public WritableWorkbook workbookcopy;
    public WritableSheet WriteTableS;
    public WritableCellFormat cellFormat;
    public WritableCellFormat cellFormat2;
    public WritableCellFormat cellFormat3;
    public Sheet sheet;
    @BeforeTest
    public void ExcelWdata() throws IOException, BiffException, WriteException {
        FileInputStream fis=new FileInputStream("ExcelData/RegistrationInput.xls");
        Workbook workbook=Workbook.getWorkbook(fis);

      sheet=workbook.getSheet("RegistrationInput");
        int noRows=sheet.getRows();
        String InputData[][]=new String[sheet.getRows()][sheet.getColumns()];
        System.out.println(noRows);

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
                InputData[i][k]=sheet.getCell(k,i).getContents();
               Label l1=new Label(k,i,InputData[i][k]);
              Label l7=new Label(0,0,"Test Report",cellFormat3);
                cellFont2.setColour(RED);
                Label l2=new Label(19,1,"Actual Message");
                Label l3=new Label(20,1,"Result");

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
