package task.TekrarSorulari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseImplicitly;

import java.util.Set;

public class Actions2 extends TestBaseImplicitly {

    @Test
    public void name() {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String ilkSayfaHandle = driver.getWindowHandle();

        //3- Cizili alan uzerinde sag click yapalim
        WebElement alan = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(alan).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String alertText = driver.switchTo().alert().getText();
        String alertExpected = "You selected a context menu";
        Assert.assertEquals(alertExpected,alertText);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[@target='_blank']")).click();
        Set<String> windowHandlesSeti = driver.getWindowHandles();
        String ikinciSayfaHandle = "";
        for (String each : windowHandlesSeti) {
            if (!each.equals(ilkSayfaHandle)) {
                ikinciSayfaHandle = each;
            }
        }
        driver.switchTo().window(ikinciSayfaHandle);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String expectedTag = "Elemental Selenium";
        String actualTag = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedTag, actualTag);
    }
}
