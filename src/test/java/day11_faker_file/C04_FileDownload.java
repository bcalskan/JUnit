package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    //1- asagidaki testi yap
    //      -https://the-internet.herokuapp.com/download adresine git
    //      -dummy.txt dosyasini indir
    //2. Ardindan isExist ile indirilip indirilmedigini kontrol et

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//*[text()='dummy.txt']")).click();
        Thread.sleep(3000);

        //dosya yolu lazim
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\dummy.txt";
        String arananDosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));

    }
}
