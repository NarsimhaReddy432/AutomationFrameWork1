package testcase;

import com.relevantcodes.extentreports.LogStatus;
import dataprovider.ConfigDataProvider;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Home;
import pages.Login;
import pages.Logout;
import utility.*;

import java.io.IOException;

@Listeners(TestNGListener.class)
public class LogoutTest extends ExtentReportClass {

    WebDriver driver;
    Login objLogin;
    Home objHome;
    String browser;
    String Url;
    KeyEvents objKeyEvents;
    CaptureScreenshot objCaptureScreenshot;
    BrowserFactory objBrowserFactory;
    ConfigDataProvider objConfigDataProvider;
    Logout objLogout;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        String fileName = new Exception().getStackTrace()[0].getFileName();
        logger = report.startTest(fileName);
        objBrowserFactory = new BrowserFactory(driver, logger);
        objConfigDataProvider = new ConfigDataProvider();
        driver = objBrowserFactory.getBrowser();
    }

    @Test(enabled = true, priority = 1, groups = {"smoke", "regression"}, description = "Verify that logged in employee is able to logout from the application successfully")
    public void testEmployeeLogout() throws InterruptedException {
        String screenShotPath = "";
        try {

            objLogin = new Login(driver, logger);


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
                objLogout = new Logout(driver, logger);


                if (objLogin.getTextMyTimeMenu().equalsIgnoreCase("My Time")) {
                    objLogin.clickMytimeMenu();
                    objLogout.logout();
                    Assert.assertTrue(objLogin.clickLoginBtn());
                }
                screenShotPath = objCaptureScreenshot.captureScreenshot(screenshotName);
                logger.log(LogStatus.PASS, "Employee Logout is successful" + logger.addScreenCapture(screenShotPath));
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception while logging out as Employee" + logger.addScreenCapture(screenShotPath));
        }
    }


    @AfterMethod
    public void tearDown() throws IOException {
        BrowserFactory.closeBrowser(driver);
    }

}