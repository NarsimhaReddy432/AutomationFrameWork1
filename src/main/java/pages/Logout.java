package pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {

    WebDriver driver;
    ExtentTest logger;

    public Logout(WebDriver driver, ExtentTest logger) {
        System.out.println("inside logout page class constructor");
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements(driver, this);
        System.out.println("inside logout page class constructor - END");
    }


    @FindBy(xpath = "//div[@class='profile-icon pl-1']")
    WebElement profileIcon;

    @FindBy(xpath = "//div[@class='dropdown-menu dropdown-content show']/a[contains(text(),'Logout')]]")
    WebElement logoutBtn;


    /*
     Click on Profile Icon
     */

    public void clickProfileIcon() throws InterruptedException {
        try {

            Thread.sleep(500);
            if (profileIcon.isDisplayed()) {
                logger.log(LogStatus.INFO, "Profile Icon is displayed");
                if (profileIcon.isEnabled()) {
                    logger.log(LogStatus.INFO, "Profile Icon is enabled");
                    profileIcon.click();
                    logger.log(LogStatus.INFO, "Profile Icon is clicked on");
                } else {
                    logger.log(LogStatus.INFO, "Profile Icon is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Profile Icon is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception while clicking on Profile Icon");
        }
        Thread.sleep(1000);
    }
/*
     Click on Logout button
     */

    public void logout() throws InterruptedException {
        try {
            clickProfileIcon();
            if (logoutBtn.isDisplayed()) {
                if (logoutBtn.isEnabled()) {
                    logoutBtn.click();
                    logger.log(LogStatus.INFO, "Logged-out from the application successfully");
                } else {
                    logger.log(LogStatus.INFO, "Logout button is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Logout button is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception while clicking on Logout button");
        }
        Thread.sleep(1000);
    }


}