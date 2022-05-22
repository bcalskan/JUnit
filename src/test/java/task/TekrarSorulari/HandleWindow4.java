package task.TekrarSorulari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBaseImplicitly;

public class HandleWindow4 extends TestBaseImplicitly {

    @Test
    public void name() {
        //● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonHandle = driver.getWindowHandle();

        //● Sayfa title’nin “Amazon” icerdigini test edin
        String arananKelime = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananKelime));

        //● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");

        //● Sayfa title’nin “TECHPROEDUCATION” icermedigini test edin
        String title2 = "TECHPROEDUCATION";
        String techTitle = driver.getTitle();
        Assert.assertFalse(techTitle.contains(title2));

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.walmart.com");

        //● Sayfa title’nin “Walmart” icerdigini test edin
        String walmartTitle = "Walmart";
        String walmartActualTitle = driver.getTitle();
        Assert.assertTrue(walmartActualTitle.contains(walmartTitle));

        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test
        driver.switchTo().window(amazonHandle);

    }
}
