package task.Questions2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseClass;

import java.util.List;

public class Q12 extends TestBaseClass {
    //● Bir class olusturun: IframeTest02
    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //2) sayfadaki iframe sayısını bulunuz.
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
    //tıklayınız

    @Test
    public void test01() {
        driver.get("http://demo.guru99.com/test/guru99home/");

        driver.findElement(By.xpath("(//*[text()='Consent'])[1]")).click();

        int size = driver.findElements (By.tagName ("iframe")). size ();
        System.out.println("Ifram sayisi : "+size);

        //WebElement ilkIframe = driver.findElement (By.xpath("//iframe[@name='googlefcPresent']"));
        //driver.switchTo().frame(ilkIframe);


    }
}
