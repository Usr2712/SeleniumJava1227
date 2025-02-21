package Pagescode;

import CommonMethods.ReusedMethods;
import ExcelReader.ExcelReaderFile;
import PropertyFileReader.PropertReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginPage {


    public WebDriver driver;

    public JavascriptExecutor js ;

ExcelReaderFile excelReaderFile = new ExcelReaderFile();

    List<WebElement> AllProducts = new ArrayList<>();

    PropertReader propertReader = new PropertReader();
    @FindBy(xpath = "//input[@id='user-name']")
    static WebElement UserName;

    @FindBy(xpath = "//input[@id='password']")
     static WebElement Password;

    @FindBy(xpath = "//input[@id='login-button']")
    static WebElement Login;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializes elements

    }



    public void openBrowser(){

        propertReader.readPropertyfile();

            driver.get(propertReader.getProperty("MarketUrl"));
        // Switch to the alert



    }

    public void loginwebsite(){

        UserName.sendKeys("standard_user");
       // Password.sendKeys("secret_sauce");
        ReusedMethods.EnterText(Password,"secret_sauce");
        Login.click();
    }

    public  void getLastproducttext(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement lastProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Test.allTheThings() T-Shirt (Red)')]")));
        js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(false);",lastProduct);

        String product =lastProduct.getText();
        System.out.println(product);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(product,"Sample");

    }

    public void GetallProducts() throws IOException {

       AllProducts = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
         /*  Workbook workbook = new XSSFWorkbook();
           Sheet sheet = workbook.createSheet("WebElements Data");

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

*/
       }


    public void GetallProductsandputitInExcel() throws IOException {

        AllProducts = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));

excelReaderFile.ExcelReader("Allproductslist",AllProducts);





    }



    }



