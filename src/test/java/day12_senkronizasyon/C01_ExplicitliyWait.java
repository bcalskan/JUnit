package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitliyWait extends TestBase {

    @Test
    public void test01() {
        //1. Bir class olusturun : WaitTest
        //2. Iki tane metod olusturun : implicitWait() , explicitWait()
        //Iki metod icin de asagidaki adimlari test edin.
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        //4. Remove butonuna basin.
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        //6. Add buttonuna basin
        //7. It’s back mesajinin gorundugunu test edin
    }

    @Test
    public void implicitWait() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        WebElement itsGone = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGone.isDisplayed());
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        WebElement itsBack = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBack.isDisplayed());
    }

    @Test
    public void explicityWaitTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
       // WebElement itsGone = driver.findElement(By.xpath("//p[@id='message']"));
       // wait.until(ExpectedConditions.visibilityOf(itsGone));
       // Assert.assertTrue(itsGone.isDisplayed());


    }
}
