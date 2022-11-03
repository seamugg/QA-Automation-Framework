import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;

public class Hmwk20 extends BaseTest {

    @Test
    public void AddSongToPlaylist() throws InterruptedException {

        ChromeOptions chrome_Profile = new ChromeOptions();
        chrome_Profile.addArguments("--disable-notifications");
        provideEmail("seamugg@yahoo.com");
        providePassword("te$t$tudent");

        clickSubmitBtn();

        //clickViewAllBtn();

//
//        clickSongFromList();
//        clickAddToPlaylist();
//        addToSuperPlaylist();
//        PlaySong();
        GoToPlaylist();
        DeletePlaylist();
        VerifyPlaylistisDeleted();


//        //Verify the song
//        String songFromSuperPlaylist = getSongTitleFromSuperPlaylist();
//        Assert.assertEquals(songFromSuperPlaylist, getSongTitle);


    }
    private void VerifyPlaylistisDeleted() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='Alertify')")));
        WebElement AlertifyDelete = driver.findElement(By.xpath("//div[@class ='Alertify')"));
        AlertifyDelete.isDisplayed();
    }

    public void DeletePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Delete this playlist')")));
        WebElement GoToPlaylist= driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
        GoToPlaylist.click();
        GoToPlaylist.sendKeys(new org.openqa.selenium.Keys[]{ENTER});

    }

    public void GoToPlaylist() {
       // WebElement GoToPlaylist= driver.findElement(By.xpath("//a[@href='#!/playlist/27538']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#!/playlist/27538']")));
        WebElement GoToPlaylist= driver.findElement(By.xpath("//a[@href='#!/playlist/27538']"));
        GoToPlaylist.click();

    }
    public void ValidateSongIsPlaying(){
        WebElement ValidateSongPlaying = driver.findElement(By.xpath("//button[@title='Click for a marvelous visualizer']"));
        ValidateSongPlaying.click();
        Assert.assertTrue(ValidateSongPlaying.isDisplayed());
    }
    private void PlaySong() {

        WebElement PlaySong = driver.findElement(By.xpath("//span[data-testid='play-btn']"));
        PlaySong.click();
    }


    private String getSongTitleFromSuperPlaylist() {

        WebElement superPlaylistSong = driver.findElement(By.xpath("//section[@id='playlistWrapper']//tr[@class='song-item']//td[@class='title']"));
        return superPlaylistSong.getText();
    }

    private String getConfirmationPopupText() {
        return driver.findElement(By.cssSelector("div.success.show")).getText();
    }


    private void addToSuperPlaylist() {
        WebElement superPlaylist = driver.findElement(By.xpath("//*[starts-with(text(),'Flannel')]"));
        superPlaylist.click();
    }

    private String getSongTitleTxt() {
        WebElement getTitleTxt = driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//tr[@class='song-item']//td[@class='title']"));
        return getTitleTxt.getText();
    }

    private void clickAddToPlaylist() {
        WebElement addToPlaylist = driver.findElement(By.xpath("//button[contains(@title, 'Add selected songs')]"));
        addToPlaylist.click();
    }

    private void clickSongFromList() {
        WebElement songList = driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//tr[@class='song-item']"));
        songList.click();

    }

    private void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-testid='home-view-all-recently-played-btn']"));
        viewAllBtn.click();
    }
}


