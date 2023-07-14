package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class HelperBase {

    Logger logger = LoggerFactory.getLogger(HelperBase.class);

    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // add for WD listener also need to create folder screenshots in the folder test - if not exist

    public void takeScreenshot(String link){
        File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(link);
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void type (By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public boolean isElementEnable(By locator) {
    WebElement element = null;
        try {
            element = driver.findElement(locator);
        }
        catch(Exception e) {
            return false;
        }
        return element.isEnabled();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

}
