import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class NewPlaylistName extends BaseTest{

    final Actions action = new Actions(driver);


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



    private void AddNewName() {
        WebElement AddNewName = driver.findElement(By.xpath("//li[contains(@testid, 'playlist-context-menu-edit-27813')]"));
        AddNewName.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        AddNewName.sendKeys("NOT Playlist");

    }

    public void GoToPlaylist() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#!/playlist/27813']")));
        WebElement GoToPlaylist= driver.findElement(By.xpath("//a[@href='#!/playlist/27813']"));
        action.moveToElement(GoToPlaylist).contextClick().perform();


    }



}
