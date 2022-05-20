package task.Questions2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBaseClass;

public class Q13 extends TestBaseClass {
    //● Yeni bir class olusturun: WindowHandle
    //● Amazon anasayfa adresine gidin.
    //● Sayfa’nin window handle degerini String bir degiskene atayin
    //● Sayfa title’nin “Amazon” icerdigini test edin
    //● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
    //● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
    //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    //● Sayfa title’nin “Walmart” icerdigini test edin
    //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

    @Test
    public void test01() {
        //● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String windowHandleDegeri = driver.getWindowHandle();

        //● Sayfa title’nin “Amazon” icerdigini test edin
        String arananKelime = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananKelime));

        //● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");

        //● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String newTabActualTitle = driver.getTitle();
        System.out.println(newTabActualTitle);
        String arananKelime2 = "TECHPROEDUCATION";
        Assert.assertFalse(newTabActualTitle.contains(arananKelime2));

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.walmart.com");

        //● Sayfa title’nin “Walmart” icerdigini test edin
        String arananKelime3 = "Walmart";
        String newTab2ActualTitle = driver.getTitle();
        Assert.assertTrue(newTab2ActualTitle.contains(arananKelime3));

        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(windowHandleDegeri);
        String arananKelime4 = "Amazon";
        String actualTitle1 = driver.getTitle();
        Assert.assertTrue(actualTitle1.contains(arananKelime4));


    }
}
