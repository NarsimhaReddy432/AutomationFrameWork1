package testcase_Excel;

import com.relevantcodes.extentreports.LogStatus;
import dataprovider.ConfigDataProvider;
import dataprovider.ExcelDataProvider;
import factory.BrowserFactory;
//import factory.DataProviderFactory;
import factory.DataProviderFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
public class EmployeeLoginTest extends ExtentReportClass {

    WebDriver driver;

    Login objLogin;
    Home11 objHome;
    String browser;
    String Url;
    KeyEvents objKeyEvents;
    CaptureScreenshot objCaptureScreenshot;
    BrowserFactory objBrowserFactory;
    ConfigDataProvider objConfigDataProvider;
    ExcelDataProvider objExcelDataProvider;

    @BeforeMethod
    public void setup() throws InterruptedException {
        String fileName = new Exception().getStackTrace()[0].getFileName();
        logger = report.startTest(fileName);
        objBrowserFactory = new BrowserFactory(driver, logger);
        objConfigDataProvider = new ConfigDataProvider();
        driver = objBrowserFactory.getBrowser();
    }

    @Test(enabled = true, priority = 1, groups = {"smoke", "regression"}, description = "Verify that employee is able to login into application successfully")
    public void testEmployeeLogin() throws InterruptedException {
        System.out.println("Inside employee login");
        String screenShotPath = "";
        try {
            objLogin = new Login(driver, logger);
            objHome = new Home11(driver, logger);
            objCaptureScreenshot = new CaptureScreenshot(driver, logger);

            String screenshotName = new Exception()
                    .getStackTrace()[0]
                    .getMethodName();
            System.out.println("application title:" + driver.getTitle());
            if (driver.getTitle().contains("Time Keeper")) {
                System.out.println("Inside if loop");
                logger.log(LogStatus.INFO, "Application title: " + driver.getTitle());
                String userName=DataProviderFactory.getExcel().getData(0,1,1);
                String passWord=DataProviderFactory.getExcel().getData(0,2,1);
                System.out.println("user name:" + userName);
                System.out.println("Password: " + passWord);
                objLogin.enterUsername(userName);
                objLogin.enterPassword(passWord);
                objLogin.changePasswordStatus();
                objLogin.enableRememberMe();
                objLogin.clickLoginBtn();
                screenShotPath = objCaptureScreenshot.captureScreenshot(screenshotName);
                logger.log(LogStatus.INFO, "Screenshot is captured");
                Assert.assertEquals(objHome.getTextMyTimeMenu(), "My Time");
                logger.log(LogStatus.PASS, "Employee Login is successful and User landed on Home Page" + logger.addScreenCapture(screenShotPath));
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception while logging in as Employee"+ logger.addScreenCapture(screenShotPath));
        }
    }


    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        BrowserFactory.closeBrowser(driver);

    }

}