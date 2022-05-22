package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseImplicitly;

public class C05_KeyboardActions extends TestBaseImplicitly {

    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        // 1- arama kutusuna click yap
        Actions actions = new Actions(driver);
        actions.click(aramaKutusu)

        // 2- harf harf nutella yazisini yazdir
        // 3- enter´a bas
                .keyDown(Keys.SHIFT)
                .sendKeys("n")
                .keyUp(Keys.SHIFT)
                .sendKeys("u")
                .sendKeys("t")
                .sendKeys("e")
                .sendKeys("l")
                .sendKeys("l")
                .sendKeys("a")
                .sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);



    }
}
