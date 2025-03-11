package CommonMethods;

import StepDefinitions.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestngListener implements ITestListener {

    /*private ExtentTest test;
    public String scenarioName;



    @Override
    public void onTestStart(ITestResult result) {

        String scenarioName = result.getMethod().getDescription();

        // Create a new test entry in the Extent report with the scenario name as description
        test = ExtentReportManager.getReport().createTest(scenarioName);

        //test = ExtentReportManager.getReport().createTest(result.getMethod().getMethodName());
    }

    @Override

    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test Passed");
        test.log(Status.INFO, "Test Started: " + scenarioName);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test failed: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flushReports();
    }



*/
    private static ExtentReports extent;
    private static ExtentTest scenarioTest;


    static {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }
    public static void startScenario(String scenarioName) {

        scenarioTest = extent.createTest(scenarioName);
    }
    public static void logFailure(String message) {
        scenarioTest.fail(message); // This correctly marks it as FAILED
    }

    public static void logPass(String message) {
        scenarioTest.pass(message); // This correctly marks it as PASSED
    }

    public static void logStep(String message) {
        scenarioTest.info(message);
    }
    public static void tearDownReport() {
        extent.flush();
    }



}
