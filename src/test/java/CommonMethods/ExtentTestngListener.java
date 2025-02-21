package CommonMethods;

import StepDefinitions.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestngListener implements ITestListener {

    private ExtentTest test;
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






}
