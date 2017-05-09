package RegressionTest;

import com.sun.deploy.xml.XMLable;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.udf.UDFFinder;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by AKSHAY on 09/05/2017.
 */

public class ExcelsheetTest {

    public String TestCase;
    public String Result="pass";
    public WritableWorkbook workbookcopy;
    public WritableSheet WriteTableS;

    public Sheet sheet;
    @BeforeTest
    public void ExcelWdata() throws IOException, BiffException, WriteException {
        FileInputStream fis=new FileInputStream("ExcelData/n.xls");
        Workbook workbook=Workbook.getWorkbook(fis);

      sheet=workbook.getSheet("n");
        int noRows=sheet.getRows();
        String InputData[][]=new String[sheet.getRows()][sheet.getColumns()];
        System.out.println(noRows);

        FileOutputStream fos=new FileOutputStream("ExcelData/outPut.xls");
        System.out.println("Create New File");

        workbookcopy=workbook.createWorkbook(fos);
        WriteTableS=workbookcopy.createSheet("n",0);

        for(int i=0;i<sheet.getRows();i++)
        {
            for (int k=0;k<sheet.getColumns();k++)
            {
                InputData[i][k]=sheet.getCell(k,i).getContents();
                Label l1=new Label(k,i,InputData[i][k]);
                Label l2=new Label(5,0,"AlertMessage");
                Label l3=new Label(6,0,"Result");
                WriteTableS.addCell(l1);
                WriteTableS.addCell(l2);
                WriteTableS.addCell(l3);
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
