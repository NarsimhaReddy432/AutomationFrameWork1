//package testcase;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
////import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.LogStatus;
//import dataprovider.ConfigDataProvider;
//import factory.BrowserFactory2;
//import factory.BrowserFactory3;
//import factory.DataProviderFactory;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//import pages.Home2;
//import pages.Login2;
//import pages.Login3;
//import utility.*;
//
//import java.io.IOException;
//
//@Listeners(TestNGListener.class)
//public class EmployeeLoginTest3 extends BaseTestExtentReport {
//
//    public WebDriver driver;
//    public ExtentReports report;
//    public ExtentTest logger;
//    public ExtentHtmlReporter htmlReporter;
//
//    Login2 objLogin;
//    Home2 objHome;
//    String browser;
//    String Url;
//    KeyEvents objKeyEvents;
//    CaptureScreenshot objCaptureScreenshot;
//    BrowserFactory3 objBrowserFactory;
//    ConfigDataProvider objConfigDataProvider;
//
//    public EmployeeLoginTest3(ExtentReports report, ExtentTest logger,ExtentHtmlReporter htmlReporter) {
//        this.report = report;
//        this.logger = logger;
//        this.htmlReporter=htmlReporter;
//    }
//
//
//    @BeforeMethod
//    public void setup() {
////        String reportpath = System.getProperty("user.dir") + "\\Reports\\TimeKeeper" + Helper.getCurrentDateTime() + ".html";
////        report = new ExtentReports(reportpath);
////        System.out.println("=====After execution report can be checked at " + reportpath + "========");
//        String fileName = new Exception().getStackTrace()[0].getFileName();
////        report = new ExtentReports(".\\Reports\\" + fileName + ".html", true);
//       // logger = report.startTest(fileName);
//        logger=report.createTest(fileName);
//        objBrowserFactory = new BrowserFactory3(driver, logger);
//        objConfigDataProvider = new ConfigDataProvider();
//        driver = objBrowserFactory.getBrowser();
//        //logger.log(LogStatus.INFO, "Application is up and running");
//    }
//
//    @Test(enabled = true, priority = 1, groups = {"smoke", "regression"}, description = "Verify that employee is able to login into application successfully")
//    public void testEmployeeLogin() throws InterruptedException {
//        try {
//            objLogin = new Login3(driver, logger);
//            objHome = new Home3(driver, logger);
//            objCaptureScreenshot = new CaptureScreenshot(driver, logger);
//            String screenShotPath = "";
//            String screenshotName = new Exception()
//                    .getStackTrace()[0]
//                    .getMethodName();
//
//            if (driver.getTitle().contains("Time Keeper")) {
//               // logger.log(LogStatus.INFO, "Application title: " + driver.getTitle());
//                objLogin.enterUsername(DataProviderFactory.getConfig().getEmployeeUserName());
//                objLogin.enterPassword(DataProviderFactory.getConfig().getEmployeePassword());
//                objLogin.changePasswordStatus();
//                objLogin.enableRememberMe();
//                objLogin.clickLoginBtn();
//                screenShotPath = objCaptureScreenshot.captureScreenshot(screenshotName);
//              //  logger.log(LogStatus.INFO, "Screenshot is captured");
//                Assert.assertEquals(objHome.getTextMyTimeMenu(), "My Time");
////                logger.log(LogStatus.PASS, "Employee Login is successful and User landed on Home Page" + logger.addScreenCapture(screenShotPath));
////                logger.log(LogStatus.PASS, "Employee Login is successful and User landed on Home Page");
//            }
//        } catch (Exception e) {
//           // logger.log(LogStatus.ERROR, e.getMessage());
//          //  logger.log(LogStatus.ERROR, "Exception while logging in as Employee");
//        }
//    }
//
//
//    @AfterMethod
//    public void tearDown(ITestResult result) throws IOException {
//        BrowserFactory2.closeBrowser(driver);
//    }
//
//}