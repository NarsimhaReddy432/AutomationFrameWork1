//package utility;
//
//import java.util.concurrent.TimeUnit;
//
//import com.relevantcodes.extentreports.LogStatus;
//import factory.BrowserFactory;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.opera.OperaDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.safari.SafariDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
//
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//
//import factory.DataProviderFactory;
//
//public class BaseClass {
//    protected static WebDriver driver;
//    public static String Url;
//    public static String userName;
//    public static String passWord;
//    public static String browserName;
//
//    protected ExtentReports report;
//    protected static ExtentTest logger;
//
////    public BaseClass(WebDriver driver,ExtentReports report,ExtentTest logger,String browserName) {
////        this.driver=driver;
////        this.report = report;
////        this.logger=logger;
////        this.browserName=browserName;
////    }
//
//   // @BeforeSuite
//    public void setupReport() {
//        String reportpath = System.getProperty("user.dir") + "\\Reports\\TimeKeeper" + Helper.getCurrentDateTime() + ".html";
//        report = new ExtentReports(reportpath);
//        System.out.println("================After execution report can be checked at " + reportpath);
//    }
//
//
////   @Parameters({"browser"})
////   @BeforeTest
//    public static WebDriver getBrowser(String browserName) {
//        Url = DataProviderFactory.getConfig().getApplicationUrl();
//       if (browserName.equalsIgnoreCase("chrome")) {
//            System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
//            driver = new ChromeDriver();
//            logger.log(LogStatus.INFO, "Browser is launched");
//        } else if (browserName.equalsIgnoreCase("firefox")) {
//            System.setProperty("webdriver.gecko.driver", DataProviderFactory.getConfig().getFirefoxPath());
//            driver = new FirefoxDriver();
//            logger.log(LogStatus.INFO, "Browser is launched");
//        } else if (browserName.equalsIgnoreCase("IE")) {
//            System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIEPath());
//            driver = new InternetExplorerDriver();
//            logger.log(LogStatus.INFO, "Browser is launched");
//        } else if (browserName.equalsIgnoreCase("edge")) {
//            System.setProperty("webdriver.edge.driver", DataProviderFactory.getConfig().getEdgePath());
//            driver = new EdgeDriver();
//            logger.log(LogStatus.INFO, "Browser is launched");
//        } else if (browserName.equalsIgnoreCase("opera")) {
//            System.setProperty("webdriver.opera.driver", DataProviderFactory.getConfig().getOperaPath());
//            driver = new OperaDriver();
//            logger.log(LogStatus.INFO, "Browser is launched");
//        } else if (browserName.equalsIgnoreCase("safari")) {
//            System.setProperty("webdriver.safari.driver", DataProviderFactory.getConfig().getSafariPath());
//            driver = new SafariDriver();
//            logger.log(LogStatus.INFO, "Browser is launched");
//        } else if (browserName.equalsIgnoreCase("phanthomjs")) {
//            System.setProperty("phantomjs.binary.path", DataProviderFactory.getConfig().getPanthonJSPath());
//            WebDriver driver = new PhantomJSDriver();
//            logger.log(LogStatus.INFO, "Headless Browser is launched");
//        } else {
//            // System.setProperty("htmlunitdriver.binary.path", DataProviderFactory.getConfig().getHtmlUnitDriverPath());
//
//            // Creating a new instance of the HTML unit driver
//            driver = new HtmlUnitDriver();
//            logger.log(LogStatus.INFO, "Headless Browser is launched");
//        }
//
//        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//        driver.get(BaseClass.Url);
//        logger.log(LogStatus.INFO, "Application is launched");
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        return driver;
//
//    }
//
//   // @AfterMethod
//    public void tearDownReport() {
//        report.endTest(BaseClass.logger);
//        driver.quit();
//        report.flush();
//
//    }
//
//   // @AfterTest
//    public void tearDown() {
//        driver.quit();
//
//    }
//
//  //  @AfterSuite
//    public void generateReport() {
//        report.flush();
//    }
//
//
//    public static ExtentReports extent =new ExtentReports();//initiating here is very important
//    public static ExtentHtmlReporter htmlReporter;
//
//    @BeforeSuite
//    public void beforeSuiteSetup() {
//        String reportpath = System.getProperty("user.dir") + "\\Reports\\TimeKeeper" + Helper.getCurrentDateTime() + ".html";
//        report = new ExtentReports(reportpath);
//
//       // String filepath = System.getProperty("user.dir");
//        htmlReporter = new ExtentHtmlReporter(filepath+"/Report.html");
//        extent.attachReporter(htmlReporter);
//    }
//
//    @AfterSuite(alwaysRun = true)
//    public void afterSuite() {
//        extent.flush();
//    }
//
//}
//}
