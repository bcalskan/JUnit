package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseImplicitly;

public class C02_Actions extends TestBaseImplicitly {
    @Test
    public void test01() throws InterruptedException {
        // amazon anasayfaya git
        driver.get("https://www.amazon.com");

        // account menüsünden create a list´e tikla
        Actions actions = new Actions(driver);
        WebElement accountLinki = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        actions.moveToElement(accountLinki).perform();

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        Thread.sleep(5000);

    }
}
