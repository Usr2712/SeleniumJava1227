package StepDefinitions;

import CommonMethods.ExtentTestngListener;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;



public class WebdriverHooks {


    WebDriver driver = DriverInitialization.getDriver();

    @Before(order =2)
    public void beforeScenario(Scenario scenario) {
       // ExtentTestngListener.setupReport();
        ExtentTestngListener.startScenario(scenario.getName());
    }

    @After(order = 2)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentTestngListener.logFailure("Scenario FAILED: " + scenario.getName());
            // ExtentTestngListener.logStep("Scenario FAILED: " + scenario.getName());
        } else {
            ExtentTestngListener.logPass("Scenario PASSED: " + scenario.getName());
        }
    }



@After(order = 1)
   public void tearDown() {
    if (driver != null) {

        driver.close();
    }

}
    @After(order = 0)
    public void afterAllScenarios() {
        ExtentTestngListener.tearDownReport();
    }
}
