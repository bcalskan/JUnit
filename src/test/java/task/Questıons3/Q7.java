package task.Questıons3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q7 extends TestBase {
    //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2. "Hover over Me First" kutusunun ustune gelin
    //3. "Link 1" e tiklayin
    //4. Popup mesajini yazdirin
    //5. Popup'i tamam diyerek kapatin
    //6. "Click and hold" kutusuna basili tutun
    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
    //8. "Double click me" butonunu cift tiklayin

    @Test
    public void test01() {
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMe = driver.findElement(By.xpath("(//button[@class='dropbtn'])[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverMe).perform();

        //3. "Link 1" e tiklayin
        WebElement link1 = driver.findElement(By.xpath("(//a[@class='list-alert'])[2]"));
        actions.click(link1).perform();

        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.xpath("//*[text()='Click and Hold!']"));
        actions.clickAndHold(clickAndHold).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement clickAndHoldText = driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]"));
        System.out.println(clickAndHoldText.getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickMe = driver.findElement(By.xpath("//h2"));
        actions.click(doubleClickMe).perform();
    }
}
