package task.Questions2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseClassYoutube;

public class Q4 extends TestBaseClassYoutube {
    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //○ logoTest => BestBuy logosunun görüntülendigini test edin
    //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    @Test
    public void test01() {
        //1) Bir class oluşturun: BestBuyAssertions
        //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void urlTest() {
        //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.bestbuy.com/";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void titleTest() {
        //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualTitle = driver.getTitle();
        String notExpectedTitle = "Rest";
        Assert.assertFalse(actualTitle.contains(notExpectedTitle));
    }

    @Test
    public void logoTest() {
        //○ logoTest => BestBuy logosunun görüntülendigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());
    }

    @Test
    public void francaisLinkTest() {
        //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//button[@lang='fr']")).isDisplayed());
    }


}
