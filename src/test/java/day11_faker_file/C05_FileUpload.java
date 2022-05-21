package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    @Test
    public void name() {
        // https://the-internet.herokuapp.com/upload adresine git
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna tikla ve dosya sec
        /*
        Bu islem selenium ile yapilmaz cünkü web tabanli bir uygulama degil
        bu durumda sendKeys() kullanilir
        eger chooseFile butonuna var olan bir dosyanin dosya yolunu yollarsak
        secme isltemi otomatik olarak yapilacaktir
         */

        //1.adim choosefile locate et
        WebElement dosyaSecButonu = driver.findElement(By.xpath("//input[@id='file-upload']"));

        //2.adim yüklenecek dosyanin yolunu olustur --> masaüstündeki texti yolla
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\text.txt";
        String dosyaYolu = farkliKisim + ortakKisim;

        //3.adim sendKeys ile dosya yolunu secme butonuna yolla
        dosyaSecButonu.sendKeys(dosyaYolu);

        //Upload butonuna tikla
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        //"File Uploaded!" textinin görüntülendigini test et
        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());
    }
}
