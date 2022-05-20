package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {
    //● Bir class olusturun: IframeTest
    //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
    //   ● Bir metod olusturun: iframeTest
    //        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
    //        ○ Text Box’a “Merhaba Dunya!” yazin.
    //        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu     dogrulayin ve  konsolda yazdirin.

    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @After
    public void after() {
        //driver.quit();
    }

    @Test
    public void iframeTest() throws InterruptedException {
        //        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
        WebElement anIFrame = driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(anIFrame.isEnabled());
        System.out.println(anIFrame.getText());

        //        ○ Text Box’a “Merhaba Dunya!” yazin.
        /*
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Merhaba Dunya!");
        Dogru olarak locate etmemize ragmen driver bulunamadi
        bunun üzerine HTML kodlarini inceleyince
        textboxin aslinda bir iframe icerisinde oldugunu gördük
        bu durumda önce iframe locate edilir
        switchTo ile o iFrame´e gecilir

         */
        WebElement iFrameElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));

        driver.switchTo().frame(iFrameElement);

        WebElement textKutusu = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textKutusu.clear();

        textKutusu.sendKeys("Merhaba Dunya!");
        Thread.sleep(5000);
        /*
        Buradan sonra eger bir sonraki task iFrame´den baska bir tag tasiyorsa
        manuel olarak iFrame´den cikis yapmak zorundayiz.
                driver.switchTo().parentFrame(); --> ic ice frame varsa bir üst frame´e gecer
                driver.switchTo().activeElement(); -->
                driver.switchTo().defaultContent();


         */

        driver.switchTo().activeElement();


        //        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
//        WebElement linkYaziElementi=driver.findElement(By.linkText("Elemental Selenium"));
//        Assert.assertTrue(linkYaziElementi.isDisplayed());
//        System.out.println(linkYaziElementi.getText());


        // findElements(By.tagName("iframe") deyip bir liste atabilirsin


    }


}
