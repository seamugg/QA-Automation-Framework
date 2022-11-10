package PageFactory;

import POM.pages.AllSongsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @FindBy(how = How.CSS,  using = "img.avatar")
     WebElement avatarLocator;

   @FindBy (how = How.CSS, using ="[data-testid = 'sound-bar-play']")
   WebElement soundBarPlayLocator;


    @FindBy (how = How.CSS, using = "li a.songs" )
    WebElement allSongsMenuItemLocator;


    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getUserAvatar(){
        return driver.findElement((By) avatarLocator);
    }

    public boolean isUserAvatarDisplayed(){
        return driver.findElement((By) avatarLocator).isDisplayed();
    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = driver.findElement((By) soundBarPlayLocator);
        return soundBarVisualizer.isDisplayed();
    }

    public AllSongsPage clickOnAllSongs(){
        driver.findElement((By) allSongsMenuItemLocator).click();
        return new AllSongsPage(driver);
    }


}