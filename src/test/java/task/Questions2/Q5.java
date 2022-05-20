package task.Questions2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseClassYoutube;

public class Q5 extends TestBaseClassYoutube {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    @Test
    public void test01() {
        //2) https://www.youtube.com adresine gidin

    }

    @Test
    public void titleTest() {
        //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String arananKelime = "YouTube";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, arananKelime);
    }

    @Test
    public void imageTest() {
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]")).isDisplayed());
    }

    @Test
    public void searchBoxTest() {
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='search']")).isEnabled());
    }

    @Test
    public void wrongTitleTest() {
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String arananTitle = "youtube";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.equals(arananTitle));
    }


}
