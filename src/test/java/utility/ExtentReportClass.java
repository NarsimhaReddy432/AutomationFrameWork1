package utility;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;

public class ExtentReportClass {

    public static ExtentReports report;
    public static ExtentTest logger;
    String nameOS = "os.name";
    String versionOS = "os.version";
    String architectureOS = "os.arch";


    @BeforeSuite
    public void startReport() {
        nameOS = System.getProperty(nameOS);
        versionOS = System.getProperty(versionOS);
        architectureOS = System.getProperty(architectureOS);

        String reportpath = System.getProperty("user.dir") + "\\Reports\\TimeKeeper_Automation Report_" + Helper.getCurrentDateTime() + ".html";
        report = new ExtentReports(reportpath, true);
        report
                .addSystemInfo("Host Name", "Narasimha Reddy")
                .addSystemInfo("Environment", "QA - Automation Testing")
                .addSystemInfo("User Name", "Narasimha Reddy")
                .addSystemInfo("Time Zone", System.getProperty("user.timezone"))
                .addSystemInfo("Selenium", "3.7.0")
                .addSystemInfo("Maven", "3.5.2")
                .addSystemInfo("Java Version", "1.8.0_151")
                .addSystemInfo("Name of the Operating System", nameOS)
                .addSystemInfo("Version of the Operating System", versionOS)
                .addSystemInfo("Architecure of the Operating System ", architectureOS);
        report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
    }

    @AfterSuite
    public void endReport() {
        report.flush();
//        report.close();
    }
}
