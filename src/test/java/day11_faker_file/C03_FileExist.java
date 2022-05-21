package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));
        // icinde oldugumuz projenin dosya yolunu(path) verir

        System.out.println(System.getProperty("user.home"));
        // C:\Users\Berk benim bilgisayarimin bana özel kismini verir

        // homePath + "/Downloads"

        // Masaüstündeki text dosyasinin varligini test edin
        //"C:\Users\Berk\Desktop\text.txt"
        String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\text.txt";
        System.out.println(dosyaYolu);

        /*
        Bilgisayariimzdaki bir dosyanin varligini test etmek icin
        önce o dosyaya ulasmamiz gerekir
        Javada dosyaya erisim icin dosya yoluna (path) ihtiyac vardir
        Her bilgisayarin kullanici adi farkli olacaindan
        masaüstü disya yolu da birbirinden farkli olacaktir
        testlerimizin tüm bilgisayarlarda calismasi icin dosya yolu DINAMIK olmali

        Bunun icin ;
            Her bilgisayarin birbirinden farkli olan yolunu bulmak icin
            */

        String farkliKisim = System.getProperty("user.home");

        //Herkesin pc´de ortak olan kisim ise
        String ortakKisim = "\\Desktop\\text.txt";

        String masaustuDosyaYolu = farkliKisim + ortakKisim;

        //Exist control --> true or false
        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));
    }
}
