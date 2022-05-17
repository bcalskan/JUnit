package day05_jUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3. Login alanine  "username" yazdirin
        WebElement login = driver.findElement(By.xpath("//input[@id='user_login']"));
        login.sendKeys("username");

        //4. Password alanine "password" yazdirin
        WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
        login.sendKeys("password");

        //5. Sign in buttonuna tiklayin
        WebElement signInTikla = driver.findElement(By.xpath("//input[@name='submit']"));
        signInTikla.click();
        driver.navigate().back();

        //6. Pay Bills sayfasina gidin
        //driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        //driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();

        //driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        //driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amount.sendKeys("500");

        //8. tarih kismina "2020-09-10" yazdirin
        WebElement tarih = driver.findElement(By.xpath("//input[@id='sp_date']"));
        tarih.sendKeys("2023-05-13");

        //9. Pay buttonuna tiklayin
        WebElement pay = driver.findElement(By.xpath("//input[@id='pay_saved_payees']"));
        pay.click();

        //10. "The payment was successfully submitted." mesajinin ciktigini control edin
        System.out.println(driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']")).isDisplayed() ? "Payment test PASSED" : "Payment test FAILED");

    }
}
