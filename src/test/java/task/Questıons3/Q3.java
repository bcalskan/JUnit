package task.Questıons3;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;
import utilities.TestBaseClass;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Q3 extends TestBaseClass {
    //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    //2. Iki tane metod oluşturun : isExist( ) ve downloadTest( )
    //3. downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
    //      - https://the-internet.herokuapp.com/download adresine gidelim.
    //      - UpFile.txt dosyasını indirelim
    //code.txt
    //4. Ardından isExist( ) methodunda dosyanın başarıyla indirilip indirilmediğini test edelim



    @Test
    public void downloadTest() {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//*[text()='LambdaTest.txt']")).click();
    }

    @Test
    public void isExist() {
        //"C:\Users\Berk\Downloads\LambdaTest.txt"


        String farkliKisim = System.getProperty("user.home");
        System.out.println(farkliKisim);
        String ortakKisim = "\\Downloads\\lambdaTest.txt";
        System.out.println(ortakKisim);

        String path = farkliKisim + ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(path)));

    }
}
