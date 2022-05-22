package task.TekrarSorulari;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseImplicitly;

public class KeyboardActions2 extends TestBaseImplicitly {
    // 1- facebook´a git
    // 2- yeni kayit olustur click
    // 3- isim kutusunu locate et
    // 4- geriye kalan alanlari tab ile gez ve doldur

    @Test
    public void test01(){
        driver.get("https://www.facebook.com");
        Actions actions = new Actions(driver);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");   ------> arastir
        WebElement cerez = driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']"));
        actions.click(cerez).perform();

        WebElement yeniKayitButonu = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        actions.click(yeniKayitButonu).perform();

        WebElement isim = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();

        actions.click(isim)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("1")
                .sendKeys(Keys.TAB)
                .sendKeys("Ocak")
                .sendKeys(Keys.TAB)
                .sendKeys("2002")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.ENTER)
                .perform();
    }


}
