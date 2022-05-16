package task.AutomationTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1_AutomationExercise1 {
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
//        driver.close();
    }

    @Test
    public void automationTask() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement anaSayfa = driver.findElement(By.xpath("//*[text()=' Home']"));
        if (anaSayfa.isDisplayed()) {
            System.out.println("Anasayfa görünür durumda");
        } else System.out.println("Anasayfa görünmüyor");


        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        //5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        System.out.println(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed() ?
                "New User Signup test PASSED" : "New User Signup test FAILED");

        //6. Adı ve e-posta adresini girin
        WebElement name = driver.findElement(By.name("name"));
        name.sendKeys("test");
        WebElement eMail = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        eMail.sendKeys("denemedd@gmail.com");

        //7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Signup']")).click();

        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed() ?
                "Hesap Bilgileri test PASSED" : "Hesap Bilgileri test FAILED");

        //9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
        driver.findElement(By.id("password")).sendKeys("password");

        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        driver.findElement(By.name("newsletter")).click();

        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        driver.findElement(By.xpath("//input[@name='optin']")).click();

        //12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("TechPro");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Education");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("TechPro");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Schulstraße");
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("13");
        driver.findElement(By.xpath("//select[@name='country']")).sendKeys("United States");
        driver.findElement(By.xpath("//select[@name='days']")).sendKeys("1");
        driver.findElement(By.xpath("//select[@name='months']")).sendKeys("April");
        driver.findElement(By.xpath("//select[@name='years']")).sendKeys("2000");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Bayern");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Erlangen");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("91080");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("05057714562");

        //13. 'Hesap Oluştur düğmesini' tıklayın
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();

        //14. 'HESAP OLUŞTURULDU!' görünür
        System.out.println(driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed() ?
                "Hesap olusturuldu test PASSED" : "Hesap olusturuldu test FAILED");

        //15. 'Devam' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

        //16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed() ?
                "Logged test PASSED" : "Logged test FAILED");

        //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();
        driver.findElement(By.xpath("//*[text()='Delete']")).click();


        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    }


}
