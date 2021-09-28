//package pages;
//
////import com.relevantcodes.extentreports.ExtentTest;
////import com.relevantcodes.extentreports.LogStatus;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.relevantcodes.extentreports.LogStatus;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class Login3 {
//
//    WebDriver driver;
//    ExtentTest logger;
//
//    public Login3(WebDriver driver, ExtentTest logger) {
//        this.driver = driver;
//        this.logger = logger;
//        PageFactory.initElements(driver, this);
//    }
//
//
//    @FindBy(id = "username")
//    WebElement username;
//
//    @FindBy(id = "password")
//    WebElement password;
//
//    @FindBy(id = "pass-status")
//    WebElement passwordStatus;
//
//    @FindBy(id = "remember")
//    WebElement rememberMe;
//
//    @FindBy(xpath = "//button[@type='submit' and @class='btn btn-primary btn-lg']")
//    WebElement loginBtn;
//
//
//
//
//    /*
//    Enter the value in user name field in login page
//     */
//    public void enterUsername(String user_name) {
//        try {
//            if (username.isDisplayed()) {
//                if (username.isEnabled()) {
//                    username.clear();
//                    username.sendKeys(user_name);
//                    logger.log(LogStatus.INFO, "User Name field is entered with value: " + user_name);
//                } else {
//                    logger.log(LogStatus.INFO, "User Name field is not enabled");
//                }
//            } else {
//                logger.log(LogStatus.INFO, "User Name field is not displayed");
//            }
//        } catch (Exception e) {
//            logger.log(LogStatus.ERROR, e.getMessage());
//            logger.log(LogStatus.ERROR, "Exception while entering the user name in login page");
//        }
//    }
//
//    /*
//    Enter the value in password field in login page
//     */
//    public void enterPassword(String pwd) {
//        try {
//            if (password.isDisplayed()) {
//                if (password.isEnabled()) {
//                    password.clear();
//                    password.sendKeys(pwd);
//                    logger.log(LogStatus.INFO, "password field is entered with the value");
//                } else {
//                    logger.log(LogStatus.INFO, "password field is not enabled");
//                }
//            } else {
//                logger.log(LogStatus.INFO, "password field is not displayed");
//            }
//        } catch (Exception e) {
//            logger.log(LogStatus.ERROR, e.getMessage());
//            logger.log(LogStatus.ERROR, "Exception while entering password in login page");
//        }
//    }
//
//    /*
//    Click on the password status field - eye icon on login page
//     */
//    public void changePasswordStatus() {
//        try {
//            if (passwordStatus.isDisplayed()) {
//                if (passwordStatus.isEnabled()) {
//                    passwordStatus.click();
//                } else {
//                    logger.log(LogStatus.INFO, "password status field is not enabled");
//                }
//            } else {
//                logger.log(LogStatus.INFO, "password status field is not displayed");
//            }
//        } catch (Exception e) {
//            logger.log(LogStatus.ERROR, e.getMessage());
//            logger.log(LogStatus.ERROR, "Exception while changing the password status(eye icon) in login page");
//        }
//    }
//
//    /*
//    Enable Remember Me check box
//     */
//    public void enableRememberMe() {
//        try {
//            if (rememberMe.isDisplayed()) {
//                if (rememberMe.isEnabled()) {
//                    if (!rememberMe.isSelected()) {
//                        rememberMe.click();
//                    } else {
//                        logger.log(LogStatus.INFO, "Remember Me checkbox is enabled already");
//                    }
//                } else {
//                    logger.log(LogStatus.INFO, "Remember Me checkbox field is not enabled");
//                }
//            } else {
//                logger.log(LogStatus.INFO, "Remember Me checkbox field is not displayed");
//            }
//        } catch (Exception e) {
//            logger.log(LogStatus.ERROR, e.getMessage());
//            logger.log(LogStatus.ERROR, "Exception while enabling the 'Remember Me' check box in login page");
//        }
//    }
//
//    /*
//     Click on Login button
//     */
//
//    public boolean clickLoginBtn() throws InterruptedException {
//        Boolean flag=false;
//        try {
//            if (loginBtn.isDisplayed()) {
//                if (loginBtn.isEnabled()) {
//                    flag=true;
//                    loginBtn.click();
//                    logger.log(LogStatus.INFO, "Login button is clicked on");
//                } else {
//                    logger.log(LogStatus.INFO, "Login button is not enabled");
//                }
//            } else {
//                logger.log(LogStatus.INFO, "Login button is not displayed");
//            }
//        } catch (Exception e) {
//            logger.log(LogStatus.ERROR, e.getMessage());
//            logger.log(LogStatus.ERROR, "Exception while clicking on Login button");
//        }
//        Thread.sleep(1000);
//        return flag;
//    }
//
//
//
//    }