package utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowHandlesSet {
    WebDriver driver;
    public void handle(){
        String ilkSayfaHandle = driver.getWindowHandle();
        Set<String> windowHandlesSeti = driver.getWindowHandles();
        String ikinciSayfaHandle = "";
        for (String each : windowHandlesSeti) {
            if (!each.equals(ilkSayfaHandle)) {
                ikinciSayfaHandle = each;
            }
        }
        driver.switchTo().window(ikinciSayfaHandle);
    }
}
