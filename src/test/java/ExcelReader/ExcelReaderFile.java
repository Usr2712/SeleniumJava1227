package ExcelReader;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelReaderFile {

    FileOutputStream fis;

    public void ExcelReader(String SheetName ,List<WebElement> AllProducts) throws IOException {


            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(SheetName);

            // Write column header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Text from WebElements");

            // Extract text from elements and write to Excel
            int rowNum = 1;
            for (WebElement element : AllProducts) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(element.getText());
            }

            // Save the Excel file
            fis = new FileOutputStream("D:\\Users\\Sairaghavendra\\IdeaProjects\\LearningSelenium\\src\\test\\resources\\Excel\\products.xlsx");

            workbook.write(fis);
            fis.close();
            workbook.close();

            System.out.println("Data written to Excel successfully!");


        }


}
