package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandles {
    //● Tests package’inda yeni bir class olusturun: WindowHandle2
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void test() {

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text = driver.findElement(By.xpath("//h3"));
        String expectedText = "Opening a new window";
        Assert.assertTrue(text.getText().equals(expectedText));

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertTrue(actualTitle.equals(expectedTitle));

        /*
        eger kontrolsüz acilan bir tab veya window varsa
        o zaman sayfalarin window handle degerlerini elde etmek gerekir

        öncelikle ikinci sayfa acilmadan önce ilk sayfanin window handle degerini
        bir stringe atayalim
         */
        String ilkSayfaHandle = driver.getWindowHandle();


        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        /*
        switchTo().newWindow(). demeden link tiklayarak yeni tab veya window olustugunda
        biz drivera yeni sayfaya gec demedikce driver eski sayfada kalir
        ve yeni sayfa ile ilgili hicbir islem yapamaz
        yeni sayfada driveri calistirmak isterseniz
        önce driveri yeni sayfaya yollamalisiniz
         */

        /*
        yeni sayfaya gecebilmek icin öncelikle ikinci sayfa window handle degerini bulmak gerekir
        bunun icin driver.getWindowHandles() methodu kullanarak
        acik olan tüm sayfalarin window handle degerlerini alip bir set´e assign ederiz

        ilk sayfanin handle degerine sahip oldugumuz icin foreach ile Handles degerlerini tek tek gezeriz.
        Ilk sayfaya esit olmayan handle degerini yeni bir stringe assign ederiz
        Böylece ikinci sayfanin handle degerine erismis oluruz ve saayfalar arasi gecis yapabilirz
         */

        Set<String> windowHandlesSeti = driver.getWindowHandles();
        System.out.println(ilkSayfaHandle);
        System.out.println(windowHandlesSeti);

        String ikinciSayfaHandle = "";
        for (String each : windowHandlesSeti) {
            if (!each.equals(ilkSayfaHandle)) {
                ikinciSayfaHandle = each;
            }
        }
        driver.switchTo().window(ikinciSayfaHandle);


        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String newActualTitle = driver.getTitle();
        String newExpectedTitle = "New Window";
        Assert.assertEquals(newActualTitle, newExpectedTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String newActualText = driver.findElement(By.xpath("//h3")).getText();
        String newExpectedText = "New Window";
        Assert.assertEquals(newActualText, newExpectedText);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        String birÖncekiTitle = driver.switchTo().window(ilkSayfaHandle).getTitle();
        String börÖncekiExpectedTitle = "The Internet";

        Assert.assertEquals(birÖncekiTitle, börÖncekiExpectedTitle);

    }
}

