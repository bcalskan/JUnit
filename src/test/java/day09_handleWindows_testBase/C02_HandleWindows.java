package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindows {

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
    public void test() {
        // 1- amazon´a git
        driver.get("https://www.amazon.com");
        String ilkSayfaHandle = driver.getWindowHandle();

        // 2- url´in amazon icerdigini test et
        String arananKelime = "amazon";
        Assert.assertTrue(driver.getCurrentUrl().contains(arananKelime));

        // 3- yeni bir pencere acip bestbuy ana sayfaya git
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaHandle = driver.getWindowHandle();

        // 4- title´in BestBuy icerdigini test et
        String arananKelime2 = "BestBuy";
        String actualTitle = driver.getTitle();
        System.out.println("Actual title : " + actualTitle);
        Assert.assertFalse(actualTitle.contains(arananKelime2));

        // 5- ilk sayfaya dönüp sayfada java arat
        driver.switchTo().window(ilkSayfaHandle);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java" + Keys.ENTER);

        // 6- arama sonuclarinin Java icerdigini test et
        String aramaSonucText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String arananKelime3 = "Java";
        Assert.assertTrue(aramaSonucText.contains(arananKelime3));

        // 7- yeniden Bestbuy´in acik oldugu sayfaya git
        driver.switchTo().window(ikinciSayfaHandle);

        // 8- logonun göründügünü test et
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());
    }

}
