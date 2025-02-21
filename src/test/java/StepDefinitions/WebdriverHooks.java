package StepDefinitions;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;



public class WebdriverHooks {


    WebDriver driver = DriverInitialization.getDriver();



    public void tearDown(){
        if(driver!=null){

            driver.close();
        }


    }

}
