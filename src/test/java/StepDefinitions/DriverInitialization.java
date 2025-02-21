package StepDefinitions;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInitialization {

    private static WebDriver driver;


    @Before
    public void Driverinit(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    public static WebDriver getDriver() {
        if (driver == null) {
            new DriverInitialization().Driverinit();  // Create instance only if not already created
        }
        return driver;
    }


}
