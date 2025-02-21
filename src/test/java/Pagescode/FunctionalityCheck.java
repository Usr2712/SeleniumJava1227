package Pagescode;

import CommonMethods.Screenshot;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.io.FileHandler;

public class FunctionalityCheck {



    Screenshot screenshot= new Screenshot();

    private WebDriver driver;


    @FindBy(xpath = "//a[contains(text(),'Droppable')]")
    static WebElement Draganddroplink;



    @FindBy(xpath = "//a[contains(text(),'Resizable')]")
    static WebElement Resizelink;

    @FindBy(xpath = "//div[@id='resizable']")
    static WebElement Resizeelement;

    @FindBy(xpath = "//div[@id='droppable']")
    static WebElement DesFile;

    @FindBy(xpath = "//a[(text()='Button')]")
    static WebElement obj;



    @FindBy(xpath = "//iframe[@class='demo-frame']")
    static WebElement Iframe;

    @FindBy(xpath = "//a[contains(text(),'Datepicker')]")
    static WebElement datePicker;

    @FindBy(xpath = "//input[@id='datepicker']")
    static WebElement datePick;



    public FunctionalityCheck(WebDriver driver){


        this.driver=driver;
        PageFactory.initElements(driver, this); // Initializes elements
    }

    public void DragAndDrop() throws InterruptedException, IOException {


      //  screenshot.screeshotcode();
        Draganddroplink.click();
       // screenshot.screeshotcode();
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);",obj);
        Thread.sleep(1000);
        System.out.println("scrolled");
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        driver.switchTo().frame(Iframe);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement src = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='draggable']")));
        WebElement Des = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='droppable']")));
        actions.moveToElement(src).clickAndHold().moveToElement(Des).release().build().perform();


        //screenshot.screeshotcode();

    }

    public void Resize() throws IOException, InterruptedException {

       // screenshot.screeshotcode("before_resizing");
        Resizelink.click();
        driver.switchTo().frame(Iframe);

        System.out.println(Resizeelement.getLocation());

        Thread.sleep(2000);
       // screenshot.screeshotcode("inside_Iframe");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -200);");
        Thread.sleep(1000);


        // Resize the element using JavaScript
        js.executeScript("arguments[0].style.width = '510px'; arguments[0].style.height = '287px';", Resizeelement);

        // ✅ **Wait until the new size is applied before taking a screenshot**
        int maxRetries = 10;
        boolean sizeUpdated = false;
        for (int i = 0; i < maxRetries; i++) {
            Thread.sleep(500); // Give the DOM some time to update
            long width = (long) js.executeScript("return arguments[0].offsetWidth;", Resizeelement);
            long height = (long) js.executeScript("return arguments[0].offsetHeight;", Resizeelement);

            if (width == 510 && height == 287) {
                sizeUpdated = true;
                break;
            }
        }

        if (!sizeUpdated) {
            System.out.println("Warning: Resizing may not have been applied correctly.");
        }
        // ✅ **Ensure JavaScript Forces the Resizing Before Screenshot**
        js.executeScript("arguments[0].style.width = '510px'; arguments[0].style.height = '287px';", Resizeelement);

        // ✅ **Take the screenshot AFTER confirming the size change**
        screenshot.screeshotcode("After_Resizing");



        Thread.sleep(2000);



    }

    public void CalendarTest() throws InterruptedException, IOException {

        datePicker.click();

       /* LocalDate dt =LocalDate.now();

        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("MM/dd/yyyy");

        String date = dtf.format(dt);

        System.out.println(date);*/

        driver.switchTo().frame(Iframe);

       datePick.click();

       String year = "2026";
       String month = "February";
       String date="18";




        while(true) {

            // WebElement CurrentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));

            //  WebElement CurrentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));

            WebElement CurrentDate = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));

            String currentDate = CurrentDate.getText();
            System.out.println(currentDate);
          /* String currentYear = CurrentYear.getText();
            String currentMonth = CurrentMonth.getText();*/
             String[] currentYearsplit = currentDate.split(" ");

            String currentYear = currentYearsplit[1];
            String currentMonth =  currentYearsplit[0];



            if (currentYear.equals(year) && currentMonth.equals(month)) {
                break;  // Stop when the correct year is found
            }
            WebElement rightIcon = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));

            rightIcon.click();
            Thread.sleep(3000);

        }
        WebElement datetoselect = driver.findElement(By.xpath(String.format("//a[text()='%s']",date)));
        datetoselect.click();

        screenshot.screeshotcode("takescreenshot");


        }

    public void CalendarTest(String date, String year, String month) throws InterruptedException, IOException {



        datePicker.click();

       /* LocalDate dt =LocalDate.now();

        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("MM/dd/yyyy");

        String date = dtf.format(dt);

        System.out.println(date);*/

        driver.switchTo().frame(Iframe);

        datePick.click();





        while(true) {


            WebElement CurrentDate = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));

            String currentDate = CurrentDate.getText();
            System.out.println(currentDate);
             String[] currentYearsplit = currentDate.split(" ");

            String currentYear = currentYearsplit[1];
            String currentMonth =  currentYearsplit[0];



            if (currentYear.equals(year) && currentMonth.equals(month)) {
                break;  // Stop when the correct year is found
            }
            WebElement rightIcon = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));

            rightIcon.click();
            Thread.sleep(3000);

        }
        WebElement datetoselect = driver.findElement(By.xpath(String.format("//a[text()='%s']",date)));
        datetoselect.click();

        screenshot.screeshotcode("takescreenshot");


    }
}



