package task.Questions2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

import java.util.List;

public class Q9 extends TestBaseClass {
    //● Bir class oluşturun: C3_DropDownAmazon
    //● https://www.amazon.com/ adresine gidin.
    //- Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    //-Test 2
    //1. Kategori menusunden Books secenegini secin
    //2. Arama kutusuna Java yazin ve aratin
    //3. Bulunan sonuc sayisini yazdirin
    //4. Sonucun Java kelimesini icerdigini test edin

    @Test
    public void test01() {
        driver.get("https://www.amazon.com/");
        WebElement ddm = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select select = new Select(ddm);
        List<WebElement> ddmList = select.getAllSelectedOptions();
        int expectedKategoriSayisi = 45;
        Assert.assertFalse(ddmList.size() == expectedKategoriSayisi);

        select.selectByVisibleText("Books");

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Actions actions = new Actions(driver);
        actions.click(aramaKutusu).sendKeys("Java" + Keys.ENTER).perform();

        String sonucSayisi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        System.out.println(sonucSayisi);

        String arananKelime = "Java";
        Assert.assertTrue(sonucSayisi.contains(arananKelime));
    }


}
