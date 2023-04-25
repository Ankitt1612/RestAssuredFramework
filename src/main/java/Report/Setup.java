package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;
import java.util.Stack;

public class Setup implements ITestListener {


    private static ExtentReports instance ;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public void onStart(ITestContext context){
        String fileName = ExtentReportManager.getExtentReportWithTime();
        String fullReportPath = System.getProperty("user.dir")+"\\reports\\" + fileName;
        instance =  ExtentReportManager.createInstance(fileName, "Api report", "test execution");

    }

    public void onFinish(ITestContext context){

        if (instance!= null)
            instance.flush();

    }

    public void onTestStart(ITestResult result){
        ExtentTest test = instance.createTest("Test Name " + result.getTestClass().getName() + " - " + result.getMethod().getMethodName(),
                result.getMethod().getDescription());
        extentTest.set(test);
    }

    public void onTestFailure(ITestResult result){
        ExtentReportManager.logFailureDetails(result.getThrowable().getMessage());
        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
        stackTrace = stackTrace.replaceAll(",", "<br>");
        String formattedStackTrace = "<details>" +
                "<summary>Click Here to see logs</summary>" + stackTrace +
                "</details>";
        ExtentReportManager.logExceptions(formattedStackTrace);

    }
}
