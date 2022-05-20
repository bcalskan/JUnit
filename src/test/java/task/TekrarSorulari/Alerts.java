package task.TekrarSorulari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alerts {
    //● Bir class olusturun: Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.

    //● Bir metod olusturun: acceptAlert
    //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve
    //        result mesajının “You successfully clicked an alert” oldugunu test edin.

    //● Bir metod olusturun: dismissAlert
    //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve
    //        result mesajının “successfuly” icermedigini test edin.

    //● Bir metod olusturun: sendKeysAlert
    //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    //        OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    static WebDriver driver;

    @BeforeClass
    public static void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void after() {
        driver.quit();
    }

    @Test
    public void acceptAlert() {
        //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve
        //        result mesajının “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        String expectedText = "You successfully clicked an alert";
        String actualText = driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void dismissAlert() {
        //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve
        //        result mesajının “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String notExpectedText = "successfuly";
        String actualText2 = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();
        Assert.assertFalse(actualText2.contains(notExpectedText));
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
        //        OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Team10icindekiHainler");
        driver.switchTo().alert().accept();
        String girilenIsim = "Team10icindekiHainler";
        String actualIsim = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(actualIsim.contains(girilenIsim));
        Thread.sleep(2000);
    }

}
