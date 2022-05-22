package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseImplicitly;

import java.util.Set;

public class C03_Actions extends TestBaseImplicitly {
    @Test
    public void test01() {
        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String ilkSayfaHandle = driver.getWindowHandle();

        //3- Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement cizgiliAlan = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlan).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedText = "You selected a context menu";
        String actualText = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedText, actualText);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        driver.switchTo().activeElement();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

//        WindowHandlesSet obj = new WindowHandlesSet();
//        obj.handle();


        Set<String> windowHandlesSeti = driver.getWindowHandles();
        String ikinciSayfaHandle = "";
        for (String each : windowHandlesSeti) {
            if (!each.equals(ilkSayfaHandle)) {
                ikinciSayfaHandle = each;
            }
        }
        driver.switchTo().window(ikinciSayfaHandle);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String actualTitle = driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
        String expectedTitle = "Elemental Selenium";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
}
