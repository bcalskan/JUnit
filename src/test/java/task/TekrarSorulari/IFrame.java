package task.TekrarSorulari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseClass;

import java.util.List;

public class IFrame extends TestBaseClass {
    //   ● Bir class olusturun: IframeTest
    //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
    //   ● Bir metod olusturun: iframeTest
    //        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
    //        ○ Text Box’a “Merhaba Dunya!” yazin.
    //        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.

    @Test
    public void test01() {
        //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
        //        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.

        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement anIframeText = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(anIframeText.isEnabled());
        System.out.println(anIframeText.getText());

        //        ○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframeElement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElement);
        WebElement searchBox = driver.findElement(By.xpath("//body[@id='tinymce']"));
        searchBox.clear();
        searchBox.sendKeys("Merhaba Dunya!");

        //        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement elementalText = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalText.isDisplayed());
        System.out.println(elementalText.getText());


    }
}
