import POM.pages.AllSongsPage;
import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PlaySong extends BaseTest{

    @Test
    public void playSong() throws InterruptedException {
        // test case here
        // Class23 Example

        LoginPage loginPage = new LoginPage(driver);
        AllSongsPage songsPage = new AllSongsPage(driver);
        //BasePage basePage = new BasePage(driver);
        HomePage homePage = new HomePage(driver);

        //login();
        loginPage.login();
        //chooseAllSongsList();
        homePage.clickOnAllSongs();
        //contextClickFirstSong();
        songsPage.contextClickFirstSong();
        //choosePlay();
        songsPage.playFromContextMenu();
        //Assert.assertTrue(isSongPlaying());
        Assert.assertTrue(songsPage.isSongPlaying());
    }

    //    helper methods
    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return soundBarVisualizer.isDisplayed();
    }

    @Test
    void hoverOverPlayButton(){
        login();
        chooseAllSongsList();
        hoverPlay();
        Assert.assertTrue(hoverPlay().isDisplayed());
        hoverPlay().click();
        Assert.assertTrue(isSongPlaying());
    }

    private WebElement hoverPlay() {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return play;
    }

@Test(enabled = false)
    public void listOfSongWebElements(){
        // I want to verify that the playlist 'super' has 3 songs
        // login
    login();
        // click on playlist 'super'
    choosePlaylistByName("super");
        // count the number of songs
    getListOfSongs();
    Assert.assertEquals(getListOfSongs().size(),3);
    }

    private List getListOfSongs() {
        return driver.findElements(By.cssSelector("#playlistWrapper td.title"));
    }

    private void choosePlaylistByName(String name) {
        By playlistLocator = By.xpath("//a[contains(text(), '" + name + "')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(playlistLocator)).click();
    }

    @Test
    public void renamePlaylist() throws InterruptedException {
        // Login
        login();
        // doubleclick on a playlist
        doubleClickChoosePlaylist();
        // Enter new playlist name
        enterPlaylistName();
        // assert that the new playlistname exists
        Assert.assertTrue(doesPlaylistExist());
    }

    private boolean doesPlaylistExist() {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='Edited Playlist Name']"));
        return playlistElement.isDisplayed();
    }

    private void enterPlaylistName()  throws InterruptedException {
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys((Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE)));
        Thread.sleep(3000);
        playlistInputField.sendKeys("Edited Playlist Name");
        playlistInputField.sendKeys(Keys.ENTER);
    }

    private void doubleClickChoosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        WebElement element = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        actions.doubleClick(element).perform();
    }
}
