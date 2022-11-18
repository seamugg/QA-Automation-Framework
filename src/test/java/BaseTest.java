import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    static WebDriver driver;
    static WebDriverWait wait;
    static String url;
    static Actions actions;
    static ThreadLocal<WebDriver> threadDriver;



    @BeforeSuite
    public static RemoteWebDriver chromeConfigs() throws MalformedURLException {

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }


        return null;
    }

    @BeforeMethod

    @Parameters({"baseURL"})

    public void launchBrowser(@Optional String baseURL) throws MalformedURLException {
        if (baseURL == null)
            baseURL ="https://bbb.testpro.io";
        //driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        //driver = new FirefoxDriver();
        //driver = new SafariDriver();
        driver = pickBrowser("cloud");
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        url = baseURL;
        driver.get(url);

    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.2:4444";
        switch (browser){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver");
                return driver = new FirefoxDriver();
            case "safari":
                return driver = new SafariDriver();
            case "grid-safari":
                caps.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "cloud":
                 return lamdaTest();
            default:
                return driver = new ChromeDriver();
        }
    }

    private static WebDriver lamdaTest() throws MalformedURLException {
        String userName = "seamugg";
        String authKey="btsFW4HzFPIw7kwwr2jbB8gM4qJ6zUcxizdhu7ZrcUCcxzyseY";
        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "107.0");
        caps.setCapability("platform", "Windows");
        caps.setCapability("resolution","1280x1024");
        caps.setCapability("build", "TestNG with Java");
        caps.setCapability("plugin", "git-testing");
        return new RemoteWebDriver(new URL("https://" + userName + ":" + authKey + hub), caps);
    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }

    public void clickSubmitBtn() {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);

    }

    @DataProvider(name="invalidCredentials")
    public static Object[][] getCredentials(){

        return new Object[][] {
                {"invalid@class.com", "invalidPass"},
                {"d@class.com", ""},
                {"", ""}
        };
    }

    public void login(){
        provideEmail("seamugg@yahoo.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
}
