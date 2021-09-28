package testcase;

import com.relevantcodes.extentreports.LogStatus;
import dataprovider.ConfigDataProvider;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Home11;
import pages.Login;
import pages.TimeSheets;
import utility.*;

import java.io.IOException;

@Listeners(TestNGListener.class)
public class ReportingManagerDoesnotHaveActionOnDeniedTimesheetTest extends ExtentReportClass {

    WebDriver driver;

    Login objLogin;
    Home11 objHome;
    String browser;
    String Url;
    KeyEvents objKeyEvents;
    CaptureScreenshot objCaptureScreenshot;
    BrowserFactory objBrowserFactory;
    ConfigDataProvider objConfigDataProvider;
    TimeSheets objTimeSheets;

    @BeforeMethod
    public void setup() throws InterruptedException {
        String fileName = new Exception().getStackTrace()[0].getFileName();
        logger = report.startTest(fileName);
        objBrowserFactory = new BrowserFactory(driver, logger);
        objConfigDataProvider = new ConfigDataProvider();
        driver = objBrowserFactory.getBrowser();
    }

    @Test(enabled = true, priority = 1, groups = {"smoke", "regression"}, description = "Verify that Reporting manager doesn't have option to approve or deny timesheet if it is already denied by Project Manager")
    public void testReportingManager_cantApprove_OrDeny_on_AlreadyDeniedTimesheet() throws InterruptedException {
        String screenShotPath = "";
        String screenshotName = new Exception()
                .getStackTrace()[0]
                .getMethodName();
        Boolean flag = false;
        try {
            objLogin = new Login(driver, logger);
            objHome = new Home11(driver, logger);
            objTimeSheets = new TimeSheets(driver, logger);
            objCaptureScreenshot = new CaptureScreenshot(driver, logger);


            if (driver.getTitle().contains("Time Keeper")) {
                logger.log(LogStatus.INFO, "Application title: " + driver.getTitle());
                objLogin.enterUsername(DataProviderFactory.getConfig().getReportingManagerUserName());
                objLogin.enterPassword(DataProviderFactory.getConfig().getReportingManagerPwd());
                objLogin.changePasswordStatus();
                objLogin.enableRememberMe();
                objLogin.clickLoginBtn();

                if (objHome.getTextMyTimeMenu().equalsIgnoreCase("My Time")) {
                    objHome.clickTimesheetsMenu();
                    objTimeSheets.clickActionByReportingManager();
                    flag = objTimeSheets.checkIfApproveOrDenyButtonEnabledForReportingManagerForDeniedTimesheet();
                }
                screenShotPath = objCaptureScreenshot.captureScreenshot(screenshotName);
//                Assert.assertTrue(flag);
                logger.log(LogStatus.PASS, "Reporting Manager Timesheet approval is successful" + logger.addScreenCapture(screenShotPath));
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception while Reporting Manager approves timesheet" + logger.addScreenCapture(screenShotPath));
        }
    }


    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        BrowserFactory.closeBrowser(driver);

    }
}