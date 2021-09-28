package utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyEvents {
    WebDriver driver;

    public KeyEvents(WebDriver driver) {
        this.driver = driver;
    }

    public void pressEscape(){
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
    }
}
