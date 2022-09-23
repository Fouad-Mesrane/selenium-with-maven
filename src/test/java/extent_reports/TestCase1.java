package extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TestCase1 {

    public ExtentSparkReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeTest
    public void setReport() {
        htmlReporter = new ExtentSparkReporter("./reports/extent.html");

        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("W2A Automation Reports");
        htmlReporter.config().setReportName("Automation Test results");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "Fouad Mesrane");
        extent.setSystemInfo("Organization", "Way2Automation");
        extent.setSystemInfo("Build-No", "W2A-1234");


    }

    @AfterTest
    public void endReport() {
        extent.flush();
    }

    @Test
    public void doLogin() {
        test = extent.createTest("Login Test");
        test.log(Status.INFO, "Enter Username");
        test.log(Status.INFO, "Enter Password");

    }

    @Test
    public void doUserReg() {
        test = extent.createTest("User Reg Test");
        test.log(Status.INFO, "Enter Username");
        test.log(Status.INFO, "Enter Password");
        test.log(Status.FAIL, "Failing the Test -screenshot attached");
        Assert.fail("failing User reg Test");
    }

    @Test
    public void validateTitle() {
        test = extent.createTest("Validate Title Test");
        test.log(Status.INFO, "Validating Title");
        throw new SkipException("Skipping the test case");

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {

            String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
            String screenshot = "C:\\Users\\fouad\\OneDrive\\Pictures\\Screenshots\\Screenshot 2022-09-16 120939.png";

            test.fail("<b><font color = red>Screenshot of failure</font></b><br>", MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());

            test.fail(exceptionMessage);

           Markup m =  MarkupHelper.createLabel("Test Case Failed", ExtentColor.RED);
            test.log(Status.FAIL, m);

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Passed Test");

        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Skipped Test");
        }
    }

}
