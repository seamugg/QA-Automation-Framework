import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


//Using Action Class methods, create/refactor the test case renamePlaylist()
//        Implement Explicit Waits
//        Remove all Thread.sleep implementations
//        Create a new branch and commit your changes
//        Push your code to a remote repository
//        Create a pull request
//        Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework
public class Hmwk21 extends BaseTest{

    Actions action = new Actions(driver);


@Test
public void RenamePlaylist(){

        ChromeOptions chrome_Profile = new ChromeOptions();
        chrome_Profile.addArguments("--disable-notifications");
        provideEmail("seamugg@yahoo.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        GoToPlaylist();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        EditPlaylist();
        AddNewName();


}

    private void EditPlaylist() {

        WebElement EditPlaylist = driver.findElement(By.xpath("//button[contains(@title, 'Edit')]"));
        action.moveToElement(EditPlaylist).click();

    }


    // i role="button" title="Create a new playlist" data-testid="sidebar-create-playlist-btn" class="fa fa-plus-circle create"></i>
   // li data-v-5f33db96="" data-testid="playlist-context-menu-edit-27813">Edit</li>
    private void AddNewName() {
        WebElement AddNewName = driver.findElement(By.xpath("//li[contains(@testid, 'playlist-context-menu-edit-27813')]"));
        AddNewName.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        AddNewName.sendKeys("NOT Playlist");

    }

//    private void CreateNewPlaylist() {
//        WebElement renamePlaylist = driver.findElement(By.xpath("//button[contains(@title, 'Create a new playlist')]"));
//        action.moveToElement(renamePlaylist).contextClick().perform();
//    }
//
    public void GoToPlaylist() {
        // WebElement GoToPlaylist= driver.findElement(By.xpath("//a[@href='#!/playlist/27538']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#!/playlist/27813']")));
        WebElement GoToPlaylist= driver.findElement(By.xpath("//a[@href='#!/playlist/27813']"));
        action.moveToElement(GoToPlaylist).contextClick().perform();


    }



}
