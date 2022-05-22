package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseImplicitly;

public class C06_KeyboardActions extends TestBaseImplicitly {

    @Test
    public void test01() throws InterruptedException {
        // 1- facebook´a git
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();

        // 2- yeni kayit olustur click
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // 3- isim kutusunu locate et
        WebElement ad = driver.findElement(By.xpath("//input[@name='firstname']"));

        // 4- geriye kalan alanlari tab ile gez ve doldur
        Actions actions = new Actions(driver);

        actions.click(ad)
                .sendKeys("Berk")
                .sendKeys(Keys.TAB)
                .sendKeys("C")
                .sendKeys(Keys.TAB)
                .sendKeys("111111")
                .sendKeys(Keys.TAB)
                .sendKeys("password")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("1")
                .sendKeys(Keys.TAB)
                .sendKeys("Nisan")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();

        Thread.sleep(3000);


    }
}
