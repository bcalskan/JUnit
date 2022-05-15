package task;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import java.time.Duration;

public class YouTubeAssertion {
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
    public static void setUp(){
        WebDriverManager.chromiumdriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com/");
        //handle cookies
        driver.findElement(By.xpath("(//a[@class='yt-simple-endpoint style-scope ytd-button-renderer'])[12]")).click();
        driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[3]")).click();
        driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[5]")).click();
        driver.findElement(By.xpath("(//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qfvgSe tVK8Qc'])[2]")).click();
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void titleTest(){
        /*
        titleTest->Sayfanin basliginin YouTube oldugunu test edin
         */
        String expectedTitle="YouTube";
        Assert.assertEquals(expectedTitle,driver.getTitle());
    }
    @Test
    public void imageTest(){
        /*
        imageTest->YouTube resminin goruntulendigini test edin
        Search Box'in erisilebilir oludugunu test edin
         */
        Assert.assertTrue(driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search']")).isEnabled());
    }
    @Test
    public void wrongTitleTest(){
        //wrongTitleTest->Sayfa Basligiini
        //mesela basligin youtube olmadigini test edelim
        /*1.yol
        String expectedTitle="youtube";
        Assert.assertNotEquals(expectedTitle,driver.getTitle());
         */
        //2.yol
        Assert.assertFalse(driver.getTitle().equals("youtube"));
    }
}
