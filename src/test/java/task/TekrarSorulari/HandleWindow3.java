package task.TekrarSorulari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseImplicitly;

import java.util.Set;
import java.util.stream.Collectors;

public class HandleWindow3 extends TestBaseImplicitly {

    @Test
    public void name() {

//● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaHandleDegeri = driver.getWindowHandle();

//● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text = driver.findElement(By.xpath("//h3"));
        String expectedKelime = "Opening a new window";
        Assert.assertEquals(expectedKelime, text.getText());

//● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


//● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        Set<String> handles = driver.getWindowHandles();
        String ikinciSayfaHandleDegeri = handles.stream().filter(t -> !t.equals(ilkSayfaHandleDegeri)).collect(Collectors.toList()).get(0);
        driver.switchTo().window(ikinciSayfaHandleDegeri);

//● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String newExpectedTitle = "New Window";
        String newActualTitle = driver.getTitle();
        Assert.assertTrue(newActualTitle.equals(newExpectedTitle));


//● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String newText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "New Window";
        Assert.assertTrue(newText.equals(expectedText));


//● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandleDegeri);
        String ilkSayfaTitle = driver.getTitle();
        String arananTitle = "The Internet";
        Assert.assertTrue(ilkSayfaTitle.equals(arananTitle));



    }
}
