package task.vomSlack;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class deneme extends TestBase {
    @Test
    public void test() {
        //1.“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //2.“Our Products” butonuna basin
        WebElement IFrameElementi = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(IFrameElementi);
        WebElement ourProduct = driver.findElement(By.xpath("//*[text()='Our Products']"));
        ourProduct.click();
        //3.Cameras product”i tiklayin
        driver.findElement(By.xpath("(//*[@class='thumbnail'])[2]")).click();

        //4.Popup mesajini yazdirin
        WebElement popUpText = driver.findElement(By.xpath("//div[@class='modal-body']"));
        System.out.println(popUpText.getText());

        //5.“close” butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();

        //6."WebdriverUniversity.com IFrame )" linkini tiklayin
        driver.switchTo().defaultContent();
        WebElement link = driver.findElement(By.xpath("//*[text()='WebdriverUniversity.com (IFrame)']"));
        link.click();

        //7."http://webdriveruniversity.com/index.html" adresine gittigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("http://webdriveruniversity.com/index.html"));
    }
}
