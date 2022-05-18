package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindows {
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
        //driver.quit();
    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        String handleValue = driver.getWindowHandle();

        //2- nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        /*
        CDwindow-710A9251CA36BCB587CC111797CA05DF
        Bu kod acilan sayfanin unique hash kodudur
        Selenium sayfalar arasi geciste bu window handle degerini kullanir

        Eger sayfalar arasinda driveri gezdiriyorsak ve herhangi bir sayfadan
        su anda bulundugumuz sayfaya gecmek istiyorsak
        driver.switchTo().window(driver.getWindowHandle());
        yazariz. Bu sayfanin windowhandle degerini girerek bu sayfaya gecisi saglayabiliriz
        */

        //3- ilk ürünün resmini tiklayarak farkli bir tab olarak acin
        WebElement ilkÜrünResmi = driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        Bu komutu kullandigimizda driver otomatik olarak olusturulan new Tab´a gecer.
        Yeni tab´da görevi gerceklestirmek icin adimlari bastan almamiz gerekir
         */
        System.out.println(driver.getCurrentUrl()); // about:blank

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        //4- yeni tabda acilan ürünün titleini yazdirin
        String productTitle = driver.findElement(By.xpath("//*[text()='        Nutella Chocolate Hazelnut Spread, Perfect Topping for Easter Treats, 26.5 oz (Packaging May Vary)       ']")).getText();
        System.out.println(productTitle);

        System.out.println(driver.getCurrentUrl());

        //5- ilk sayfaya gecip url yazdir
        System.out.println(driver.switchTo().window(handleValue).getCurrentUrl());


    }
}
