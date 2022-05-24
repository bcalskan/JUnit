package task.Questıons3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import utilities.TestBaseClass;

import java.util.List;

public class Q10 extends TestBaseClass {
    //1. Tests packagenin altına class olusturun: CreateHotel
    //2. Bir metod olusturun: createHotel
    //3. https://www.hotelmycamp.com adresine git.
    //4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri girin.
    //a. Username : manager
    //b. Password : Manager1!
    //
    //    ● table( ) metodu oluşturun
    //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
    //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    //
    //    ● printRows( ) metodu oluşturun //tr
    //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    //            ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    //            ○ 4.satirdaki(row) elementleri konsolda yazdırın.


    @Test
    public void table() {
        logInMethodu();
        //    ● table( ) metodu oluşturun
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sütunSayisiList = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sütun sayisi : " + sütunSayisiList.size());

        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tümBody = driver.findElement(By.xpath("//table//tbody"));
        System.out.println(tümBody.getText());
    }

    @Test
    public void printRows() {
        //    ● printRows( ) metodu oluşturun //tr
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirListesi = driver.findElements(By.xpath("//table//tbody//tr"));
        System.out.println(satirListesi.size());

        //            ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each : satirListesi) {
            System.out.println(each.getText());
        }

        //            ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> dördüncüSatirElementlerListesi = driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each : dördüncüSatirElementlerListesi) {
            System.out.println(each.getText());
        }

        //            ○ Email basligindaki tum elementleri(sutun) konsolda yazdırın.
        // once email basliginin kacinci sutunda oldugunu bulalim
        List<WebElement> headerListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSirasi = 0;
        for (int i = 0; i < headerListesi.size(); i++) {
            if (headerListesi.get(i).equals("Email")) {
                emailSirasi = i;
            }
        }
        List<WebElement> emailSütunBilgileri = driver.findElements(By.xpath("//tbody//td[" + (emailSirasi + 1) + "]"));
        for (WebElement each : emailSütunBilgileri) {
            System.out.println(each.getText());
        }
    }

    public void logInMethodu() {
        //3. https://www.hotelmycamp.com adresine git.
        driver.get("https://www.hotelmycamp.com");

        //4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri girin.
        //a. Username : manager
        //b. Password : Manager1!
        WebElement logInButton = driver.findElement(By.xpath("//*[text()='Log in']"));
        logInButton.click();
        String username = "manager";
        String password = "Manager1!";

        WebElement usernameArea = driver.findElement(By.xpath("//input[@name='UserName']"));
        usernameArea.sendKeys(username);
        WebElement passwordArea = driver.findElement(By.xpath("//input[@name='Password']"));
        passwordArea.sendKeys(password);
        driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();
    }
}
