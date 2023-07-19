package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

  // changed for WD listener
    EventFiringWebDriver driver;

    HelperLogin helperLogin;

    HelperLogout helperLogout;

    HelperMainPage helperMainPage;

    WebDriverWait wait;

    String browser;
    Properties properties;

    public ApplicationManager(String browser) {
        properties = new Properties();
        this.browser = browser;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public HelperLogin getHelperLogin() {
        return helperLogin;
    }

    public HelperLogout getHelperLogout() {return helperLogout;}

    public HelperMainPage getHelperMainPage() { return helperMainPage;}

  //  @BeforeSuite
    public void init(){

     //   properties.load(new FileReader(new File("src/test/resources/prod.properties")));

        try (FileReader fr = new FileReader(new File("src/test/resources/prod.properties"))){
            properties.load(fr);
        } catch (IOException e) {

        }

//        driver = new ChromeDriver();
       // driver = new EventFiringWebDriver(new ChromeDriver());

        if(browser.equals(BrowserType.CHROME)) {
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            // changed for WD Listener
            driver = new EventFiringWebDriver(new ChromeDriver(chromeOptions));
        } else if (browser.equals(BrowserType.FIREFOX)) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            driver = new EventFiringWebDriver(new FirefoxDriver(firefoxOptions));
        }


        driver.register(new WebDriverListener());
        helperLogin = new HelperLogin(driver);
        helperLogout = new HelperLogout(driver);
        helperMainPage = new HelperMainPage(driver);
        driver.manage().window().maximize();
        driver.navigate().to(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 90);

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element =
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));



    }

    public void navigateToMainPage() {
        driver.navigate().to("https://trello.com/");
    }

    //@AfterSuite
    public void tearDown(){
        driver.quit();
    }

}
