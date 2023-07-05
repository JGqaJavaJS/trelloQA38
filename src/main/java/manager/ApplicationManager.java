package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {


    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    EventFiringWebDriver driver;

    HelperLogin helperLogin;

    public HelperLogin getHelperLogin() {
        return helperLogin;
    }

    @BeforeSuite
    public void init(){

//        driver = new ChromeDriver();
       // driver = new EventFiringWebDriver(new ChromeDriver());

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new EventFiringWebDriver(new ChromeDriver(chromeOptions));

//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        WebDriverManager.firefoxdriver().setup();
//        driver = new EventFiringWebDriver(new FirefoxDriver(firefoxOptions));


       // driver.register(new WebDriverListener());
        helperLogin = new HelperLogin(driver);
        driver.manage().window().maximize();
        driver.navigate().to("https://trello.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element =
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
    }

    @AfterSuite
    public void tearDown(){
        //driver.quit();
    }

}
