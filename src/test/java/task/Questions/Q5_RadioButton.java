package task.Questions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q5_RadioButton {
    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //-https://www.facebook.com adresine gidin
    //-Cookies’i kabul edin
    //-“Create an Account” button’una basin
    //-“radio buttons” elementlerini locate edin
    //-Secili degilse cinsiyet butonundan size uygun olani secin

    WebDriver driver;

    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void facebookTask() throws InterruptedException {


        //-https://www.facebook.com adresine gidin
        driver.get("https://facebook.com");

        //-Cookies’i kabul edin
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();

        //-“Create an Account” button’una basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //-“radio buttons” elementlerini locate edin
        WebElement kadin = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement erkek = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement özel = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));

        //-Secili degilse cinsiyet butonundan size uygun olani secin
        Thread.sleep(3000);
        if (!özel.isSelected()){
            özel.click();
        }
    }




    @After
    public void after(){
        //driver.close();
    }


}
