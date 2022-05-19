package task.Questions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q8_AssertionsTask {
    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void after() {
        driver.close();
    }

    @Test
    public void urlTask(){
        driver.get("https://www.amazon.com");
        // urlin oldugunu https://www.facebook.com test edin

        String actualUrl = driver.getCurrentUrl(); //https://www.amazon.com
        String expectedUrl = "https://www.amazon.co";

        Assert.assertEquals("URL ayni degil",expectedUrl,actualUrl);
        //Message(+assert kismi) kismi equals false verdigi zaman terminalde gözükür.



    }

}
