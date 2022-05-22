package task.TekrarSorulari;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseImplicitly;

public class Actions extends TestBaseImplicitly {

    @Test
    public void test01() {
        // amazon anasayfaya git
        driver.get("https://www.amazon.com");

        // account menüsünden create a list´e tikla
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        WebElement accountLinki = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        actions.moveToElement(accountLinki).perform();
        WebElement createList = driver.findElement(By.xpath("//*[text()='Create a List']"));
        actions.click(createList).perform();
    }



}
