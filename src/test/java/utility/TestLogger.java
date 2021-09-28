package utility;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Reporter;
import utility.BaseTest;
import utility.ExtentTestManager;

public class TestLogger extends BaseTest {
    public static void log(final String message) {
        Reporter.log(message + "<br>", true);
        ExtentTestManager.getTest().log(LogStatus.INFO, message + "<br>");  // new
    }
}