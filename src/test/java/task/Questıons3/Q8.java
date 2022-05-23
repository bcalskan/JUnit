package task.Questıons3;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseImplicitly;

public class Q8 extends TestBaseImplicitly {
    //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    //2. “Our Products” butonuna basin
    //3. “Cameras product”i tiklayin
    //4. Popup mesajini yazdirin
    //5. “close” butonuna basin
    //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
    //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin

    @Test
    public void test01(){
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //2. “Our Products” butonuna basin
        WebElement IFrame = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(IFrame);

        WebElement ourProducts = driver.findElement(By.xpath("//*[text()='Our Products']"));
        Actions actions = new Actions(driver);
        actions.click(ourProducts).perform();

        //3. “Cameras product”i tiklayin
        WebElement cameras = driver.findElement(By.xpath("//*[text()='Cameras']"));
        actions.click(cameras).perform();

        //4. Popup mesajini yazdirin
        WebElement popUpText = driver.findElement(By.xpath("//*[text()='Please Note: All orders must be over the value of £50, adding additional coupon codes to the basket are excluded from this offer. To receive 30% off please add the following code to the basket: ']"));
        System.out.println(popUpText.getText());

        //5. “close” butonuna basin
        WebElement close = driver.findElement(By.xpath("//*[text()='Close']"));
        actions.click(close).perform();

        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        WebElement IFrameLink = driver.findElement(By.xpath("(//a[@class='navbar-brand'])[1]"));
        actions.click(IFrameLink).perform();

        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedLink = "http://webdriveruniversity.com/index.html";
        String link = driver.getCurrentUrl();
        Assert.assertTrue(expectedLink.equals(link));



    }
}
