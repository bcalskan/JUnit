package task.TekrarSorulari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBaseImplicitly;

public class HandleWindow2 extends TestBaseImplicitly {
    @Test
    public void name() {
        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");

        // 2- url'in  amazon icerdigini test edelim
        String arananKelime = "amazon";
        String actualKelime = driver.getCurrentUrl();
        String ilkSayfaHandleDegeri = driver.getWindowHandle(); //--> amazon handle degerini getirir
        Assert.assertTrue(actualKelime.contains(arananKelime));

        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaHandle = driver.getWindowHandle();


        // 4- title'in BestBuy icerdigini test edelim
        String arananTitle = "Best Buy";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananTitle));

        // 5- ilk sayfaya donup sayfada Java aratalim --> ilk sayfanin handle window degerini getir/bul
        driver.switchTo().window(ilkSayfaHandleDegeri);
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        // 6- arama sonuclarinin Java icerdigini test edelim
        String actualAramaSonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String arananSonucKelimesi = "Java";
        Assert.assertTrue(actualAramaSonuc.contains(arananSonucKelimesi));

        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaHandle);

        // 8- logonun gorundugunu test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());
    }
}



//        Set<String> handles = driver.getWindowHandles();
//        String ikinciSayfaHandleDegeri = "";
//        for (String each : handles) {
//            if (!each.equals(ilkSayfaHandleDegeri)) {
//                each = ikinciSayfaHandleDegeri;
//            }
//        }

//String ikinciSayfaHandleDegeri = handles.stream().filter(t-> !t.equals(ilkSayfaHandleDegeri));
