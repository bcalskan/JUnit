package task;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q4 {
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
        //driver.close();
    }

    @Test
    public void nutella() {
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//*[text()='Kabul ediyorum']")).click();

        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        System.out.println("Expected : " + expectedTitle);
        System.out.println("Actual : " + actualTitle);

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title test PASSED");
        } else System.out.println("Title test FAILED");

        //5- Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Nutella" + Keys.ENTER);

        //6-Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String sonucText = sonucYazisi.getText();
        System.out.println(sonucText); //Yaklaşık 77.400.000 sonuç bulundu (0,40 saniye)

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String[] arr = sonucText.split(" ");
        arr[1] = arr[1].replaceAll("\\p{Punct}", "");
        String deger = arr[1]; //77400000
        int degerInt = Integer.parseInt(deger); //Integer deger : 77400000
        System.out.println("Integer deger : "+degerInt);
        System.out.println(degerInt > 10000000 ? "10M´dan büyük" : "10M´dan kücük");

        //8-Sayfayi kapatin
        driver.close();
    }
}
