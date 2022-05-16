package task;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Q9_Youtube {
    /*
    https://www.youtube.com adresine gidin
    Asagidaki adlari kullanarak 3 test methodu olusturun ve gerekli testleri yapin
    titleTest->Sayfanin basliginin YouTube oldugunu test edin
    imageTest->YouTube resminin goruntulendigini test edin
    Search Box'in erisilebilir oludugunu test edin
    wrongTitleTest->Sayfa Basligiini
    */
    static WebDriver driver;
    @BeforeClass
    public static void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("//*[text()='Tümünü kabul et']")).click();
    }
    @AfterClass
    public static void after() {
        driver.close();
    }
    @Test
    public void titleTest() {
        //titleTest->Sayfanin basliginin YouTube oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Basliklar uyusmuyor.", expectedTitle, actualTitle);
    }
    @Test
    public void imageTest() {
        //imageTest->YouTube resminin goruntulendigini test edin
        //Search Box'in erisilebilir oludugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search']")).isEnabled());
    }
    @Test
    public void wrongTitleTest() {
        //wrongTitleTest->Sayfa Basligiini
        //mesela basligin youtube olmadigini test edelim
        Assert.assertFalse(driver.getTitle().equals("youtube"));
    }
}