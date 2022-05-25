package task.TekrarSorulari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExist extends TestBase {

    @Test
    public void test01() {
        //1- asagidaki testi yap
        //      -https://the-internet.herokuapp.com/download adresine git
        driver.get("https://the-internet.herokuapp.com/download");
        //      -text.txt dosyasini indir
        driver.findElement(By.xpath("//*[text()='text.txt']")).click();
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\text.txt";
        String dosyaYolu = farkliKisim + ortakKisim;

        //2. Ardindan isExist ile indirilip indirilmedigini kontrol et
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));


    }
}
