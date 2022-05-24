package task.Questıons3;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q1 extends TestBase {
    //1- Bir Class olusturalim KeyboardActions2

    //2- https://html.com/tags/iframe/ sayfasina gidelim

    //3- video’yu gorecek kadar asagi inin

    //4- videoyu izlemek icin Play tusuna basin

    //5- videoyu calistirdiginizi test edin


    @Test
    public void test01() {
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //4- videoyu izlemek icin Play tusuna basin
        WebElement IFrameElement = driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(IFrameElement);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();

        //5- videoyu calistirdiginizi test edin
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']")).isDisplayed());

    }
}
