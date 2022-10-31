import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

//    @Test(enabled = false, priority = 0)
//    public void LoginEmptyEmailPasswordTest () {
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//    }

    @Test(priority = 1, dataProvider = "invalidCredentials", dataProviderClass = BaseTest.class)

        public void LoginValidEmailValidPasswordTest (String email, String password) {

            provideEmail("seamugg@yahoo.com");
            providePassword("te$t$tudent");
            clickSubmitBtn();

            WebElement avatarIcon = driver.findElement(By.xpath("//img[contains(@alt,'Avatar of')]"));
            Assert.assertTrue(avatarIcon.isDisplayed());

        }





    @Test(enabled = false)
    public static void LoginEmptyEmailPasswordTest () {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
