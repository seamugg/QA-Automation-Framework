import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Hmwk15 {


    @Test
    public static void login () throws InterruptedException {



        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type= 'email']"));
        emailField.click();
        emailField.sendKeys("seamugg@yahoo.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();



        WebElement searchBar = driver.findElement(By.cssSelector("[name = 'q']"));

        Assert.assertTrue(searchBar.isDisplayed());
        Thread.sleep(5000);

        searchBar.click();
        searchBar.sendKeys("Pluto");

        WebElement songPluto = driver.findElement(By.cssSelector("[id = 'text']"));
        Assert.assertTrue(songPluto.isDisplayed());
        Thread.sleep(5000);
        driver.quit();
    }

}