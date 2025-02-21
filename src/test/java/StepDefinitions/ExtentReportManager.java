package StepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;

import java.io.File;

public class ExtentReportManager {


    private static ExtentReports extentReports;
    private static ExtentSparkReporter extentSparkReporter;


    public static ExtentReports getReport() {

        if (extentReports == null) {

            extentSparkReporter = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/test-output/ExtentReport.html"));

            extentReports = new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);
            extentReports.setSystemInfo("OS","Windows");
            extentReports.setSystemInfo("Browse","Chrome");
            extentReports.setSystemInfo("Environment","QA");

        }

        return extentReports;
    }


    @After(order = 1)
    public static void flushReports() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

}
