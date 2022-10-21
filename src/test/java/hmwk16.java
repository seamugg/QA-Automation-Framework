import org.openqa.selenium.By;
<<<<<<< HEAD
=======
import org.openqa.selenium.Keys;
>>>>>>> Troubleshooting
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
<<<<<<< HEAD
=======
import org.testng.Assert;
>>>>>>> Troubleshooting
import org.testng.annotations.Test;

import java.time.Duration;


public class hmwk16 {
    @Test
    public static void newPlaylist() throws InterruptedException {

        ChromeOptions chrome_Profile = new ChromeOptions();
        chrome_Profile.addArguments("--disable-notifications");

       //login
        WebDriver driver = new ChromeDriver(chrome_Profile);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/#!/home";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type= 'email']"));
        emailField.click();
        emailField.sendKeys("seamugg@yahoo.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();
<<<<<<< HEAD
=======
        Thread.sleep(2000);
>>>>>>> Troubleshooting

        //create new playlist with xpath locators


        WebElement xPlaylist = driver.findElement(By.xpath("//*[@title= 'Create a new playlist']"));
        xPlaylist.click();

<<<<<<< HEAD
        Thread.sleep(5000);

        WebElement xPlaylist_ = driver.findElement(By.xpath("//*[contains(text(),‘New Playlist’)]"));
        xPlaylist_.click();

=======
        Thread.sleep(2000);

        WebElement xPlaylist_ = driver.findElement(By.xpath("//li[contains(text(), 'New Playlist')]"));
        xPlaylist_.click();

        Thread.sleep(2000);


        WebElement playlistName = driver.findElement(By.xpath("//*[@name = 'name']"));

         playlistName.sendKeys("Flannel");

         playlistName.sendKeys(Keys.RETURN);

        WebElement flannel = driver.findElement(By.xpath("//a[contains(text(), 'Flannel')]"));
        Assert.assertTrue(flannel.isDisplayed());
        Thread.sleep(5000);
        driver.quit();



>>>>>>> Troubleshooting
//        WebElement xPlaylist1 = driver.findElement(By.xpath("//div[contains(text(),'insert text')]"));
//        xPlaylist1.click();

//        WebElement newPlaylist = driver.findElement(By.xpath("//*[@id= 'playlists']"));
//        xPlaylist.click();
//i[@title='Create a new playlist']
//*[@id="playlists"]/form
    }
}