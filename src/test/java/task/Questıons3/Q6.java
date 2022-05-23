package task.Questıons3;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;
import utilities.TestBaseClass;
import utilities.TestBaseClassImplicitly;

import java.time.Duration;

public class Q6 extends TestBaseClassImplicitly {
    //1. Bir class olusturun : EnableTest
    //2. Bir metod olusturun : isEnabled(
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Textbox’in etkin olmadigini(enabled) dogrulayın
    //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    //7. Textbox’in etkin oldugunu(enabled) dogrulayın.

    @Test
    public void test01() {
        //1. Bir class olusturun : EnableTest
        //2. Bir metod olusturun : isEnabled(
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void EnableTest() {
        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
    }

    @Test
    public void isEnable() {
        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
//        WebElement itsEnabled = driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));
//        Assert.assertTrue(itsEnabled.isDisplayed());

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        //Assert.assertTrue(textBox.isEnabled());

    }
}
