import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    String url;



    @BeforeSuite
    public static void chromeConfigs() {

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }

    @Contract(value = " -> new", pure = true)
    @DataProvider(name = "invalidCredentials")
    public static Object[] @NotNull [] getCredentials() {

        return new Object[][]{
                {"invalid@class.com", "invalidPass"},
                {"d@class.com", ""},
                {"", ""}
        };
    }

    @BeforeMethod
    public void launchBrowser() {
       // driver = new ChromeDriver();

        System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        driver = new FirefoxDriver();
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = "https://bbb.testpro.io/#!/home";
        driver.get(url);

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

    protected WebElement waitForElementToBeClickable(WebElement webElementLocator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(webElementLocator));
    }

    protected WebElement waitForVisibilityOfElement(WebElement webElementLocator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOf(webElementLocator));
    }
}



