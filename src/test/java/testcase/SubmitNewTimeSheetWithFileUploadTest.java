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
public class SubmitNewTimeSheetWithFileUploadTest extends ExtentReportClass {

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


    @Test(enabled = true, priority = 1, groups = {"smoke", "regression"}, description = "Employee submits new timesheet for weekdays with attachment upload")
    public void testSubmitNewTimeSheet() throws InterruptedException {
        String screenShotPath = "";
        String screenshotName = new Exception()
                .getStackTrace()[0]
                .getMethodName();
        try {

            objLogin = new Login(driver, logger);
            objHome = new Home11(driver, logger);
            objCaptureScreenshot = new CaptureScreenshot(driver, logger);

            if (driver.getTitle().contains("Time Keeper")) {
                logger.log(LogStatus.INFO, "Application title: " + driver.getTitle());
                objLogin.enterUsername(DataProviderFactory.getConfig().getEmployeeUserName());
                objLogin.enterPassword(DataProviderFactory.getConfig().getEmployeePassword());
                objLogin.changePasswordStatus();
                objLogin.enableRememberMe();
                objLogin.clickLoginBtn();
                if (objHome.getTextMyTimeMenu().equalsIgnoreCase("My Time")) {
                    objHome.clickMytimeMenu();
                    objHome.selectWeek();
                    objHome.clickCreateNewBtn();
                    objHome.selectProject();
                    objHome.selectTask();
                    objHome.enterTimeForWeekDays("8");
                    objHome.enterComments();
                    objHome.clickFileUpload();

                    objHome.clickBrowseBtn();
                    Thread.sleep(3000);
                    Runtime.getRuntime().exec(objConfigDataProvider.getFileUploadPath());
                    Thread.sleep(3000);
                    objHome.clickDoneBtn();
                    objHome.clickSubmitBtn();
                    screenShotPath = objCaptureScreenshot.captureScreenshot(screenshotName);
                    logger.log(LogStatus.PASS, "New time sheet submission is successful" + logger.addScreenCapture(screenShotPath));
                }
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception while submitting new time sheet" + logger.addScreenCapture(screenShotPath));
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        BrowserFactory.closeBrowser(driver);
    }

}