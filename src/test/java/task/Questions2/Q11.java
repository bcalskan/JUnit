package task.Questions2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseClass;

public class Q11 extends TestBaseClass {
    //● Bir class olusturun: IframeTest

    //● https://the-internet.herokuapp.com/iframe adresine gidin.

    //● Bir metod olusturun: iframeTest

    //○ “An IFrame containing....” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.

    //○ Text Box’a “Merhaba Dunya!” yazin.

    //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    //dogrulayin ve konsolda yazdirin.

    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //○ “An IFrame containing....” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement text = driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(text.isDisplayed());
        System.out.println(text.getText());

        //○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement iFrameElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrameElement);

        WebElement textKutusu = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textKutusu.clear();
        textKutusu.sendKeys("Merhaba Dunya!");

        //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //dogrulayin ve konsolda yazdirin.
        driver.switchTo().activeElement();
//        WebElement elemetal = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
//        Assert.assertTrue(elemetal.isDisplayed());
    }
}
