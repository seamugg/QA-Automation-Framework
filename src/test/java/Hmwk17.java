import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Hmwk17 extends BaseTest{


@Test
        public void AddSongToPlaylist() throws InterruptedException {

        ChromeOptions chrome_Profile = new ChromeOptions();
        chrome_Profile.addArguments("--disable-notifications");
        provideEmail("seamugg@yahoo.com");
        providePassword("te$t$tudent");
        Thread.sleep(3000);
        clickSubmitBtn();
        Thread.sleep(3000);
        clickViewAllBtn();
        Thread.sleep(3000);
        String getSongTitle = getSongTitleTxt();
        clickSongFromList();
        clickAddToPlaylist();
        addToSuperPlaylist();


        //Verify the song
        String songFromSuperPlaylist = getSongTitleFromSuperPlaylist();
        Assert.assertEquals(songFromSuperPlaylist, getSongTitle);


        }



        private String getSongTitleFromSuperPlaylist() {

                WebElement superPlaylistSong = driver.findElement(By.xpath("//section[@id='playlistWrapper']//tr[@class='song-item']//td[@class='title']"));
                return superPlaylistSong.getText();
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


