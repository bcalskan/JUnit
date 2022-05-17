package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
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
    public void test01() {
        /*
        Herhangi bir web sitesine gidince veya
        bir websitesinde herhangi bir islem yaptigimizda ortaya cikan uyarilara alert diyoruz

        Eger bir alert inspect yapilabiliyorsa, o alert otomasyon ile kullanilabilir.
        bu tur alert'lere HTML alert denir ve bunlar icin ekstra bir islem yapmaya gerek yoktur
        tum webelementler gibi locate edip istedigimiz islemleri yapabiliriz
        driver.get("https://www.facebook.com"); da cikan alert vb.

        Ancak web uygulamalarinda HTML alert yaninda java script alert de bulunabilir.
        JS Alertler locate edilemez. Seleniumda js alertler icin bir yöntem gelistirilmistir
        */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        driver.switchTo().alert().accept();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']")).isDisplayed());
    }
}
