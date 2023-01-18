import com.beust.ah.A;
import org.jetbrains.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class ProductSearch extends BaseTest {

Actions act;
    @Test
    public void ProductSearch() throws InterruptedException {
        searchbar();
        searchbar_click();
        search_withinresults();
        pageresults_last();
        lastitem();
        addtocart();
        viewcart();
        clearcart();
        clearcart_confirm();
    }
    public void searchbar() {
        WebElement searchbar = driver.findElement(By.xpath("//*[@data-testid='searchval']"));
        searchbar.click();
        searchbar.sendKeys("stainless work table");
    }
    private void searchbar_click()  {
        WebElement searchbar_click = driver.findElement(By.xpath("//*[@id='searchForm']/div/button"));
        searchbar_click.click();
    }

    private void search_withinresults() throws InterruptedException {
        Thread.sleep(100);
        WebElement search_withinresults = driver.findElement(By.xpath(  "  /html/body/div[2]/div/div[4]/nav/div/ul/li[4]/div/label/div/form/input[1]"));
        search_withinresults.click();
        search_withinresults.sendKeys("Table");
        Thread.sleep(100);
        WebElement search_withinresults_button = driver.findElement(By.xpath(  "//*[@id='searchWithinForm']/button"));
        search_withinresults_button.click();
    }
    private void pageresults_last() throws InterruptedException {
        WebElement pageresults_last = driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div[2]/div[5]/nav/ul/li[7]/a"));
        waitForElementToBeClickable(pageresults_last);
        pageresults_last.click();
        Thread.sleep(500);
    }
    private void lastitem() throws InterruptedException {
        Thread.sleep(500);
        WebElement addtocart = driver.findElement(By.xpath("//a[@href='/john-boos-co-sns1836-wood-top-work-table-with-stainless-steel-base-and-adjustable-undershelf-18-x-36/650SNS1836.html']"));
        addtocart.click();
    }
    private void addtocart(){
        WebElement search_withinresults_button = driver.findElement(By.xpath(  "/html/body/div[2]/div/div[2]/div[2]/div[1]/div[3]/form/div/div/input[2]"));
        search_withinresults_button.click();
    }

    private void viewcart(){
        WebElement viewcart = driver.findElement(By.xpath(  "/html/body/div[1]/div/div[1]/div[1]/div/div[3]/a[2]/span[1]/span"));
        viewcart.click();
        driver.navigate().refresh();


    }
    private void clearcart(){
        WebElement clearcart = driver.findElement(By.xpath(  "//*[@id='main']/div[1]/div/div[1]/div/button"));
        clearcart.click();
    }
    private void clearcart_confirm(){
        WebElement clearcart_confirm = driver.findElement(By.xpath(  "//*[@id='td']/div[11]/div/div/div/footer/button[1]"));
        clearcart_confirm.click();
    }
}

