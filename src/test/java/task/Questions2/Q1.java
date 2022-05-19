package task.Questions2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {
    //Yeni bir Class Olusturun : D11_SoftAssert1
    //1. “https://www.hepsiburada.com/” Adresine gidin
    //2. Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
    //3. search kutusuna araba yazip arattirin
    //4. bulunan sonuc sayisini yazdirin
    //5. sonuc yazisinin "araba" icerdigini dogrulayin
    //6. Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin

    WebDriver driver;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void after(){
        driver.close();
    }

    @Test
    public void test01(){
        //1. “https://www.hepsiburada.com/” Adresine gidin
        driver.get("https://www.hepsiburada.com/");

        //2. Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
        String expectedTitle = "Turkiye’nin En Buyuk Alisveris Sitesi";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertFalse(actualTitle.contains(expectedTitle));

        //3. search kutusuna araba yazip arattirin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("araba"+ Keys.ENTER);

        //4. bulunan sonuc sayisini yazdirin
        String sonucSayisi = driver.findElement(By.xpath("//div[@class='searchResultSummaryBar-mainText']")).getText();
        System.out.println(sonucSayisi);

        //5. sonuc yazisinin "araba" icerdigini dogrulayin
        String arananKelime = "araba";
        Assert.assertTrue(sonucSayisi.contains(arananKelime));

        //6. Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin
        String aranmayanKelime = "oto";
        Assert.assertFalse(sonucSayisi.contains(aranmayanKelime));

    }

}
