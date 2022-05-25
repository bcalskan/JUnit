package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class C02_TümSayfaScreenShot extends TestBase {
    @Test
    public void tümSayfa() throws IOException {
        //amazon sayfasina gidip tüm sayfanin ss´ini al
        driver.get("https://www.amazon.com");
        TakesScreenshot ts = (TakesScreenshot) driver;

        LocalDateTime date = LocalDateTime.now();
        System.out.println(date);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYYMMddHHmmss");
        String tarih = date.format(dtf);
        System.out.println(date);
        System.out.println(tarih);
        File tümSayfaResim = new File("target/screenShot/tümSayfa" + tarih + ".jpeg");

        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya, tümSayfaResim);
    }
}
