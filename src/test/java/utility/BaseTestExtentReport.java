package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.BeforeSuite;

public class BaseTestExtentReport {
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports report;
    public ExtentTest logger;

    @BeforeSuite
    public void setupSuite() {
        String reportpath = System.getProperty("user.dir") + "\\Reports\\TimeKeeper" + Helper.getCurrentDateTime() + ".html";
        htmlReporter = new ExtentHtmlReporter(reportpath);
        report = new ExtentReports();
        report.attachReporter(htmlReporter);

        report.setSystemInfo("OS", "Windows 10");
        report.setSystemInfo("Host Name", "Narasimha Reddy");
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("User Name", "Narasimha Reddy");

        //htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Time Keeper automation report");
        htmlReporter.config().setReportName("Time Keeper Report");
        //htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    public void tearDownSuite(){
        report.flush();
    }
}
