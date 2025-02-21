package Pagescode;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "D:\\Users\\Sairaghavendra\\IdeaProjects\\SeleniumJava1227\\src\\test\\resources\\features\\Market.feature",
        glue = "StepDefinitions",
        tags = "@Functionality271227",
        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

   /* @Override
    @DataProvider(parallel = true)
   public Object[][] scenarios(){
        return super.scenarios();
    }*/
}