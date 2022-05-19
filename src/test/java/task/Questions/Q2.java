package task.Questions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2 {
    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

//    @After
//    public void after(){
//        driver.close();
//    }

    @Test
    public void tekrarTesti() {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[text()='Kabul ediyorum']")).click();

        String sayfaBasligi = driver.getTitle();
        System.out.println("Sayfa basligi : " + sayfaBasligi);
        System.out.println(sayfaBasligi.contains("Google") ? "Sayfa basligi test PASSED" : "Sayfa basligi test FAILED");

        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Nutella" + Keys.ENTER);


//        WebElement kontrol = driver.findElement(By.xpath("//div[@id='result-stats']"));
//        String[] arr = kontrol.getText().split(" ");
//
//        int deger = Arrays.stream(arr).limit(2).skip(1).mapToInt(t->Integer.valueOf(t))



    }
}
