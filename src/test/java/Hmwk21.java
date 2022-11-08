import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

class NewPlaylistName extends BaseTest {


    @Test
    public void RenamePlaylist() {
        ChromeOptions chrome_Profile = new ChromeOptions();
        chrome_Profile.addArguments("--disable-notifications");
        provideEmail("seamugg@yahoo.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        GoToPlaylist();
        EditPlaylist();
        AddNewName();


    }

    private void EditPlaylist() {
        Actions action = new Actions(driver);
        WebElement EditPlaylist = driver.findElement(By.xpath("//button[contains(@title, 'Edit')]"));
        waitForVisibilityOfElement(EditPlaylist);
        action.moveToElement(EditPlaylist).click();

    }


    private void AddNewName() {
        WebElement AddNewName = driver.findElement(By.xpath("//li[contains(@testid, 'playlist-context-menu-edit-27813')]"));
        waitForElementToBeClickable(AddNewName);
        AddNewName.click();
        AddNewName.sendKeys("NOT Playlist");

    }

    public void GoToPlaylist() {
        Actions action = new Actions(driver);
        WebElement GoToPlaylist = driver.findElement(By.xpath("//a[@href='#!/playlist/27813']"));
        waitForVisibilityOfElement(GoToPlaylist);
        action.moveToElement(GoToPlaylist).contextClick().perform();

    }
}