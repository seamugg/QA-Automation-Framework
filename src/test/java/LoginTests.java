import POM.pages.AllSongsPage;
import POM.pages.BasePage;
import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void LoginValidEmailPasswordTest () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(homePage.isUserAvatarDisplayed());

    }

    @Test
    public void LoginEmptyPasswordTest () {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(loginPage.isPageOpened());

    }

    @Test(enabled = false, priority = 0)
    public void OpenLoginPageTest () {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test (enabled=false, priority = 1)// (priority = 1, dataProvider = "invalidCredentials", dataProviderClass = BaseTest.class)
    public void LoginValidEmailValidPasswordTest () {

        login();
        // driver.findelement(how to find the element)
        // |
        // var = how to find element
        // driver.findelement(var)

        By avatarIconLocator = By.xpath("//img[contains(@alt,'Avatar of')]");
        By playlistLocator = By.cssSelector("#playlists h1");

        wait.until(ExpectedConditions.elementToBeClickable(avatarIconLocator));
        WebElement avatarIcon = driver.findElement(avatarIconLocator);
        Assert.assertTrue(avatarIcon.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(playlistLocator));
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(playlistLocator), "PLAYLISTS"));
    }


    // Test with POM for allpage
    @Test(enabled = false)
    public void Shuffle(){
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        HomePage homePage = loginPage.login();

        //homePage.clickOnAllSongs()
        //        .shuffle();
        Assert.assertTrue(homePage.isSongPlaying());

    }

    @Test(enabled = false)
    public void PlayASongFromAllSongs(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homey = new HomePage(driver);
        AllSongsPage singysongy = new AllSongsPage(driver);

        //Step1: Login
        loginPage.login();
        //Step2: Click on All Songs
        homey.clickOnAllSongs();
        //Step3: double click on first song
        singysongy.doubleClickFirstSong();
        //Step4: check if song is playing
        Assert.assertTrue(homey.isSongPlaying());
    }


    @Test(enabled = false, priority = 2)
    public void LoginInvalidEmailPasswordTest () throws InterruptedException {
        provideEmail("seamugg@yahoo.com");
        providePassword("");
        clickSubmitBtn();

        // Vd
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test(enabled = false)
    public void LoginValidEmailEmptyPasswordTest () {
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
    public void SwitchToSongsMenu () throws InterruptedException {
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
    public void SearchSong () throws InterruptedException {
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
