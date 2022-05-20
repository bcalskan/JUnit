package task.TekrarSorulari;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBaseClass;

public class HandleWindow extends TestBaseClass {
    //1- amazona git
    //2- nutella icin arama yaptirin
    //3- ilk ürünün resmini tiklayarak farkli bir tab olarak acin
    //4- yeni tabda acilan ürünün titleini yazdirin
    //5- ilk sayfaya gecip url yazdir

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri = driver.getWindowHandle(); //--> ilk sayfanin handle degerini/ hash code´unu getirir

        //2- nutella icin arama yaptirin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //3- ilk ürünün resmini tiklayarak farkli bir tab olarak acin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        //4- yeni tabda acilan ürünün titleini yazdirin
        String title = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        System.out.println(title);

        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());


    }


}
