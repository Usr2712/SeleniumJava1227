package CommonMethods;

import StepDefinitions.DriverInitialization;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Screenshot {

    private WebDriver driver= DriverInitialization.getDriver();

    public  void screeshotcode(String str) throws IOException, InterruptedException {

        //Date d = new Date();
        //String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(d);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);"); // Scroll to bottom
        Thread.sleep(500);
        js.executeScript("window.scrollTo(0, 0);"); // Scroll back to top
        Thread.sleep(500);

        // Refresh page to force full rendering
        driver.navigate().refresh();
        Thread.sleep(2000); // Allow time to reload

        LocalDateTime ld = LocalDateTime.now();

        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

       String timestamp = dtf.format(ld);

       //This will take screenshot of page will is displaying

       // TakesScreenshot screenshot = (TakesScreenshot) driver;

       // File scrfile =screenshot.getScreenshotAs(OutputType.FILE);

        // Use Ashot to capture full-page screenshot
        ru.yandex.qatools.ashot.Screenshot fullPageScreenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(2000))
                .takeScreenshot(driver);

        String path =System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "Screenshots"
                + File.separator  + "newimg_" + str + timestamp + ".png";
       // File destination = new File(path);
      //  FileHandler.copy(scrfile,destination);

        ImageIO.write(fullPageScreenshot.getImage(), "PNG", new File(path));


        
    }
}
