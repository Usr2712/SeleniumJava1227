package Pagescode;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class WriteDataCode {


    private WebDriver driver;



    @FindBy(xpath = "")
    static WebElement TotalTable;

    @FindBy(xpath = "//input[@id='login-button']")
    static WebElement Login;


    public WriteDataCode(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializes elements

    }

    public void WriteDateFun() {

        List<WebElement> Totaldata = driver.findElements(By.xpath("//table[@id='customers']//tr//td"));

        //to retrieve all date
        for (int i = 0; i < Totaldata.size(); i++) {

            System.out.println(Totaldata.get(i).getText());

        }
    }
       /* public void retievefrstvalues(){

            List<WebElement> Totaldata = driver.findElements(By.xpath("//table[@id='customers']//tr"));



            //to retrieve frst column values
        for(int i=2;i<=Totaldata.size();i++) {

            WebElement TotalFrstcolumndata = driver.findElement(By.xpath("((//table[@id='customers']//tr)["+i+"])//td[1]"));

            System.out.println(TotalFrstcolumndata.getText());

        }
*/
            public void retrieveFirstColumnValues() throws IOException {
                List<WebElement> Companies = driver.findElements(By.xpath("//table[@id='customers']//tr/td[1]"));
                List<WebElement> Contact = driver.findElements(By.xpath("//table[@id='customers']//tr/td[2]"));
                List<WebElement> Country = driver.findElements(By.xpath("//table[@id='customers']//tr/td[3]"));
                Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Nations");

                Row row = sheet.createRow(0);
                row.createCell(0).setCellValue("Company");
                row.createCell(1).setCellValue("Contact");
                row.createCell(1).setCellValue("Country");

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








}
