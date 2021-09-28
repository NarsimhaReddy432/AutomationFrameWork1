package testcase;

import dataprovider.ConfigDataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.HomePage;
import pages.Login;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import utility.*;

import java.io.IOException;

import org.testng.annotations.Listeners;

@Listeners(TestNGListener.class)
public class EmployeeLoginTest extends ExtentReportClass {

    WebDriver driver;

    Login objLogin;
    HomePage objHome;
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

    @Test(enabled = true, priority = 1, groups = {"smoke", "regression"}, description = "Verify that employee is able to login into application successfully")
    public void testEmployeeLogin() {
        String screenShotPath = "";
        String screenshotName="";

        try {
             objLogin = new Login(driver, logger);
            objHome=new HomePage(driver,logger);
            System.out.println("Object is created for home class");
             screenshotName = new Exception()
                    .getStackTrace()[0]
                    .getMethodName();

            objCaptureScreenshot = new CaptureScreenshot(driver, logger);

            if (driver.getTitle().contains("Time Keeper")) {
                logger.log(LogStatus.INFO, "Application title: " + driver.getTitle());
                objLogin.enterUsername(DataProviderFactory.getConfig().getEmployeeUserName());
                objLogin.enterPassword(DataProviderFactory.getConfig().getEmployeePassword());
                objLogin.changePasswordStatus();
                objLogin.enableRememberMe();
                objLogin.clickLoginBtn();
                screenShotPath = objCaptureScreenshot.captureScreenshot(screenshotName);
                logger.log(LogStatus.INFO, "Screenshot is captured");
                Thread.sleep(3000);


                System.out.println("title is:" + objHome.getTextMyTimeMenu());
                Assert.assertEquals(objHome.getTextMyTimeMenu(), "My Time");
                logger.log(LogStatus.PASS, "Employee Login is successful and User landed on Home Page" + logger.addScreenCapture(screenShotPath));
            }
        } catch(Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception while logging in as Employee"+ logger.addScreenCapture(screenShotPath));
        }
    }


    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        BrowserFactory.closeBrowser(driver);

    }

}