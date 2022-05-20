package task.Questions2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBaseClass;

import java.util.List;
import java.util.Set;

public class Q14 extends TestBaseClass {
    //● Tests package’inda yeni bir class olusturun: WindowHandle2
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
    //doğrulayın.

    @Test
    public void test01() throws InterruptedException {

        //● Tests package’inda yeni bir class olusturun: WindowHandle2
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaHandle = driver.getWindowHandle();



        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedText = "Opening a new window";
        String actualText = driver.findElement(By.xpath("//*[text()='Opening a new window']")).getText();
        Assert.assertEquals(actualText, expectedText);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String arananKelime = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.equals(arananKelime));

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        //Thread.sleep(3000);

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Set<String> handlesList = driver.getWindowHandles();
        String ikinciSayfaHandle = "";
        for (String each : handlesList) {
            if (!each.equals(ilkSayfaHandle)) {
                ikinciSayfaHandle = each;
            }
        }
        driver.switchTo().window(ikinciSayfaHandle);
        String newActualTitle = driver.getTitle();
        System.out.println(newActualTitle);
        String expectedTitle = "New Window";
        System.out.println(expectedTitle);
        Assert.assertTrue(newActualTitle.equals(expectedTitle));

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expectedText2 = "New Window";
        String actualText2 = driver.findElement(By.xpath("(//*[text()='New Window'])[2]")).getText();
        Assert.assertTrue(actualText2.equals(expectedText2));

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu dogrulayin
        driver.switchTo().window(ilkSayfaHandle);
        String expectedTitleNew = "The Internet";
        String actualTitleNew = driver.getTitle();
        Assert.assertEquals(expectedTitleNew, actualTitleNew);

    }
}
