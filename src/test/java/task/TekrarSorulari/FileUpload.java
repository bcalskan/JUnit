package task.TekrarSorulari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class FileUpload extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //1.Tests packagenin altina bir class oluşturun : C05_UploadFile
        //2.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3.chooseFile butonuna basalim
        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='file-upload']"));
        chooseFile.click();

        //4.Yuklemek istediginiz dosyayi secelim.
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\magazalar.txt";
        String dosyaYolu = farkliKisim + ortakKisim;

        //5.Upload butonuna basalim.
        chooseFile.sendKeys(dosyaYolu);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@class='button']")).click();

        //6."File Uploaded!" textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());
    }
}
