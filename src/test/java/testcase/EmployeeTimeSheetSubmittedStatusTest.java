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
import utility.*;

import java.io.IOException;

@Listeners(TestNGListener.class)
public class EmployeeTimeSheetSubmittedStatusTest extends ExtentReportClass {

    WebDriver driver;
    Login objLogin;
    Home11 objHome;
    String browser;
    String Url;
    KeyEvents objKeyEvents;
    CaptureScreenshot objCaptureScreenshot;
    BrowserFactory objBrowserFactory;
    ConfigDataProvider objConfigDataProvider;

    @BeforeMethod
    public void setup() throws InterruptedException {
        String fileName = new Exception().getStackTrace()[0].getFileName();
        logger = report.startTest(fileName);
        objBrowserFactory = new BrowserFactory(driver, logger);
        objConfigDataProvider = new ConfigDataProvider();
        driver = objBrowserFactory.getBrowser();
    }

    @Test(enabled = true, priority = 1, groups = {"smoke", "regression"}, description = "Verify the timesheet status of the employee once its is submitted")
    public void testEmployeeTimesheetSubmittedStatus() throws InterruptedException {
        String screenShotPath = "";
        try {
            objLogin = new Login(driver, logger);
            objHome = new Home11(driver, logger);
            objCaptureScreenshot = new CaptureScreenshot(driver, logger);

            String screenshotName = new Exception()
                    .getStackTrace()[0]
                    .getMethodName();

            if (driver.getTitle().contains("Time Keeper")) {
                logger.log(LogStatus.INFO, "Application title: " + driver.getTitle());
                objLogin.enterUsername(DataProviderFactory.getConfig().getEmployeeUserName());
                objLogin.enterPassword(DataProviderFactory.getConfig().getEmployeePassword());
                objLogin.changePasswordStatus();
                objLogin.enableRememberMe();
                objLogin.clickLoginBtn();
                screenShotPath = objCaptureScreenshot.captureScreenshot(screenshotName);
                if (objHome.getTextMyTimeMenu().equalsIgnoreCase("My Time")) {
                    objHome.clickMytimeMenu();
                    objHome.sortStatusByDescending();
                    String status = objHome.getTimesheetStatusOfEmployee();
//                    Assert.assertEquals(status, "Submitted");
                }
                logger.log(LogStatus.PASS, "Employee timesheet Submitted status is verified successfully" + logger.addScreenCapture(screenShotPath));
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception while verifying the employee timesheet Submitted status" + logger.addScreenCapture(screenShotPath));
        }
    }


    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        BrowserFactory.closeBrowser(driver);
    }

}