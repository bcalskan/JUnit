package task.Questions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q81 {
    //1-C01_TekrarTesti isimli bir class olusturun
    //2- https://www.google.com/ adresine gidin
    //3- cookies uyarisini kabul ederek kapatin
    //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
    //5- Arama cubuguna “Nutella” yazip aratin
    //6-Bulunan sonuc sayisini yazdirin
    //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    //8-Sayfayi kapatin

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
        driver.close();
    }

    @Test
    public void run() {
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//*[text()='Kabul ediyorum']")).click();

        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        String arananKelime = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananKelime));

        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaCubugu = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        aramaCubugu.sendKeys("Nutella" + Keys.ENTER);

        //6-Bulunan sonuc sayisini yazdirin
        WebElement sonuc = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String sonucText = sonuc.getText(); //Yaklaşık 79.300.000 sonuç bulundu
        System.out.println(sonucText);

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String[] arr = sonucText.split(" ");
        String sonucDeger = arr[1].replaceAll("\\p{Punct}", ""); //79300000
        System.out.println("String noktasiz : " + sonucDeger);

        int IntSonucDeger = Integer.parseInt(sonucDeger); //79300000
        System.out.println("Integer : " + IntSonucDeger);

        int testDegeri = 10000000;
        Assert.assertTrue(IntSonucDeger > testDegeri);
        //Assert.assertFalse( IntSonucDeger < testDegeri);

    }


}
