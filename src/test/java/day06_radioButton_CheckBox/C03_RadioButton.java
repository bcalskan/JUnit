package day06_radioButton_CheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    WebDriver driver;
    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

    @Before
    public void before(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void after(){
        driver.close();
    }

    @Test
    public void run() throws InterruptedException {

        //-https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //-Cookies’i kabul edin
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();

        //-“Create an Account” button’una basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //-“radio buttons” elementlerini locate edin
        WebElement kadin = driver.findElement(By.xpath("//*[text()='Kadın']"));
        WebElement erkek = driver.findElement(By.xpath("//*[text()='Erkek']"));
        WebElement özel = driver.findElement(By.xpath("//*[text()='Özel']"));

        //-Secili degilse cinsiyet butonundan size uygun olani secin
        Thread.sleep(3000);
        if (!erkek.isSelected()){
            erkek.click();
        }


    }


}
