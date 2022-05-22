package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseImplicitly;

public class C02_Actions extends TestBaseImplicitly {
    @Test
    public void test01() throws InterruptedException {
        //1- Bir Class olusturalim KeyboardActions2
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();


        //4- videoyu izlemek icin Play tusuna basin
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(iframeElement);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
        Thread.sleep(3000);
        //5- videoyu calistirdiginizi test edin
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']")).isDisplayed());
    }
}
