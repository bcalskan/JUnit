package day06_radioButton_CheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

//    @After
//    public void after(){
//        driver.close();
//    }

    @Test
    public void Test() {
        /*
        Eger methodumuzda hicbir test yoksa, test calistiktan sonra
        hicbir problemle karsilasilmadigini raporlamak icin test passed yazisi cikar.

        Eger testleri if ile yaparsak
        test failed olsa bile kodlar problemsiz calistigi icin
        kod calismasi bittiginda
        ekranin sol alt kisminda passed yazacaktir
         */
        driver.get("https://www.amazon.com");
        // urlin oldugunu https://www.facebook.com test edin


//        if(driver.getCurrentUrl().equals("https://www.facebook.com")){
//            System.out.println("URL test PASSED");
//        }else System.out.println("URL test FAILED");

        String expectedUrl = "https://www.facebook.com";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("URL beklenenden farkli",expectedUrl, actualUrl);
        /*
        Assert ile yapilan testlerde Assertion failed olursa
        java kodlarin calismasini durdurur ve assert classi
        bizi hata konusunda bilgilendirir

                org.junit.ComparisonFailure: URL beklenenden farkli
                Expected :https://www.facebook.com
                Actual   :https://www.amazon.com/
                <Click to see difference>

        böylece hatanin ne oldugunu arastirmamiza gerek kalmadan
        JUnit bize rapor verir

         */


    }

}
