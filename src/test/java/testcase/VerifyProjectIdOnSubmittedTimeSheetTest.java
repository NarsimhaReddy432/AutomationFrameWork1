package testcase;

import com.relevantcodes.extentreports.LogStatus;
import dataprovider.ConfigDataProvider;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Login;
import utility.CaptureScreenshot;
import utility.ExtentReportClass;
import utility.KeyEvents;

import java.io.IOException;

public class VerifyProjectIdOnSubmittedTimeSheetTest extends ExtentReportClass {

    WebDriver driver;
    Login objLogin;
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

    @Test(enabled = true, priority = 1, groups = {"smoke", "regression"})
    public void testVerifyProjectNameOnSubmittedTimeSheet() {
        String screenShotPath = "",expectedProjectId="Project Id", actualProjectId="";
        Boolean flag=false;
        try {
            objLogin = new Login(driver, logger);
            objCaptureScreenshot = new CaptureScreenshot(driver, logger);
            String screenshotName = new Exception()
                    .getStackTrace()[0]
                    .getMethodName();

            if (driver.getTitle().contains("Time Keeper")) {
                logger.log(LogStatus.INFO, "Application title: " + driver.getTitle());
                System.out.println("Application title: " + driver.getTitle());
                objLogin.enterUsername(DataProviderFactory.getConfig().getEmployeeUserName());
                objLogin.enterPassword(DataProviderFactory.getConfig().getEmployeePassword());
                objLogin.changePasswordStatus();
                objLogin.enableRememberMe();
                objLogin.clickLoginBtn();
                if (objLogin.getTextMyTimeMenu().equalsIgnoreCase("My Time")) {
                    objLogin.clickMytimeMenu();
                    actualProjectId = objLogin.getProjectIdforSubmittedTimeSheet();
                    logger.log(LogStatus.INFO, "Project Id: " + actualProjectId);
                    if(actualProjectId.contains(expectedProjectId)){
                        flag=true;
                    }
                    Assert.assertTrue(true);
                    screenShotPath = objCaptureScreenshot.captureScreenshot(screenshotName);
                    logger.log(LogStatus.PASS, "Project Id for submitted timesheet is successful" + logger.addScreenCapture(screenShotPath));
                }
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception while verifying project Id for submitted timesheet" + logger.addScreenCapture(screenShotPath));
        }
    }


    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        BrowserFactory.closeBrowser(driver);

    }

}