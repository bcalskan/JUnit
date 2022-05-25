package task.TekrarSorulari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class Cookies extends TestBase {

    @Test
    public void test01() {
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
//2- tum cookie'leri listeleyin
        Set<Cookie> cookiesList = driver.manage().getCookies();

//3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookiesList.size() > 5);
//4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie each : cookiesList
        ) {
            if (each.getName().equals("i18n-prefs")) {
                Assert.assertTrue(each.getValue().equals("USD"));
            }
        }
//5- ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        cookiesList.add(cookie);
        cookiesList = driver.manage().getCookies();
        int sayac = 1;
        for (Cookie each : cookiesList) {
            System.out.println(sayac + ". cookie" + each);
            sayac++;
        }

//6- eklediginiz cookie'nin sayfaya eklendigini test edin

//7- ismi skin olan cookie'yi silin ve silindigini test edin
//8- tum cookie'leri silin ve silindigini test edin
    }
}
