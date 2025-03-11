package CommonMethods;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;

public class ExcelCommoncode {

   static Workbook workbook;
   static Sheet sheet;
   static FileInputStream fis;
   static  FileOutputStream fo;

   static Row row;
   static Cell cell;

    public static int getRowCount (String Filepath ,String SheetName) throws IOException {


        fis = new FileInputStream(Filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(SheetName);

        int TotalRowsCount = sheet.getLastRowNum();

        workbook.close();
        fis.close();

        return TotalRowsCount;

    }

    public static int getColumnCount (String Filepath ,String SheetName , int Rownum) throws IOException {


        fis = new FileInputStream(Filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(SheetName);
         row =sheet.getRow(Rownum);


        int TotalCellCount = row.getLastCellNum();

        workbook.close();
        fis.close();

        return TotalCellCount;
    }

    public static String getCellData(String Filepath,String SheetName ,int Rownum ,int CellNum) throws IOException {


        fis = new FileInputStream(Filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.createSheet(SheetName);
        row =sheet.getRow(Rownum);
        cell = row.getCell(CellNum);

        String data;

        try{

           // data=cell.toString();

            DataFormatter dataFormatter = new DataFormatter();
            data=dataFormatter.formatCellValue(cell);
        } catch (Exception e) {

            data="";
        }

        workbook.close();
        fis.close();

        return data;
    }

    public static void setCellData(String Filepath,String SheetName ,int Rownum ,int ColumnNum,String data) throws IOException {

        fis = new FileInputStream(Filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(SheetName);
        row =sheet.getRow(Rownum);
        cell = row.createCell(ColumnNum);
        cell.setCellValue(data);
        fo = new FileOutputStream(Filepath);
        workbook.write(fo);
        workbook.close();
        fo.close();

    }


}
