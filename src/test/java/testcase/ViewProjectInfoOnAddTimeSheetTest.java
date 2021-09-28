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
import pages.Home11;
import pages.Login;
import utility.CaptureScreenshot;
import utility.ExtentReportClass;
import utility.KeyEvents;

import java.io.IOException;

public class ViewProjectInfoOnAddTimeSheetTest extends ExtentReportClass {

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

    @Test(enabled = true, priority = 1, groups = {"smoke", "regression"}, description = "Verify that while submitting the timesheet users can click on Eye button and view the project information")
    public void testViewProjectInfo() throws InterruptedException {
        String screenShotPath = "";
        String projectInfo= "";
        Boolean flag =false;
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
                if (objHome.getTextMyTimeMenu().equalsIgnoreCase("My Time")) {
                    objHome.clickMytimeMenu();
                    objHome.selectWeek();
                    objHome.clickCreateNewBtn();
                    objHome.selectProject();
                     projectInfo = objHome.getProjectInfo();
                     logger.log(LogStatus.INFO, "Project Info is:" + projectInfo);
                     if(projectInfo.contains("ID")){
                         flag=true;
                     }
                    Assert.assertTrue(flag);

                    screenShotPath = objCaptureScreenshot.captureScreenshot(screenshotName);
                    logger.log(LogStatus.PASS, "Project info. verification on new time sheet is successful" + logger.addScreenCapture(screenShotPath));
                }
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception while verifying project info on new time sheet" + logger.addScreenCapture(screenShotPath));
        }
    }


    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        BrowserFactory.closeBrowser(driver);

    }

}