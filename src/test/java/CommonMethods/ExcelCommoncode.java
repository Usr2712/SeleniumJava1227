/*
package CommonMethods;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

public class ExcelCommoncode {

    Workbook workbook;
    Sheet sheet

    public void ExcelWriteLogic(String sheetname ,String Column1,String Column2,String Column3){



        workbook = new XSSFWorkbook();
         sheet = workbook.createSheet(sheetname);

        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue(Column1);
        row.createCell(1).setCellValue(Column2);
        row.createCell(1).setCellValue();

        for (int i = 0; i < Companies.size(); i++) {

            row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(Companies.get(i).getText());
            row.createCell(1).setCellValue(Contact.get(i).getText());
            row.createCell(2).setCellValue(Country.get(i).getText());
            File file = new File("D:\\AutomtionCMS\\NationDetails.xlsx");
            FileOutputStream fileOut = new FileOutputStream(file);
            workbook.write(fileOut);
    }
}
*/
