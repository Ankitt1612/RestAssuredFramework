package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.http.Header;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExtentReportManager {

    public static ExtentReports createInstance(String filename, String reportName, String documentTitle){

        ExtentSparkReporter report = new ExtentSparkReporter(filename);
        report.config().setReportName(reportName);
        report.config().setDocumentTitle(documentTitle);
        report.config().setTheme(Theme.DARK);
        report.config().setEncoding("utf-8");
        // attaching report to extent spark report
        ExtentReports extentreports = new ExtentReports();
        extentreports.attachReporter(report);
        return extentreports;

    }

    public static String getExtentReportWithTime() {
        DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localdatetime = LocalDateTime.now();
        String formattedTime = datetimeformatter.format(localdatetime);
        String reportName = "TestReport"+formattedTime + ".html";
        return reportName;
    }
    public static void logPassDetails(String log){
        Setup.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));

    }
    public static void logFailureDetails(String log){
        Setup.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }

    public static void logExceptions(String log){
        Setup.extentTest.get().fail(log);
    }
    public static void logInfoDetails(String log){
        Setup.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.ORANGE));
    }

    public static void logJson(String json){
        Setup.extentTest.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }

    public static void printHeaders(List<Header> headersList){
        String[][] arrayHeaders = headersList.stream().map(header -> new String[] {header.getName(), header.getValue()})
                .toArray(String[][]:: new);
        Setup.extentTest.get().info(MarkupHelper.createTable(arrayHeaders));
    }



}
