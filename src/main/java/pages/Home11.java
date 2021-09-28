package pages;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.util.List;
import java.util.Set;

public class Home11 {

    WebDriver driver;
    ExtentTest logger;

    /*
  Constructor
   */
    public Home11(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements(driver, this);
        System.out.println("Inside the home constructor");
    }
    @FindBy(xpath = "(//a[@href='https://timekeeper.cgsdev.com/time/staff'])[2]")
    WebElement myTimeMenu;

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement okBtn;

    @FindBy(id = "step-one")
    WebElement selectWeekDropDown;

    @FindBy(id = "step-two")
    WebElement createNewBtn;

    @FindBy(xpath = "//select[@name='time[1][project_id]']")
    WebElement project;

    @FindBy(xpath = "//select[@name='time[1][task_id]' and @id='1_task']")
    WebElement task;

    @FindBy(xpath = "(//td[@class='th-width']/input[@id='1_mon'])[1]")
    WebElement monday;

    @FindBy(xpath = "(//td[@class='th-width']/input[@id='1_tue'])[1]")
    WebElement tuesday;

    @FindBy(xpath = "(//td[@class='th-width']/input[@id='1_wed'])[1]")
    WebElement wednesday;

    @FindBy(xpath = "(//td[@class='th-width']/input[@id='1_thu'])[1]")
    WebElement thursday;

    @FindBy(xpath = "(//td[@class='th-width']/input[@id='1_fri'])[1]")
    WebElement friday;

    @FindBy(xpath = "(//td[@class='th-width']/input[@id='1_sat'])[1]")
    WebElement saturday;

    @FindBy(xpath = "(//td[@class='th-width']/input[@id='1_sun'])[1]")
    WebElement sunday;

    @FindBy(xpath = "(//*[@id='comment' and @name='comments'])[1]")
    WebElement comment;

    @FindBy(xpath = "//textarea[@name='time[1][description]']")
    WebElement comments;

    @FindBy(xpath = "//input[@id='1_total']")
    WebElement totalTime;

    @FindBy(id = "total")
    WebElement totalHours;

    @FindBy(id = "100_task")
    WebElement additionalTask;

    @FindBy(xpath = "//input[@name='time[100][mon]' and @id='100_mon']")
    WebElement timeMonday;

    @FindBy(xpath = "//input[@name='time[100][tue]' and @id='100_tue']")
    WebElement timeTuesday;

    @FindBy(xpath = "//input[@name='time[100][wed]' and @id='100_wed']")
    WebElement timeWednesday;

    @FindBy(xpath = "//input[@name='time[100][thu]' and @id='100_thu']")
    WebElement timeThursday;

    @FindBy(xpath = "//input[@name='time[100][fri]' and @id='100_fri']")
    WebElement timeFriday;

    @FindBy(xpath = "//input[@name='time[100][sat]' and @id='100_sat']")
    WebElement timeSaturday;

    @FindBy(xpath = "//input[@name='time[100][sun]']")
    WebElement timeSunday;

    @FindBy(xpath = "//*[@title='Add Comment' and @id='100textarea']")
    WebElement commentForAdditionalTask;

    @FindBy(xpath = "//textarea[@id='100textarea']")
    WebElement commentsAdditionalTask;


    @FindBy(xpath = "(//td/span/span[@id='add_tasks' and @name='addtask']/i[@name='Add Task'])[1]")
    WebElement addTask;

    @FindBy(xpath = "//button[@name='save']")
    WebElement saveBtn;

    @FindBy(id = "submit_time")
    WebElement submitBtn;

    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    WebElement confirmBtn;

    @FindBy(xpath = "//a[@href='https://timekeeper.cgsdev.com/time/manager']")
    WebElement timeSheetsMenu;

    @FindBy(xpath = "//th[@aria-label='Status: activate to sort column ascending']")
    WebElement statusColumn;

    //@FindBy(xpath = "//td[@class='sorting_1']/span/div")
    @FindBy(xpath = "(//table[@id='table_time']/tbody/tr/td[4])[1]")
    WebElement timesheetStatus;

    @FindBy(xpath = "(//div[@class='image-upload'])[1]")
    WebElement fileUpload;

    @FindBy(xpath = "//input[@class='timesheetfiles' and @type='file']")
    WebElement browseBtn;

    @FindBy(xpath = "//button[@class='btn btn-outline-primary']")
    WebElement doneBtn;

    @FindBy(id="eye_1")
    WebElement projectInfoEyeIcon;

    @FindBy(xpath = "//div[@class='dropdown-menu details-dropdown show' and @id='1_id']/div")
    WebElement projectInfo;

   List<WebElement> timeEntries=driver.findElements(By.xpath("//table[@id='table_time']/tbody/tr"));

   @FindBy(xpath = "//*[@id='modal-12']/div/div/div[2]/div/div/div[1]/div[1]/div[1]")
   WebElement projectName;

   @FindBy(xpath = "//*[@id='modal-16']/div/div/div[2]/div/div/div/div[1]/div[2]")
   WebElement projectId;



    /*
    Click on My Time menu at the left side
     */
    public void clickMytimeMenu() throws InterruptedException {
        Thread.sleep(3000);
        try {
            if (myTimeMenu.isDisplayed()) {
                if (myTimeMenu.isEnabled()) {
                    myTimeMenu.click();
                    logger.log(LogStatus.INFO, "My Time menu is clicked on");
                } else {
                    logger.log(LogStatus.INFO, "My Time menu is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "My Time menu is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on My Time Menu");
        }
    }

    /*
    Get the text of "My Time" menu at the left side of Home page
     */
    public String getTextMyTimeMenu() throws InterruptedException {
        Thread.sleep(3000);
        try {

            if (myTimeMenu.isDisplayed()) {
                if (myTimeMenu.isEnabled()) {
                    return myTimeMenu.getText();
                } else {
                    logger.log(LogStatus.INFO, "My Time menu is not enabled");
                    return null;
                }
            } else {
                logger.log(LogStatus.INFO, "My Time menu is not displayed");
                return null;
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while selecting week from the dropdown");
            return null;
        }
    }

    /*
    Click on OK Button
     */
    public void clickOkBtn() {
        try {
            System.out.println("windows size" + driver.getWindowHandles().size());
            Set<String> allWindowsHandles = driver.getWindowHandles();

            for (String windowHandle : allWindowsHandles) {

                if (okBtn.getText().equalsIgnoreCase("ok")) {
                    driver.switchTo().window(windowHandle);
                }
            }
            if (okBtn.isDisplayed()) {
                if (okBtn.isEnabled()) {
                    okBtn.click();
                    Thread.sleep(500);
                    logger.log(LogStatus.INFO, "OK button is clicked on");
                } else {
                    logger.log(LogStatus.INFO, "OK button is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "OK button is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on OK button");
        }
    }

    /*
    Select Week from the dropdown
     */
    public void selectWeek() {
        try {
            Thread.sleep(4000);
            if (selectWeekDropDown.isDisplayed() & selectWeekDropDown.isEnabled()) {
                Select weeks = new Select(selectWeekDropDown);
                weeks.selectByIndex(1);
                logger.log(LogStatus.INFO, "Week is selected");
            } else {
                logger.log(LogStatus.INFO, "Week dropdown is either not enabled or not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while selecting week from the dropdown");
        }
    }


    /*
    Clicking on "Create New" button
     */
    public void clickCreateNewBtn() {
        try {
            Thread.sleep(500);
            if (createNewBtn.isDisplayed()) {
                if (createNewBtn.isEnabled()) {
                    createNewBtn.click();
                    logger.log(LogStatus.INFO, "Create New button is clicked on");
                } else {
                    logger.log(LogStatus.INFO, "Create New button is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Create New button is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on 'Create New' button");
        }
    }

    /*
    Select Project from the dropdown
     */
    public void selectProject() {
        try {
            Thread.sleep(500);
            if (project.isDisplayed() & project.isEnabled()) {
                Select weeks = new Select(project);
                weeks.selectByVisibleText("TimeKeeper Application");
                logger.log(LogStatus.INFO, "Project is selected");
            } else {
                logger.log(LogStatus.INFO, "Project dropdown is either not enabled or not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while selecting project from the dropdown");
        }
    }

    /*
    Select Task from the dropdown
     */
    public void selectTask() {
        try {
            Thread.sleep(500);
            if (task.isDisplayed() & task.isEnabled()) {
                Select weeks = new Select(task);
                weeks.selectByIndex(1);
                logger.log(LogStatus.INFO, "Task is selected");
            } else {
                logger.log(LogStatus.INFO, "Task dropdown is either not enabled or not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while selecting Task from the dropdown");
        }
    }


    /*
    Enter time for monday
     */
    public void enterTimeForMonday(String hour) {
        try {
            if (monday.isDisplayed()) {
                if (monday.isEnabled()) {
                    monday.clear();
                    monday.sendKeys(hour);
                    logger.log(LogStatus.INFO, "Time is entered for Monday");
                } else {
                    logger.log(LogStatus.INFO, "Monday input box is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Monday input box is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering value in Monday input box");
        }
    }


    /*
    Enter time for Tuesday
     */
    public void enterTimeForTuesday(String hour) {
        try {
            if (tuesday.isDisplayed()) {
                if (tuesday.isEnabled()) {
                    tuesday.clear();
                    tuesday.sendKeys(hour);
                    logger.log(LogStatus.INFO, "Time is entered for Tuesday");
                } else {
                    logger.log(LogStatus.INFO, "Tuesday input box is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Tuesday input box is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering value in Tuesday input box");
        }
    }


    /*
    Enter time for Wednesday
     */
    public void enterTimeForWednesday(String hour) {
        try {
            if (wednesday.isDisplayed()) {
                if (wednesday.isEnabled()) {
                    wednesday.clear();
                    wednesday.sendKeys(hour);
                    logger.log(LogStatus.INFO, "Time is entered for Wednesday");
                } else {
                    logger.log(LogStatus.INFO, "Wednesday input box is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Wednesday input box is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering value in Wednesday input box");
        }
    }

    /*
    Enter time for Thursday
     */
    public void enterTimeForThursday(String hour) {
        try {
            if (thursday.isDisplayed()) {
                if (thursday.isEnabled()) {
                    thursday.clear();
                    thursday.sendKeys(hour);
                    logger.log(LogStatus.INFO, "Time is entered for Thursday");
                } else {
                    logger.log(LogStatus.INFO, "Thursday input box is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Thursday input box is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering value in Thursday input box");
        }
    }


    /*
    Enter time for Friday
     */
    public void enterTimeForFriday(String hour) {
        try {
            if (friday.isDisplayed()) {
                if (friday.isEnabled()) {
                    friday.clear();
                    friday.sendKeys(hour);
                    logger.log(LogStatus.INFO, "Time is entered for Friday");
                } else {
                    logger.log(LogStatus.INFO, "Friday input box is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Friday input box is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering value in Friday input box");
        }
    }

    /*
    Enter time for Saturday
     */
    public void enterTimeForSaturday(String hour) {
        try {
            if (saturday.isDisplayed()) {
                if (saturday.isEnabled()) {
                    saturday.clear();
                    saturday.sendKeys(hour);
                    logger.log(LogStatus.INFO, "Time is entered for Saturday");
                } else {
                    logger.log(LogStatus.INFO, "Saturday input box is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Saturday input box is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering value in Saturday input box");
        }
    }

    /*
    Enter time for Sunday
     */
    public void enterTimeForSunday(String hour) {
        try {
            if (sunday.isDisplayed()) {
                if (sunday.isEnabled()) {
                    sunday.clear();
                    sunday.sendKeys(hour);
                    logger.log(LogStatus.INFO, "Time is entered for Sunday");
                } else {
                    logger.log(LogStatus.INFO, "Sunday input box is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Sunday input box is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering value in Sunday input box");
        }
    }

    /*
    Enter time for week days (Monday to Friday)
     */
    public void enterTimeForWeekDays(String hour) {
        try {
            enterTimeForMonday(hour);
            enterTimeForTuesday(hour);
            enterTimeForWednesday(hour);
            enterTimeForThursday(hour);
            enterTimeForFriday(hour);
            logger.log(LogStatus.INFO, "Time entered for all the week days (Monday to Friday)");
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering time for week days");
        }
    }

    /*
 Enter time for week end (Saturday and Sunday) for additional task
  */
    public void enterTimeForWeekEnd(String hour) {
        try {
            enterTimeForSaturday(hour);
            enterTimeForSunday(hour);
            logger.log(LogStatus.INFO, "Time entered for all the week end (Saturday and Sunday)");
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering time for week end (Saturday and Sunday)");
        }
    }

    /*
    Select Task from the dropdown for additional task
     */
    public void selectAdditionalTask() {
        try {
            Thread.sleep(500);
            if (additionalTask.isDisplayed() & additionalTask.isEnabled()) {
                Select weeks = new Select(additionalTask);
                weeks.selectByIndex(2);
                logger.log(LogStatus.INFO, "Additional Task is selected");
            } else {
                logger.log(LogStatus.INFO, "Additional Task  dropdown is either not enabled or not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while selecting Addtional Task from the dropdown");
        }
    }

    /*
    Enter time for monday - add task
     */
    public void enterAdditionalTimeForMonday(String hour) {
        try {
            if (timeMonday.isDisplayed()) {
                if (timeMonday.isEnabled()) {
                    timeMonday.clear();
                    timeMonday.sendKeys(hour);
                    logger.log(LogStatus.INFO, "Time is entered for Monday in additional task");
                } else {
                    logger.log(LogStatus.INFO, "Monday input box is not enabled in additional task");
                }
            } else {
                logger.log(LogStatus.INFO, "Monday input box is not displayed in additional task");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering value in Monday input box in additional task");
        }
    }

    /*
    Enter time for Tuesday - add task
     */
    public void enterAdditionalTimeForTuesday(String hour) {
        try {
            if (timeTuesday.isDisplayed()) {
                if (timeTuesday.isEnabled()) {
                    timeTuesday.clear();
                    timeTuesday.sendKeys(hour);
                    logger.log(LogStatus.INFO, "Time is entered for Tuesday in additional task");
                } else {
                    logger.log(LogStatus.INFO, "Tuesday input box is not enabled in additional task");
                }
            } else {
                logger.log(LogStatus.INFO, "Tuesday input box is not displayed in additional task");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering value in Tuesday input box in additional task");
        }
    }

    /*
    Enter time for Wednesday - add task
     */
    public void enterAdditionalTimeForWednesday(String hour) {
        try {
            if (timeWednesday.isDisplayed()) {
                if (timeWednesday.isEnabled()) {
                    timeWednesday.clear();
                    timeWednesday.sendKeys(hour);
                    logger.log(LogStatus.INFO, "Time is entered for Wednesday in additional task");
                } else {
                    logger.log(LogStatus.INFO, "Wednesday input box is not enabled in additional task");
                }
            } else {
                logger.log(LogStatus.INFO, "Wednesday input box is not displayed in additional task");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering value in Wednesday input box in additional task");
        }
    }

    /*
    Enter time for Thursday - add task
     */
    public void enterAdditionalTimeForThursday(String hour) {
        try {
            if (timeThursday.isDisplayed()) {
                if (timeThursday.isEnabled()) {
                    timeThursday.clear();
                    timeThursday.sendKeys(hour);
                    logger.log(LogStatus.INFO, "Time is entered for Thursday in additional task");
                } else {
                    logger.log(LogStatus.INFO, "Thursday input box is not enabled in additional task");
                }
            } else {
                logger.log(LogStatus.INFO, "Thursday input box is not displayed in additional task");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering value in Thursday input box in additional task");
        }
    }

    /*
    Enter time for Friday - add task
     */
    public void enterAdditionalTimeForFriday(String hour) {
        try {
            if (timeFriday.isDisplayed()) {
                if (timeFriday.isEnabled()) {
                    timeFriday.clear();
                    timeFriday.sendKeys(hour);
                    logger.log(LogStatus.INFO, "Time is entered for Friday in additional task");
                } else {
                    logger.log(LogStatus.INFO, "Friday input box is not enabled in additional task");
                }
            } else {
                logger.log(LogStatus.INFO, "Friday input box is not displayed in additional task");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering value in Friday input box in additional task");
        }
    }

    /*
    Enter time for Saturday- add task
     */
    public void enterAdditionalTimeForSaturday(String hour) {
        try {
            if (timeSaturday.isDisplayed()) {
                if (timeSaturday.isEnabled()) {
                    timeSaturday.clear();
                    timeSaturday.sendKeys(hour);
                    logger.log(LogStatus.INFO, "Time is entered for Saturday in additional task");
                } else {
                    logger.log(LogStatus.INFO, "Saturday input box is not enabled in additional task");
                }
            } else {
                logger.log(LogStatus.INFO, "Saturday input box is not displayed in additional task");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering value in Saturday input box in additional task");
        }
    }

    /*
    Enter time for Sunday- add task
     */
    public void enterAdditionalTimeForSunday(String hour) {
        try {
            if (timeSunday.isDisplayed()) {
                if (timeSunday.isEnabled()) {
                    timeSunday.clear();
                    timeSunday.sendKeys(hour);
                    logger.log(LogStatus.INFO, "Time is entered for Sunday in additional task");
                } else {
                    logger.log(LogStatus.INFO, "Sunday input box is not enabled in additional task");
                }
            } else {
                logger.log(LogStatus.INFO, "Sunday input box is not displayed in additional task");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering value in Sunday input box in additional task");
        }
    }

    /*
    Enter time for week days (Monday to Friday) for additional task
     */
    public void enterTimeForWeekDaysForAdditionalTask(String hour) {
        try {
            enterAdditionalTimeForMonday(hour);
            enterAdditionalTimeForTuesday(hour);
            enterAdditionalTimeForWednesday(hour);
            enterAdditionalTimeForThursday(hour);
            enterAdditionalTimeForFriday(hour);
            logger.log(LogStatus.INFO, "Time entered for all the week days (Monday to Friday) in additional task");
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering time for week days in additional task");
        }
    }

    /*
   Enter time for week end (Saturday and Sunday) for additional task
    */
    public void enterTimeForWeekEndForAdditionalTask(String hour) {
        try {
            enterAdditionalTimeForSaturday(hour);
            enterAdditionalTimeForSunday(hour);
            logger.log(LogStatus.INFO, "Time entered for all the week end (Saturday and Sunday) in additional task");
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering time for week end (Saturday and Sunday) in additional task");
        }
    }

    /*
    Click on File upload icon
     */
    public void clickFileUpload() throws InterruptedException {
        Thread.sleep(3000);
        try {
            if (fileUpload.isDisplayed()) {
                if (fileUpload.isEnabled()) {
                    fileUpload.click();
                    Thread.sleep(500);
                    logger.log(LogStatus.INFO, "File Upload button is clicked on");
                } else {
                    logger.log(LogStatus.INFO, "File Upload button is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "File Upload button is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on File Upload button");
        }
        Thread.sleep(2000);
    }

    /*
    Click on Browse button to choose the file
     */
    public void clickBrowseBtn() throws InterruptedException {
        Thread.sleep(5000);
        try {
            if (browseBtn.isDisplayed()) {
                if (browseBtn.isEnabled()) {
                    browseBtn.click();
                } else {
                    logger.log(LogStatus.INFO, "Browse button is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Browse button is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Browse button");
        }
    }

    /*
   Click on Done button to choose the file
    */
    public void clickDoneBtn() throws InterruptedException {
        Thread.sleep(3000);
        try {
            if (doneBtn.isDisplayed()) {
                if (doneBtn.isEnabled()) {
                    doneBtn.click();
                } else {
                    logger.log(LogStatus.INFO, "Done button is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Done button is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Done button");
        }
    }

    /*
    Click on comment field
     */
    public void clickComment() {
        try {
            if (comment.isDisplayed()) {
                if (comment.isEnabled()) {
                    comment.click();
                    logger.log(LogStatus.INFO, "Comment is clicked on");
                } else {
                    logger.log(LogStatus.INFO, "comment field is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "comment field is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on comment field");
        }
    }


    /*
    Enter Comments description
     */
    public void enterComments() {
        try {
            clickComment();
            if (comments.isDisplayed()) {
                if (comments.isEnabled()) {
                    comments.clear();
                    comments.sendKeys("test comment");
                    logger.log(LogStatus.INFO, "Comments is entered");
                } else {
                    logger.log(LogStatus.INFO, "Comments description field is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Comments description field is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering value in Comments description field");
        }
    }

    /*
    Click on add task
     */
    public void addTask() throws InterruptedException {
        Thread.sleep(3000);
        try {
            if (addTask.isDisplayed()) {
                if (addTask.isEnabled()) {
                    addTask.click();
                    Thread.sleep(500);
                    logger.log(LogStatus.INFO, "Add Task is clicked on");
                } else {
                    logger.log(LogStatus.INFO, "Add Task is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Add Task is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Add Task button");
        }
    }

    /*
    Click on comment field
     */
    public void clickCommentForAdditionalTask() {
        try {
            if (commentForAdditionalTask.isDisplayed()) {
                if (commentForAdditionalTask.isEnabled()) {
                    commentForAdditionalTask.click();
                    logger.log(LogStatus.INFO, "Comment is clicked on for additional task");
                } else {
                    logger.log(LogStatus.INFO, "comment field is not enabled for additional task");
                }
            } else {
                logger.log(LogStatus.INFO, "comment field is not displayedfor additional task");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on comment field for additional task");
        }
    }


    /*
    Enter Comments description for additional task
     */
    public void enterCommentsForAdditionalTask() {
        try {
            clickCommentForAdditionalTask();
            if (commentsAdditionalTask.isDisplayed()) {
                if (commentsAdditionalTask.isEnabled()) {
                    commentsAdditionalTask.clear();
                    commentsAdditionalTask.sendKeys("Automation test comment");
                    logger.log(LogStatus.INFO, "Comments is entered in additional task");
                } else {
                    logger.log(LogStatus.INFO, "Comments description field is not enabled in additional task");
                }
            } else {
                logger.log(LogStatus.INFO, "Comments description field is not displayed in additional task");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering value in Comments description field in additional task");
        }
    }

    /*
    Click on Save Button
     */
    public void clickSaveBtn() {
        try {
            if (saveBtn.isDisplayed()) {
                if (saveBtn.isEnabled()) {
                    saveBtn.click();
                    Thread.sleep(500);
                    logger.log(LogStatus.INFO, "Save button is clicked on");
                } else {
                    logger.log(LogStatus.INFO, "Save button is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Save button is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on save button");
        }
    }

    /*
    Click on Submit Button
     */
    public void clickSubmitBtn() throws InterruptedException {
        Thread.sleep(3000);
        try {
            if (submitBtn.isDisplayed()) {
                if (submitBtn.isEnabled()) {
                    submitBtn.click();
                    Thread.sleep(500);
                    logger.log(LogStatus.INFO, "Submit button is clicked on");
                } else {
                    logger.log(LogStatus.INFO, "Submit button is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Submit button is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Submit button");
        }
    }

    /*
    Click on Confirm Button
     */
    public void confirm() throws InterruptedException {
        Thread.sleep(3000);
        try {
            if (confirmBtn.isDisplayed()) {
                if (confirmBtn.isEnabled()) {
                    confirmBtn.click();
                    Thread.sleep(500);
                    logger.log(LogStatus.INFO, "Confirm button is clicked on");
                } else {
                    logger.log(LogStatus.INFO, "Confirm button is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Confirm button is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Confirm button");
        }
    }

    /*
    Click on Timesheets Menu at the left navigation
     */
    public void clickTimesheetsMenu() throws InterruptedException {
        Thread.sleep(3000);
        try {
            if (timeSheetsMenu.isDisplayed()) {
                if (timeSheetsMenu.isEnabled()) {
                    timeSheetsMenu.click();
                    Thread.sleep(500);
                    logger.log(LogStatus.INFO, "Timesheets menu is clicked on");
                } else {
                    logger.log(LogStatus.INFO, "Timesheets menu is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Timesheets menu is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Timesheets menu");
        }
    }

    /*
       sortout status column in the timesheet table
     */
    public void sortStatusByDescending() throws InterruptedException {
        Thread.sleep(3000);
        try {
            if (statusColumn.isDisplayed()) {
                if (statusColumn.isEnabled()) {
                    statusColumn.click();
                    Thread.sleep(500);
                    logger.log(LogStatus.INFO, "Status column is sorted out with decending order");
                } else {
                    logger.log(LogStatus.INFO, "Status column is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Status column is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Status column");
        }
    }


    /*
    Get the status of timesheet of an employee
     */
    public String getTimesheetStatusOfEmployee() throws InterruptedException {
        Thread.sleep(3000);
        try {
            if (timesheetStatus.isDisplayed()) {
                logger.log(LogStatus.INFO, "Timesheet status is displayed as: " + timesheetStatus.getText());
                return timesheetStatus.getText();
            } else {
                logger.log(LogStatus.INFO, "Timesheet status is not displayed");
                return null;
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while retrieving timesheet status");
            return null;
        }
    }

    /*
  Click on Project Info eye icon on new timesheet screen
   */
    public String getProjectInfo() throws InterruptedException {
        Thread.sleep(3000);
        String projectInfoText="";
        try {
            if (projectInfoEyeIcon.isDisplayed()) {
                if (projectInfoEyeIcon.isEnabled()) {
                    projectInfoEyeIcon.click();
                    Thread.sleep(3000);
                    if(projectInfo.isEnabled() & projectInfo.isDisplayed()) {
                        Thread.sleep(500);
                        projectInfoText = projectInfo.getText();
                    }

                    logger.log(LogStatus.INFO, "Project Info eye icon is clicked on");
                } else {
                    logger.log(LogStatus.INFO, "Project Info eye icon is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Project Info eye icon is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            e.getStackTrace();
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Project Info eye icon");
        }
        return projectInfoText;
    }

    /*
    Click on project name for the submitted timesheet
     */
    public String getProjectNameforSubmittedTimeSheet() throws InterruptedException {
        Thread.sleep(3000);
        String projectInfoText="",timesheetStatus="",projectNameText="";
        int size=0;
        try {
            size = timeEntries.size();
            if(size>0) {
                for (WebElement timeEntry : timeEntries) {
                    if(timeEntry.isDisplayed()){
                        //table[@id='table_time']/tbody/tr[1]/td[4]
                        for(int i=1; i<=size; i++){
                            timesheetStatus=driver.findElement(By.xpath("//table[@id='table_time']/tbody/tr["+ i+"]/td[4]")).getText();
                            if(timesheetStatus.contains("Submitted")){
                                driver.findElement(By.xpath("//table[@id='table_time']/tbody/tr["+i+"]/td[6]")).click();
                                Thread.sleep(1000);
                                if(projectName.isDisplayed()){
                                    projectNameText=projectName.getText();
                                    break;
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            e.getStackTrace();
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Project Info eye icon");
        }
        return projectNameText;
    }

    /*
   Click on project name for the Saved timesheet
    */
    public String getProjectNameforSavedTimeSheet() throws InterruptedException {
        Thread.sleep(3000);
        String projectInfoText="",timesheetStatus="",projectNameText="";
        int size=0;
        try {
            size = timeEntries.size();
            if(size>0) {
                for (WebElement timeEntry : timeEntries) {
                    if(timeEntry.isDisplayed()){
                        //table[@id='table_time']/tbody/tr[1]/td[4]
                        for(int i=1; i<=size; i++){
                            timesheetStatus=driver.findElement(By.xpath("//table[@id='table_time']/tbody/tr["+ i+"]/td[4]")).getText();
                            if(timesheetStatus.contains("Saved")){
                                driver.findElement(By.xpath("//table[@id='table_time']/tbody/tr["+i+"]/td[6]")).click();
                                Thread.sleep(1000);
                                if(projectName.isDisplayed()){
                                    projectNameText=projectName.getText();
                                    break;
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            e.getStackTrace();
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Project Info eye icon");
        }
        return projectNameText;
    }

}