package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
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
    public static void before(){
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
    public void acceptAlert(){
        //● Bir metod olusturun: acceptAlert
        //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve
        //        result mesajının “You successfully clicked an alert” oldugunu test edin.

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        String actualText = driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']")).getText();
        String expectedTest = "You successfully clicked an alert";
        Assert.assertEquals(actualText, expectedTest);
    }

    @Test
    public void dismissAlert(){
        //● Bir metod olusturun: dismissAlert
        //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve
        //        result mesajının “successfuly” icermedigini test edin.

        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();

        String actualText = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();
        String notIncludeText = "successfuly";
        Assert.assertFalse(actualText.contains(notIncludeText));
    }




    @Test
    public void sendKeysAlert(){
        //● Bir metod olusturun: sendKeysAlert
        //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
        //        OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("berg");
        driver.switchTo().alert().accept();

        String actualText = driver.findElement(By.xpath("//*[text()='You entered: berg']")).getText();
        String expectedText = "berg";
        Assert.assertTrue(actualText.contains(expectedText));
    }



}
