import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;



//    @Test(enabled = false, priority = 0)
//    public void LoginEmptyEmailPasswordTest () {
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//    }


    public class LoginTests extends BaseTest {

        @Test(enabled = false, priority = 0)
        public void LoginEmptyEmailPasswordTest() {
            Assert.assertEquals(driver.getCurrentUrl(), url);
        }

        @Test(priority = 1, dataProvider = "invalidCredentials", dataProviderClass = BaseTest.class)
        public void LoginValidEmailValidPasswordTest(String email, String password) {

            provideEmail(email); // "demo@class.com"
            providePassword(password); // te$t$tudent
            clickSubmitBtn();

            WebElement avatarIcon = driver.findElement(By.xpath("//img[contains(@alt,'Avatar of')]"));
            Assert.assertTrue(avatarIcon.isDisplayed());

        }

        @Test(enabled = false, priority = 2)
        public void LoginInvalidEmailPasswordTest() throws InterruptedException {
            provideEmail("dem@class.com");
            providePassword("");
            clickSubmitBtn();

            // Vd
            Thread.sleep(2000);
            Assert.assertEquals(driver.getCurrentUrl(), url);

        }

        @Test(enabled = false)
        public void LoginValidEmailEmptyPasswordTest() {
            WebDriver driver;
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/";
            driver.get(url);

            WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
            emailField.click();
            emailField.sendKeys("demo@class.com");

            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
            passwordField.click();

            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
            submitButton.click();

            WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
            Assert.assertTrue(avatarIcon.isDisplayed());

            driver.quit();
        }

        @Test(enabled = false)
        public void SwitchToSongsMenu() throws InterruptedException {
            WebDriver driver;
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/";
            driver.get(url);
            By emailSelector = By.cssSelector("[type='email']");
            WebElement emailField = driver.findElement(emailSelector);
            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
            By avatarSelector = By.cssSelector("[alt='Avatar of student']");
            By songMenuSelector = By.className("songs");
            By allButtonSelector = By.className("btn-shuffle-all");

            emailField.click();
            emailField.sendKeys("demo@class.com");
            passwordField.click();
            passwordField.sendKeys("te$t$tudent");
            submitButton.click();
            Assert.assertTrue(driver.findElement(avatarSelector).isDisplayed());
            // WebElement songsMenu = driver.findElement(By.className("songs"));
            // WebElement songsMenu = driver.findElement(songMenuSelector);
            driver.findElement(songMenuSelector).click();
            Assert.assertTrue(driver.findElement(allButtonSelector).isDisplayed());
            Thread.sleep(2000);

            driver.quit();
        }

        @Test(enabled = false)
        public void SearchSong() throws InterruptedException {
            WebDriver driver;
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/";
            driver.get(url);
            By emailSelector = By.cssSelector("[type='email']");
            WebElement emailField = driver.findElement(emailSelector);
            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
            By avatarSelector = By.cssSelector("[alt='Avatar of student']");
            By searchBarSelector = By.id("searchForm");
            By allButtonSelector = By.className("btn-shuffle-all");

            emailField.click();
            emailField.sendKeys("demo@class.com");
            passwordField.click();
            passwordField.sendKeys("te$t$tudent");
            submitButton.click();
            Assert.assertTrue(driver.findElement(avatarSelector).isDisplayed());
            // WebElement songsMenu = driver.findElement(By.className("songs"));
            // WebElement songsMenu = driver.findElement(songMenuSelector);
            driver.findElement(searchBarSelector).click();
            driver.findElement(searchBarSelector).sendKeys("Veggie Straws");
            //Assert.assertTrue(driver.findElement().isDisplayed());
            Thread.sleep(5000);


            url = "https://bbb.testpro.io/";
            driver.get(url);
            Assert.assertEquals(driver.getCurrentUrl(), url);
            driver.quit();
        }

    }